package com.careerit.jfs.cj.excelgen;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExcelManager {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ExcelGenerationUtil excelUtil = new ExcelGenerationUtil();
    private static final EnhancedExcelGenerationUtil enhancedExcelUtil = new EnhancedExcelGenerationUtil();

    public static void main(String[] args) {
        try {
            System.out.println("=== Generating Excel File from Players Data ===");
            
            // Generate basic Excel file
            String excelFilePath = generatePlayersExcel();
            System.out.println("Basic Excel file generated: " + excelFilePath);
            
            // Generate enhanced Excel file
            String enhancedExcelFilePath = generateEnhancedPlayersExcel();
            System.out.println("Enhanced Excel file generated: " + enhancedExcelFilePath);
            
            // Display statistics
            displayStatistics();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate basic Excel file with players data
     * @return Path to the generated Excel file
     */
    public static String generatePlayersExcel() {
        try {
            // Read players data from JSON
            List<Player> players = loadPlayersFromJson();
            
            // Generate Excel file
            String outputPath = "players_by_team.xlsx";
            String excelFilePath = excelUtil.generatePlayersExcel(players, outputPath);
            
            return excelFilePath;
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate Excel file", e);
        }
    }
    
    /**
     * Generate enhanced Excel file with players data
     * @return Path to the generated Excel file
     */
    public static String generateEnhancedPlayersExcel() {
        try {
            // Read players data from JSON
            List<Player> players = loadPlayersFromJson();
            
            // Generate enhanced Excel file
            String outputPath = "enhanced_players_by_team.xlsx";
            String excelFilePath = enhancedExcelUtil.generateEnhancedPlayersExcel(players, outputPath);
            
            return excelFilePath;
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate enhanced Excel file", e);
        }
    }

    /**
     * Load players data from JSON file
     * @return List of Player objects
     */
    private static List<Player> loadPlayersFromJson() {
        try {
            InputStream inputStream = ExcelManager.class.getClassLoader()
                    .getResourceAsStream("players.json");
            
            List<Player> players = objectMapper.readValue(inputStream, 
                    new TypeReference<List<Player>>() {});
            
            System.out.println("Loaded " + players.size() + " players from JSON");
            return players;
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to load players from JSON", e);
        }
    }

    /**
     * Display statistics about the players data
     */
    private static void displayStatistics() {
        try {
            List<Player> players = loadPlayersFromJson();
            
            // Group by team
            Map<String, List<Player>> playersByTeam = players.stream()
                    .collect(Collectors.groupingBy(Player::getTeam));
            
            System.out.println("\n=== Team Statistics ===");
            System.out.printf("%-15s %-10s %-15s %-15s%n", "Team", "Players", "Total Value", "Avg Value");
            System.out.println("=".repeat(60));
            
            for (Map.Entry<String, List<Player>> entry : playersByTeam.entrySet()) {
                String team = entry.getKey();
                List<Player> teamPlayers = entry.getValue();
                
                double totalValue = teamPlayers.stream()
                        .mapToDouble(Player::getPrice)
                        .sum();
                
                double avgValue = totalValue / teamPlayers.size();
                
                System.out.printf("%-15s %-10d %-15.2f %-15.2f%n", 
                        team, teamPlayers.size(), totalValue, avgValue);
            }
            
            // Role statistics
            System.out.println("\n=== Role Statistics ===");
            Map<String, Long> roleCounts = players.stream()
                    .collect(Collectors.groupingBy(Player::getRole, Collectors.counting()));
            
            roleCounts.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
            
            // Country statistics
            System.out.println("\n=== Country Statistics ===");
            Map<String, Long> countryCounts = players.stream()
                    .collect(Collectors.groupingBy(Player::getCountry, Collectors.counting()));
            
            countryCounts.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(10)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
            
            // Price statistics
            System.out.println("\n=== Price Statistics ===");
            double maxPrice = players.stream().mapToDouble(Player::getPrice).max().orElse(0);
            double minPrice = players.stream().mapToDouble(Player::getPrice).min().orElse(0);
            double avgPrice = players.stream().mapToDouble(Player::getPrice).average().orElse(0);
            
            System.out.printf("Highest Price: %.2f Cr%n", maxPrice);
            System.out.printf("Lowest Price: %.2f Cr%n", minPrice);
            System.out.printf("Average Price: %.2f Cr%n", avgPrice);
            
        } catch (Exception e) {
            System.err.println("Error displaying statistics: " + e.getMessage());
        }
    }
} 