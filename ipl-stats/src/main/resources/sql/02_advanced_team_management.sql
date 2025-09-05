-- =====================================================
-- Advanced PostgreSQL Script for Team Management
-- =====================================================
-- This script provides advanced functionality for team management
-- including views, functions, and procedures
-- Author: CareerIT Team
-- Date: 2025-08-28
-- =====================================================

-- =====================================================
-- 1. ENUMS FOR BETTER DATA INTEGRITY
-- =====================================================

-- Create enum for team status
CREATE TYPE team_status AS ENUM ('ACTIVE', 'INACTIVE', 'SUSPENDED');

-- Create enum for team type
CREATE TYPE team_type AS ENUM ('FRANCHISE', 'ASSOCIATE', 'AFFILIATE');

-- =====================================================
-- 2. ENHANCED TEAM_DETAILS TABLE
-- =====================================================

-- Add new columns to existing table
ALTER TABLE team_details 
ADD COLUMN IF NOT EXISTS status team_status DEFAULT 'ACTIVE',
ADD COLUMN IF NOT EXISTS team_type team_type DEFAULT 'FRANCHISE',
ADD COLUMN IF NOT EXISTS established_year INTEGER,
ADD COLUMN IF NOT EXISTS home_ground VARCHAR(100),
ADD COLUMN IF NOT EXISTS owner_name VARCHAR(100),
ADD COLUMN IF NOT EXISTS coach_name VARCHAR(100),
ADD COLUMN IF NOT EXISTS captain_name VARCHAR(100),
ADD COLUMN IF NOT EXISTS website_url VARCHAR(255),
ADD COLUMN IF NOT EXISTS social_media_handles JSONB,
ADD COLUMN IF NOT EXISTS is_deleted BOOLEAN DEFAULT FALSE,
ADD COLUMN IF NOT EXISTS deleted_date TIMESTAMP,
ADD COLUMN IF NOT EXISTS deleted_by UUID;

-- Add constraints for new columns
ALTER TABLE team_details 
ADD CONSTRAINT chk_established_year CHECK (established_year >= 2008 AND established_year <= EXTRACT(YEAR FROM CURRENT_DATE)),
ADD CONSTRAINT chk_home_ground_not_empty CHECK (home_ground IS NULL OR LENGTH(TRIM(home_ground)) > 0),
ADD CONSTRAINT chk_owner_name_not_empty CHECK (owner_name IS NULL OR LENGTH(TRIM(owner_name)) > 0),
ADD CONSTRAINT chk_coach_name_not_empty CHECK (coach_name IS NULL OR LENGTH(TRIM(coach_name)) > 0),
ADD CONSTRAINT chk_captain_name_not_empty CHECK (captain_name IS NULL OR LENGTH(TRIM(captain_name)) > 0),
ADD CONSTRAINT chk_website_url_format CHECK (website_url IS NULL OR website_url ~ '^https?://[^\s/$.?#].[^\s]*$'),
ADD CONSTRAINT chk_deleted_date_when_deleted CHECK (is_deleted = FALSE OR deleted_date IS NOT NULL),
ADD CONSTRAINT chk_deleted_by_when_deleted CHECK (is_deleted = FALSE OR deleted_by IS NOT NULL);

-- =====================================================
-- 3. ADDITIONAL INDEXES
-- =====================================================

-- Index on status for filtering active teams
CREATE INDEX IF NOT EXISTS idx_team_details_status ON team_details(status);

-- Index on team_type for categorization
CREATE INDEX IF NOT EXISTS idx_team_details_team_type ON team_details(team_type);

-- Index on established_year for historical queries
CREATE INDEX IF NOT EXISTS idx_team_details_established_year ON team_details(established_year);

-- Index on is_deleted for soft delete queries
CREATE INDEX IF NOT EXISTS idx_team_details_is_deleted ON team_details(is_deleted);

-- Composite index for active teams by city
CREATE INDEX IF NOT EXISTS idx_team_details_active_city ON team_details(city, status) WHERE is_deleted = FALSE;

-- =====================================================
-- 4. VIEWS FOR COMMON QUERIES
-- =====================================================

-- View for active teams only
CREATE OR REPLACE VIEW v_active_teams AS
SELECT 
    id,
    team_name,
    city,
    team_label,
    status,
    team_type,
    established_year,
    home_ground,
    owner_name,
    coach_name,
    captain_name,
    website_url,
    social_media_handles,
    created_date,
    modified_date
FROM team_details
WHERE is_deleted = FALSE AND status = 'ACTIVE';

-- View for team statistics
CREATE OR REPLACE VIEW v_team_statistics AS
SELECT 
    city,
    COUNT(*) as total_teams,
    COUNT(CASE WHEN status = 'ACTIVE' THEN 1 END) as active_teams,
    COUNT(CASE WHEN team_type = 'FRANCHISE' THEN 1 END) as franchise_teams,
    MIN(established_year) as oldest_team_year,
    MAX(established_year) as newest_team_year
FROM team_details
WHERE is_deleted = FALSE
GROUP BY city
ORDER BY total_teams DESC;

-- =====================================================
-- 5. FUNCTIONS FOR TEAM MANAGEMENT
-- =====================================================

-- Function to soft delete a team
CREATE OR REPLACE FUNCTION soft_delete_team(
    p_team_id UUID,
    p_deleted_by UUID
)
RETURNS BOOLEAN AS $$
BEGIN
    UPDATE team_details 
    SET 
        is_deleted = TRUE,
        deleted_date = CURRENT_TIMESTAMP,
        deleted_by = p_deleted_by,
        modified_date = CURRENT_TIMESTAMP,
        modified_by = p_deleted_by
    WHERE id = p_team_id AND is_deleted = FALSE;
    
    RETURN FOUND;
END;
$$ LANGUAGE plpgsql;

-- Function to restore a soft-deleted team
CREATE OR REPLACE FUNCTION restore_team(
    p_team_id UUID,
    p_restored_by UUID
)
RETURNS BOOLEAN AS $$
BEGIN
    UPDATE team_details 
    SET 
        is_deleted = FALSE,
        deleted_date = NULL,
        deleted_by = NULL,
        modified_date = CURRENT_TIMESTAMP,
        modified_by = p_restored_by
    WHERE id = p_team_id AND is_deleted = TRUE;
    
    RETURN FOUND;
END;
$$ LANGUAGE plpgsql;

-- Function to get team by label
CREATE OR REPLACE FUNCTION get_team_by_label(p_team_label VARCHAR)
RETURNS TABLE (
    team_id UUID,
    team_name VARCHAR,
    city VARCHAR,
    team_label VARCHAR,
    status team_status,
    established_year INTEGER,
    home_ground VARCHAR
) AS $$
BEGIN
    RETURN QUERY
    SELECT 
        td.id,
        td.team_name,
        td.city,
        td.team_label,
        td.status,
        td.established_year,
        td.home_ground
    FROM team_details td
    WHERE td.team_label = p_team_label 
    AND td.is_deleted = FALSE;
END;
$$ LANGUAGE plpgsql;

-- Function to search teams
CREATE OR REPLACE FUNCTION search_teams(
    p_search_term VARCHAR,
    p_city VARCHAR DEFAULT NULL,
    p_status team_status DEFAULT 'ACTIVE'
)
RETURNS TABLE (
    team_id UUID,
    team_name VARCHAR,
    city VARCHAR,
    team_label VARCHAR,
    status team_status,
    established_year INTEGER
) AS $$
BEGIN
    RETURN QUERY
    SELECT 
        td.id,
        td.team_name,
        td.city,
        td.team_label,
        td.status,
        td.established_year
    FROM team_details td
    WHERE td.is_deleted = FALSE
    AND td.status = p_status
    AND (p_city IS NULL OR td.city ILIKE '%' || p_city || '%')
    AND (
        td.team_name ILIKE '%' || p_search_term || '%' OR
        td.city ILIKE '%' || p_search_term || '%' OR
        td.team_label ILIKE '%' || p_search_term || '%'
    )
    ORDER BY td.team_name;
END;
$$ LANGUAGE plpgsql;

-- =====================================================
-- 6. STORED PROCEDURES
-- =====================================================

-- Procedure to update team information
CREATE OR REPLACE PROCEDURE update_team_info(
    p_team_id UUID,
    p_team_name VARCHAR DEFAULT NULL,
    p_city VARCHAR DEFAULT NULL,
    p_team_label VARCHAR DEFAULT NULL,
    p_home_ground VARCHAR DEFAULT NULL,
    p_owner_name VARCHAR DEFAULT NULL,
    p_coach_name VARCHAR DEFAULT NULL,
    p_captain_name VARCHAR DEFAULT NULL,
    p_website_url VARCHAR DEFAULT NULL,
    p_modified_by UUID
)
LANGUAGE plpgsql AS $$
BEGIN
    UPDATE team_details 
    SET 
        team_name = COALESCE(p_team_name, team_name),
        city = COALESCE(p_city, city),
        team_label = COALESCE(p_team_label, team_label),
        home_ground = COALESCE(p_home_ground, home_ground),
        owner_name = COALESCE(p_owner_name, owner_name),
        coach_name = COALESCE(p_coach_name, coach_name),
        captain_name = COALESCE(p_captain_name, captain_name),
        website_url = COALESCE(p_website_url, website_url),
        modified_date = CURRENT_TIMESTAMP,
        modified_by = p_modified_by
    WHERE id = p_team_id AND is_deleted = FALSE;
    
    IF NOT FOUND THEN
        RAISE EXCEPTION 'Team with ID % not found or already deleted', p_team_id;
    END IF;
END;
$$;

-- =====================================================
-- 7. SAMPLE DATA WITH ENHANCED INFORMATION
-- =====================================================

-- Update existing teams with additional information
UPDATE team_details SET 
    established_year = 2008,
    home_ground = 'M. Chinnaswamy Stadium',
    owner_name = 'United Spirits Limited',
    coach_name = 'Sanjay Bangar',
    captain_name = 'Faf du Plessis',
    website_url = 'https://www.royalchallengers.com',
    social_media_handles = '{"twitter": "@RCBTweets", "instagram": "@royalchallengersbangalore"}'::jsonb
WHERE team_label = 'RCB';

UPDATE team_details SET 
    established_year = 2008,
    home_ground = 'Wankhede Stadium',
    owner_name = 'Reliance Industries',
    coach_name = 'Mark Boucher',
    captain_name = 'Hardik Pandya',
    website_url = 'https://www.mumbaiindians.com',
    social_media_handles = '{"twitter": "@mipaltan", "instagram": "@mumbaiindians"}'::jsonb
WHERE team_label = 'MI';

UPDATE team_details SET 
    established_year = 2008,
    home_ground = 'M. A. Chidambaram Stadium',
    owner_name = 'India Cements',
    coach_name = 'Stephen Fleming',
    captain_name = 'MS Dhoni',
    website_url = 'https://www.chennaisuperkings.com',
    social_media_handles = '{"twitter": "@ChennaiIPL", "instagram": "@chennaiipl"}'::jsonb
WHERE team_label = 'CSK';

-- =====================================================
-- 8. USEFUL QUERIES FOR TESTING
-- =====================================================

-- Get all active teams with full information
-- SELECT * FROM v_active_teams ORDER BY team_name;

-- Search teams by term
-- SELECT * FROM search_teams('Mumbai', NULL, 'ACTIVE');

-- Get team statistics by city
-- SELECT * FROM v_team_statistics;

-- Get team by label
-- SELECT * FROM get_team_by_label('RCB');

-- Soft delete a team (example)
-- SELECT soft_delete_team('team-uuid-here', 'user-uuid-here');

-- Update team information (example)
-- CALL update_team_info('team-uuid-here', 'New Team Name', 'New City', 'NT', 'user-uuid-here');
