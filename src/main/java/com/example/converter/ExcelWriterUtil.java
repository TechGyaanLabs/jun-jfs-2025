package com.example.converter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriterUtil {
    
    public static void writeToExcel(List<Player> players, String outputFilePath) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Players");
            
            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Name", "Role", "Country", "Team", "Price"};
            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }
            
            // Create data rows
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                Row row = sheet.createRow(i + 1);
                
                row.createCell(0).setCellValue(player.getName());
                row.createCell(1).setCellValue(player.getRole());
                row.createCell(2).setCellValue(player.getCountry());
                row.createCell(3).setCellValue(player.getTeam());
                row.createCell(4).setCellValue(player.getPrice());
            }
            
            // Auto-size columns
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
            
            // Write to file
            try (FileOutputStream fileOut = new FileOutputStream(outputFilePath)) {
                workbook.write(fileOut);
            }
        }
    }
} 