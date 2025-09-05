-- =====================================================
-- Liquibase Changelog: Create Team Details Table
-- =====================================================
-- This script creates the team_details table based on BaseEntity and TeamDetails
-- Author: CareerIT Team
-- Date: 2025-08-28
-- =====================================================

-- Enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create team_details table
CREATE TABLE team_details (
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
    
    -- Additional fields for enhanced functionality
    status VARCHAR(20) DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'INACTIVE', 'SUSPENDED')),
    team_type VARCHAR(20) DEFAULT 'FRANCHISE' CHECK (team_type IN ('FRANCHISE', 'ASSOCIATE', 'AFFILIATE')),
    established_year INTEGER CHECK (established_year >= 2008 AND established_year <= EXTRACT(YEAR FROM CURRENT_DATE)),
    home_ground VARCHAR(100),
    owner_name VARCHAR(100),
    coach_name VARCHAR(100),
    captain_name VARCHAR(100),
    website_url VARCHAR(255) CHECK (website_url IS NULL OR website_url ~ '^https?://[^\s/$.?#].[^\s]*$'),
    social_media_handles JSONB,
    is_deleted BOOLEAN DEFAULT FALSE,
    deleted_date TIMESTAMP,
    deleted_by UUID,
    
    -- Constraints
    CONSTRAINT chk_team_name_not_empty CHECK (LENGTH(TRIM(team_name)) > 0),
    CONSTRAINT chk_city_not_empty CHECK (LENGTH(TRIM(city)) > 0),
    CONSTRAINT chk_team_label_not_empty CHECK (LENGTH(TRIM(team_label)) > 0),
    CONSTRAINT chk_created_date_not_future CHECK (created_date <= CURRENT_TIMESTAMP),
    CONSTRAINT chk_modified_date_not_future CHECK (modified_date <= CURRENT_TIMESTAMP),
    CONSTRAINT chk_modified_date_after_created CHECK (modified_date >= created_date),
    CONSTRAINT chk_deleted_date_when_deleted CHECK (is_deleted = FALSE OR deleted_date IS NOT NULL),
    CONSTRAINT chk_deleted_by_when_deleted CHECK (is_deleted = FALSE OR deleted_by IS NOT NULL)
);

-- Create indexes
CREATE INDEX idx_team_details_team_name ON team_details(team_name);
CREATE INDEX idx_team_details_city ON team_details(city);
CREATE INDEX idx_team_details_team_label ON team_details(team_label);
CREATE INDEX idx_team_details_status ON team_details(status);
CREATE INDEX idx_team_details_is_deleted ON team_details(is_deleted);
CREATE INDEX idx_team_details_created_date ON team_details(created_date);
CREATE INDEX idx_team_details_modified_date ON team_details(modified_date);

-- Insert sample data
INSERT INTO team_details (id, created_by, modified_by, team_name, city, team_label, established_year, home_ground, owner_name, coach_name, captain_name, website_url, social_media_handles) VALUES
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Royal Challengers Bangalore', 'Bangalore', 'RCB', 2008, 'M. Chinnaswamy Stadium', 'United Spirits Limited', 'Sanjay Bangar', 'Faf du Plessis', 'https://www.royalchallengers.com', '{"twitter": "@RCBTweets", "instagram": "@royalchallengersbangalore"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Mumbai Indians', 'Mumbai', 'MI', 2008, 'Wankhede Stadium', 'Reliance Industries', 'Mark Boucher', 'Hardik Pandya', 'https://www.mumbaiindians.com', '{"twitter": "@mipaltan", "instagram": "@mumbaiindians"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Chennai Super Kings', 'Chennai', 'CSK', 2008, 'M. A. Chidambaram Stadium', 'India Cements', 'Stephen Fleming', 'MS Dhoni', 'https://www.chennaisuperkings.com', '{"twitter": "@ChennaiIPL", "instagram": "@chennaiipl"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Kolkata Knight Riders', 'Kolkata', 'KKR', 2008, 'Eden Gardens', 'Knight Riders Sports Private Ltd', 'Chandrakant Pandit', 'Shreyas Iyer', 'https://www.kkr.in', '{"twitter": "@KKRiders", "instagram": "@kkriders"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Delhi Capitals', 'Delhi', 'DC', 2008, 'Arun Jaitley Stadium', 'GMR Group & JSW Group', 'Ricky Ponting', 'Rishabh Pant', 'https://www.delhicapitals.in', '{"twitter": "@DelhiCapitals", "instagram": "@delhicapitals"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Punjab Kings', 'Mohali', 'PBKS', 2008, 'Punjab Cricket Association Stadium', 'Preity Zinta, Ness Wadia, Mohit Burman', 'Trevor Bayliss', 'Shikhar Dhawan', 'https://www.punjabkingsipl.in', '{"twitter": "@PunjabKingsIPL", "instagram": "@punjabkingsipl"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Rajasthan Royals', 'Jaipur', 'RR', 2008, 'Sawai Mansingh Stadium', 'Rajasthan Royals Sports Private Ltd', 'Kumar Sangakkara', 'Sanju Samson', 'https://www.rajasthanroyals.com', '{"twitter": "@rajasthanroyals", "instagram": "@rajasthanroyals"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Sunrisers Hyderabad', 'Hyderabad', 'SRH', 2013, 'Rajiv Gandhi International Cricket Stadium', 'Sun TV Network', 'Brian Lara', 'Aiden Markram', 'https://www.sunrisershyderabad.in', '{"twitter": "@SunRisers", "instagram": "@sunrisershyderabad"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Gujarat Titans', 'Ahmedabad', 'GT', 2022, 'Narendra Modi Stadium', 'CVC Capital Partners', 'Ashish Nehra', 'Shubman Gill', 'https://www.gujarattitansipl.com', '{"twitter": "@gujarat_titans", "instagram": "@gujarat_titans"}'::jsonb),
    (uuid_generate_v4(), uuid_generate_v4(), uuid_generate_v4(), 'Lucknow Super Giants', 'Lucknow', 'LSG', 2022, 'Bharat Ratna Shri Atal Bihari Vajpayee Ekana Cricket Stadium', 'RPSG Group', 'Justin Langer', 'KL Rahul', 'https://www.lucknowsupergiants.in', '{"twitter": "@LucknowIPL", "instagram": "@lucknowsupergiants"}'::jsonb)
ON CONFLICT (id) DO NOTHING;
