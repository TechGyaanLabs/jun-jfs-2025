-- =====================================================
-- PostgreSQL Script for BaseEntity and TeamDetails
-- =====================================================
-- This script creates tables based on BaseEntity and TeamDetails classes
-- Author: CareerIT Team
-- Date: 2025-08-28
-- =====================================================

-- Enable UUID extension if not already enabled
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- =====================================================
-- 1. TEAM_DETAILS TABLE
-- =====================================================
-- This table extends BaseEntity and contains team information
CREATE TABLE IF NOT EXISTS team_details (
    -- BaseEntity fields
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID NOT NULL,
    modified_by UUID NOT NULL,
    
    -- TeamDetails specific fields
    team_name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    team_label VARCHAR(50) NOT NULL,
    
    -- Constraints
    CONSTRAINT chk_team_name_not_empty CHECK (LENGTH(TRIM(team_name)) > 0),
    CONSTRAINT chk_city_not_empty CHECK (LENGTH(TRIM(city)) > 0),
    CONSTRAINT chk_team_label_not_empty CHECK (LENGTH(TRIM(team_label)) > 0),
    CONSTRAINT chk_created_date_not_future CHECK (created_date <= CURRENT_TIMESTAMP),
    CONSTRAINT chk_modified_date_not_future CHECK (modified_date <= CURRENT_TIMESTAMP),
    CONSTRAINT chk_modified_date_after_created CHECK (modified_date >= created_date)
);

-- =====================================================
-- 2. INDEXES FOR PERFORMANCE
-- =====================================================

-- Index on team_name for faster lookups
CREATE INDEX IF NOT EXISTS idx_team_details_team_name ON team_details(team_name);

-- Index on city for location-based queries
CREATE INDEX IF NOT EXISTS idx_team_details_city ON team_details(city);

-- Index on team_label for quick team identification
CREATE INDEX IF NOT EXISTS idx_team_details_team_label ON team_details(team_label);

-- Index on created_date for audit queries
CREATE INDEX IF NOT EXISTS idx_team_details_created_date ON team_details(created_date);

-- Index on modified_date for recent changes tracking
CREATE INDEX IF NOT EXISTS idx_team_details_modified_date ON team_details(modified_date);

-- Composite index for created_by and created_date
CREATE INDEX IF NOT EXISTS idx_team_details_created_by_date ON team_details(created_by, created_date);

-- =====================================================
-- 3. COMMENTS FOR DOCUMENTATION
-- =====================================================

COMMENT ON TABLE team_details IS 'Stores IPL team information with audit trail';
COMMENT ON COLUMN team_details.id IS 'Unique identifier for the team (UUID)';
COMMENT ON COLUMN team_details.created_date IS 'Timestamp when the record was created';
COMMENT ON COLUMN team_details.modified_date IS 'Timestamp when the record was last modified';
COMMENT ON COLUMN team_details.created_by IS 'UUID of the user who created the record';
COMMENT ON COLUMN team_details.modified_by IS 'UUID of the user who last modified the record';
COMMENT ON COLUMN team_details.team_name IS 'Full name of the IPL team';
COMMENT ON COLUMN team_details.city IS 'City where the team is based';
COMMENT ON COLUMN team_details.team_label IS 'Short label/abbreviation for the team';

-- =====================================================
-- 4. TRIGGERS FOR AUTOMATIC TIMESTAMP UPDATES
-- =====================================================

-- Function to update modified_date on row update
CREATE OR REPLACE FUNCTION update_modified_date()
RETURNS TRIGGER AS $$
BEGIN
    NEW.modified_date = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger to automatically update modified_date
CREATE TRIGGER trg_team_details_update_modified_date
    BEFORE UPDATE ON team_details
    FOR EACH ROW
    EXECUTE FUNCTION update_modified_date();

-- =====================================================
-- 5. SAMPLE DATA INSERTION
-- =====================================================

-- Insert sample IPL teams
INSERT INTO team_details (id, created_by, modified_by, team_name, city, team_label) VALUES
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Royal Challengers Bangalore', 'Bangalore', 'RCB'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Mumbai Indians', 'Mumbai', 'MI'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Chennai Super Kings', 'Chennai', 'CSK'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Kolkata Knight Riders', 'Kolkata', 'KKR'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Delhi Capitals', 'Delhi', 'DC'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Punjab Kings', 'Mohali', 'PBKS'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Rajasthan Royals', 'Jaipur', 'RR'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Sunrisers Hyderabad', 'Hyderabad', 'SRH'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Gujarat Titans', 'Ahmedabad', 'GT'),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Lucknow Super Giants', 'Lucknow', 'LSG')
ON CONFLICT (id) DO NOTHING;

-- =====================================================
-- 6. USEFUL QUERIES FOR TESTING
-- =====================================================

-- Query to get all teams with their audit information
-- SELECT 
--     team_name,
--     city,
--     team_label,
--     created_date,
--     modified_date,
--     created_by,
--     modified_by
-- FROM team_details
-- ORDER BY created_date DESC;

-- Query to get teams by city
-- SELECT team_name, team_label, city
-- FROM team_details
-- WHERE city = 'Mumbai'
-- ORDER BY team_name;

-- Query to get recent changes (last 7 days)
-- SELECT team_name, modified_date, modified_by
-- FROM team_details
-- WHERE modified_date >= CURRENT_DATE - INTERVAL '7 days'
-- ORDER BY modified_date DESC;
