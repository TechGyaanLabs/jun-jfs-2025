package com.careerit.jfs.cj.excelgen;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExcelGenerationUtil {

    /**
     * Generate Excel file with players grouped by team in separate sheets
     * @param players List of all players
     * @param outputFilePath Path where Excel file should be saved
     * @return Generated Excel file path
     */
    public String generatePlayersExcel(List<Player> players, String outputFilePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            
            // Group players by team
            Map<String, List<Player>> playersByTeam = players.stream()
                    .collect(Collectors.groupingBy(Player::getTeam));
            
            // Create a sheet for each team
            for (Map.Entry<String, List<Player>> entry : playersByTeam.entrySet()) {
                String teamName = entry.getKey();
                List<Player> teamPlayers = entry.getValue();
                
                createTeamSheet(workbook, teamName, teamPlayers);
            }
            
            // Write to file
            try (FileOutputStream fileOut = new FileOutputStream(outputFilePath)) {
                workbook.write(fileOut);
            }
            
            return outputFilePath;
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate Excel file", e);
        }
    }
    
    /**
     * Create a sheet for a specific team
     * @param workbook Excel workbook
     * @param teamName Name of the team (sheet name)
     * @param players List of players in the team
     */
    private void createTeamSheet(Workbook workbook, String teamName, List<Player> players) {
        Sheet sheet = workbook.createSheet(teamName);
        
        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Name", "Role", "Country", "Team", "Price (Cr)"};
        
        CellStyle headerStyle = createHeaderStyle(workbook);
        
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Create data rows
        CellStyle dataStyle = createDataStyle(workbook);
        CellStyle priceStyle = createPriceStyle(workbook);
        
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Row row = sheet.createRow(i + 1);
            
            // Name
            Cell nameCell = row.createCell(0);
            nameCell.setCellValue(player.getName());
            nameCell.setCellStyle(dataStyle);
            
            // Role
            Cell roleCell = row.createCell(1);
            roleCell.setCellValue(player.getRole());
            roleCell.setCellStyle(dataStyle);
            
            // Country
            Cell countryCell = row.createCell(2);
            countryCell.setCellValue(player.getCountry());
            countryCell.setCellStyle(dataStyle);
            
            // Team
            Cell teamCell = row.createCell(3);
            teamCell.setCellValue(player.getTeam());
            teamCell.setCellStyle(dataStyle);
            
            // Price
            Cell priceCell = row.createCell(4);
            priceCell.setCellValue(player.getPrice());
            priceCell.setCellStyle(priceStyle);
        }
        
        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
        
        // Add some padding to columns
        for (int i = 0; i < headers.length; i++) {
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 500);
        }
    }
    
    /**
     * Create header cell style
     */
    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        
        return style;
    }
    
    /**
     * Create data cell style
     */
    private CellStyle createDataStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        
        return style;
    }
    
    /**
     * Create price cell style with currency format
     */
    private CellStyle createPriceStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        
        // Create currency format
        DataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("#,##0.00"));
        
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        
        return style;
    }
} 