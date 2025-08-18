package com.careerit.jfs.cj.iplstatsusingdb.util;

import com.careerit.jfs.cj.iplstatsusingdb.dto.PlayerDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.UUID;

public class DataLoaderUtil {
    
    private static final String CREATE_TABLE_SQL = """
            CREATE TABLE IF NOT EXISTS players (
                id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                name VARCHAR(100) NOT NULL,
                role VARCHAR(50) NOT NULL,
                country VARCHAR(50) NOT NULL,
                team VARCHAR(10) NOT NULL,
                price DECIMAL(8,2) NOT NULL
            )
            """;
    
    private static final String INSERT_PLAYER_SQL = """
            INSERT INTO players (id, name, role, country, team, price)
            VALUES (?, ?, ?, ?, ?, ?)
            """;
    
    private static final String CLEAR_TABLE_SQL = "DELETE FROM players";
    
    public static void createTable() {
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Players table created successfully");
            
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
            throw new RuntimeException("Failed to create table", e);
        }
    }
    
    public static void loadDataFromJson() {
        try {
            // Read JSON data
            List<PlayerDto> players = readPlayersFromJson();
            System.out.println("Loaded " + players.size() + " players from JSON");
            
            // Clear existing data
            clearTable();
            
            // Insert data into database
            insertPlayers(players);
            
            System.out.println("Data loaded successfully to PostgreSQL");
            
        } catch (Exception e) {
            System.err.println("Error loading data: " + e.getMessage());
            throw new RuntimeException("Failed to load data", e);
        }
    }
    
    private static List<PlayerDto> readPlayersFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = DataLoaderUtil.class.getClassLoader()
                .getResourceAsStream("players.json")) {
            
            if (inputStream == null) {
                throw new RuntimeException("players.json file not found in resources");
            }
            
            return mapper.readValue(inputStream, new TypeReference<List<PlayerDto>>() {});
        }
    }
    
    private static void clearTable() {
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(CLEAR_TABLE_SQL);
            System.out.println("Existing data cleared");
            
        } catch (SQLException e) {
            System.err.println("Error clearing table: " + e.getMessage());
            throw new RuntimeException("Failed to clear table", e);
        }
    }
    
    private static void insertPlayers(List<PlayerDto> players) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_PLAYER_SQL)) {
            
            conn.setAutoCommit(false);
            
            final int BATCH_SIZE = 100;
            int totalInserted = 0;
            
            for (int i = 0; i < players.size(); i++) {
                PlayerDto player = players.get(i);
                ps.setObject(1, UUID.randomUUID()); // Generate new UUID for each player
                ps.setString(2, player.getName());
                ps.setString(3, player.getRole());
                ps.setString(4, player.getCountry());
                ps.setString(5, player.getTeam());
                ps.setDouble(6, player.getPrice());
                ps.addBatch();
                
                // Execute batch when batch size is reached or at the end
                if ((i + 1) % BATCH_SIZE == 0 || (i + 1) == players.size()) {
                    int[] results = ps.executeBatch();
                    totalInserted += results.length;
                    System.out.println("Processed batch: " + (i + 1) + " players");
                }
            }
            
            conn.commit();
            System.out.println("Total inserted: " + totalInserted + " players");
            
        } catch (SQLException e) {
            System.err.println("Error inserting players: " + e.getMessage());
            throw new RuntimeException("Failed to insert players", e);
        }
    }
    
    public static void displayLoadedData() {
        String selectSql = "SELECT * FROM players ORDER BY team, name";
        
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql)) {
            
            System.out.println("\n=== Loaded Players Data ===");
            System.out.printf("%-36s %-25s %-15s %-15s %-8s %-8s%n", 
                "ID", "Name", "Role", "Country", "Team", "Price");
            System.out.println("-".repeat(120));
            
            while (rs.next()) {
                System.out.printf("%-36s %-25s %-15s %-15s %-8s %-8.2f%n",
                    rs.getObject("id"),
                    rs.getString("name"),
                    rs.getString("role"),
                    rs.getString("country"),
                    rs.getString("team"),
                    rs.getDouble("price")
                );
            }
            
        } catch (SQLException e) {
            System.err.println("Error displaying data: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        try {
            // Test database connection
            if (!DatabaseUtil.testConnection()) {
                System.err.println("Database connection failed!");
                return;
            }
            
            System.out.println("Database connection successful!");
            
            // Create table
            createTable();
            
            // Load data
            loadDataFromJson();
            
            // Display loaded data
            displayLoadedData();
            
        } catch (Exception e) {
            System.err.println("Error in main: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
