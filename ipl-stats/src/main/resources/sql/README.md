# PostgreSQL SQL Scripts for BaseEntity and TeamDetails

This directory contains comprehensive SQL scripts for creating and managing database tables based on the `BaseEntity` and `TeamDetails` Java classes.

## 📁 File Structure

```
sql/
├── README.md                                    # This documentation file
├── 01_create_base_entity_tables.sql            # Basic table creation script
├── 02_advanced_team_management.sql             # Advanced features and functions
└── main-migration/2025-09/
    └── V1__3_create_team_details.sql           # Liquibase migration script
```

## 🚀 Quick Start

### Option 1: Direct SQL Execution
```bash
# Connect to your PostgreSQL database
psql -h localhost -U postgres -d ipl_stats

# Run the basic table creation script
\i 01_create_base_entity_tables.sql

# Run the advanced features script (optional)
\i 02_advanced_team_management.sql
```

### Option 2: Using Liquibase (Recommended)
The scripts are integrated with your existing Liquibase setup. Simply run your Spring Boot application and the migrations will be applied automatically.

## 📋 Table Structure

### BaseEntity Fields (Inherited by all entities)
| Field | Type | Description | Constraints |
|-------|------|-------------|-------------|
| `id` | UUID | Primary key | Auto-generated |
| `created_date` | TIMESTAMP | Record creation time | NOT NULL, DEFAULT CURRENT_TIMESTAMP |
| `modified_date` | TIMESTAMP | Last modification time | NOT NULL, DEFAULT CURRENT_TIMESTAMP |
| `created_by` | UUID | User who created the record | NOT NULL |
| `modified_by` | UUID | User who last modified the record | NOT NULL |

### TeamDetails Fields
| Field | Type | Description | Constraints |
|-------|------|-------------|-------------|
| `team_name` | VARCHAR(100) | Full team name | NOT NULL, NOT EMPTY |
| `city` | VARCHAR(100) | Team's home city | NOT NULL, NOT EMPTY |
| `team_label` | VARCHAR(50) | Team abbreviation | NOT NULL, NOT EMPTY |
| `status` | VARCHAR(20) | Team status | DEFAULT 'ACTIVE', CHECK constraint |
| `team_type` | VARCHAR(20) | Type of team | DEFAULT 'FRANCHISE', CHECK constraint |
| `established_year` | INTEGER | Year team was established | CHECK (2008 <= year <= current) |
| `home_ground` | VARCHAR(100) | Stadium name | Optional |
| `owner_name` | VARCHAR(100) | Team owner | Optional |
| `coach_name` | VARCHAR(100) | Current coach | Optional |
| `captain_name` | VARCHAR(100) | Current captain | Optional |
| `website_url` | VARCHAR(255) | Official website | Optional, URL format validation |
| `social_media_handles` | JSONB | Social media links | Optional, JSON format |
| `is_deleted` | BOOLEAN | Soft delete flag | DEFAULT FALSE |
| `deleted_date` | TIMESTAMP | Deletion timestamp | Optional |
| `deleted_by` | UUID | User who deleted | Optional |

## 🔧 Features

### 1. Basic Table Creation (`01_create_base_entity_tables.sql`)
- ✅ Creates `team_details` table with BaseEntity fields
- ✅ Adds comprehensive constraints and validations
- ✅ Creates performance indexes
- ✅ Adds table and column comments
- ✅ Includes sample data for all 10 IPL teams
- ✅ Sets up automatic timestamp update triggers

### 2. Advanced Features (`02_advanced_team_management.sql`)
- ✅ Adds enhanced fields (status, team_type, etc.)
- ✅ Creates useful views (`v_active_teams`, `v_team_statistics`)
- ✅ Implements soft delete functionality
- ✅ Adds search and utility functions
- ✅ Creates stored procedures for team management
- ✅ Includes comprehensive sample data

### 3. Liquibase Integration (`V1__3_create_team_details.sql`)
- ✅ Integrated with existing migration system
- ✅ Includes all essential features
- ✅ Sample data for immediate testing
- ✅ Compatible with Spring Boot Liquibase

## 📊 Sample Data

The scripts include sample data for all 10 IPL teams:

| Team | City | Label | Established | Home Ground |
|------|------|-------|-------------|-------------|
| Royal Challengers Bangalore | Bangalore | RCB | 2008 | M. Chinnaswamy Stadium |
| Mumbai Indians | Mumbai | MI | 2008 | Wankhede Stadium |
| Chennai Super Kings | Chennai | CSK | 2008 | M. A. Chidambaram Stadium |
| Kolkata Knight Riders | Kolkata | KKR | 2008 | Eden Gardens |
| Delhi Capitals | Delhi | DC | 2008 | Arun Jaitley Stadium |
| Punjab Kings | Mohali | PBKS | 2008 | Punjab Cricket Association Stadium |
| Rajasthan Royals | Jaipur | RR | 2008 | Sawai Mansingh Stadium |
| Sunrisers Hyderabad | Hyderabad | SRH | 2013 | Rajiv Gandhi International Cricket Stadium |
| Gujarat Titans | Ahmedabad | GT | 2022 | Narendra Modi Stadium |
| Lucknow Super Giants | Lucknow | LSG | 2022 | Bharat Ratna Shri Atal Bihari Vajpayee Ekana Cricket Stadium |

## 🔍 Useful Queries

### Get All Active Teams
```sql
SELECT * FROM v_active_teams ORDER BY team_name;
```

### Search Teams
```sql
-- Search by term
SELECT * FROM search_teams('Mumbai', NULL, 'ACTIVE');

-- Get team by label
SELECT * FROM get_team_by_label('RCB');
```

### Team Statistics
```sql
-- Get statistics by city
SELECT * FROM v_team_statistics;

-- Get recent changes
SELECT team_name, modified_date, modified_by
FROM team_details
WHERE modified_date >= CURRENT_DATE - INTERVAL '7 days'
ORDER BY modified_date DESC;
```

### Soft Delete Operations
```sql
-- Soft delete a team
SELECT soft_delete_team('team-uuid-here', 'user-uuid-here');

-- Restore a team
SELECT restore_team('team-uuid-here', 'user-uuid-here');
```

### Update Team Information
```sql
-- Update team details
CALL update_team_info(
    'team-uuid-here',
    'New Team Name',
    'New City',
    'NT',
    'New Stadium',
    'New Owner',
    'New Coach',
    'New Captain',
    'https://newwebsite.com',
    'user-uuid-here'
);
```

## 🛡️ Security & Best Practices

### Data Validation
- ✅ All string fields have length constraints
- ✅ Email and URL fields have format validation
- ✅ Date fields have logical constraints
- ✅ Required fields are properly enforced

### Performance
- ✅ Strategic indexes for common queries
- ✅ Composite indexes for complex queries
- ✅ Partial indexes for filtered queries

### Audit Trail
- ✅ Complete creation and modification tracking
- ✅ Soft delete functionality
- ✅ Automatic timestamp updates
- ✅ User tracking for all operations

## 🚨 Important Notes

1. **UUID Extension**: The scripts enable the `uuid-ossp` extension for UUID generation
2. **Constraints**: All constraints are designed to maintain data integrity
3. **Indexes**: Indexes are optimized for common query patterns
4. **Soft Delete**: Use soft delete functions instead of hard deletes
5. **Triggers**: Automatic timestamp updates are handled by triggers

## 🔄 Migration Strategy

1. **Development**: Use the basic script for initial setup
2. **Testing**: Use the advanced script for comprehensive testing
3. **Production**: Use Liquibase migration for controlled deployment

## 📞 Support

For questions or issues with these scripts, please contact the CareerIT team or refer to the project documentation.

---

**Created by**: CareerIT Team  
**Last Updated**: 2025-08-28  
**Version**: 1.0.0
