package com.example.converter;

import java.util.List;

public class MainConverter {
    
    public static void main(String[] args) {
        try {
            // Read players from JSON
            System.out.println("Reading players from JSON...");
            List<Player> players = JsonReaderUtil.readPlayers("players.json");
            System.out.println("Found " + players.size() + " players");
            
            // Convert to CSV
            System.out.println("Converting to CSV...");
            CsvWriterUtil.writeToCsv(players, "players.csv");
            System.out.println("CSV file created: players.csv");
            
            // Convert to Excel
            System.out.println("Converting to Excel...");
            ExcelWriterUtil.writeToExcel(players, "players.xlsx");
            System.out.println("Excel file created: players.xlsx");
            
            // Convert to XML
            System.out.println("Converting to XML...");
            PdfWriterUtil.writeXml(players, "players.xml");
            System.out.println("XML file created: players.xml");
            
            // Convert XML to PDF using XSL
            System.out.println("Converting XML to PDF...");
            PdfWriterUtil.writeToPdf("players.xml", "src/main/resources/template.xsl", "players.pdf");
            System.out.println("PDF file created: players.pdf");
            
            System.out.println("All conversions completed successfully!");
            
        } catch (Exception e) {
            System.err.println("Error during conversion: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 