package com.example.converter;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterUtil {
    
    public static void writeToCsv(List<Player> players, String outputFilePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            // Write header
            String[] header = {"name", "role", "country", "team", "price"};
            writer.writeNext(header);
            
            // Write data
            for (Player player : players) {
                String[] row = {
                    player.getName(),
                    player.getRole(),
                    player.getCountry(),
                    player.getTeam(),
                    String.valueOf(player.getPrice())
                };
                writer.writeNext(row);
            }
        }
    }
} 