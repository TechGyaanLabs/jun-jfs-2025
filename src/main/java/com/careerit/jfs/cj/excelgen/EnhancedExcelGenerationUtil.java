package com.careerit.jfs.cj.excelgen;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnhancedExcelGenerationUtil {

    /**
     * Generate enhanced Excel file with players grouped by team
     * @param players List of all players
     * @param outputFilePath Path where Excel file should be saved
     * @return Generated Excel file path
     */
    public String generateEnhancedPlayersExcel(List<Player> players, String outputFilePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            
            // Group players by team
            Map<String, List<Player>> playersByTeam = players.stream()
                    .collect(Collectors.groupingBy(Player::getTeam));
            
            // Create summary sheet
            createSummarySheet(workbook, playersByTeam);
            
            // Create a sheet for each team
            for (Map.Entry<String, List<Player>> entry : playersByTeam.entrySet()) {
                String teamName = entry.getKey();
                List<Player> teamPlayers = entry.getValue();
                
                createEnhancedTeamSheet(workbook, teamName, teamPlayers);
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
     * Create summary sheet with team statistics
     */
    private void createSummarySheet(Workbook workbook, Map<String, List<Player>> playersByTeam) {
        Sheet sheet = workbook.createSheet("Summary");
        
        // Title
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("IPL 2025 - Team Summary");
        titleCell.setCellStyle(createTitleStyle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        
        // Headers
        Row headerRow = sheet.createRow(2);
        String[] headers = {"Team", "Total Players", "Total Value (Cr)", "Avg Value (Cr)", "Top Player"};
        
        CellStyle headerStyle = createHeaderStyle(workbook);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Data rows
        int rowNum = 3;
        CellStyle dataStyle = createDataStyle(workbook);
        CellStyle currencyStyle = createCurrencyStyle(workbook);
        
        for (Map.Entry<String, List<Player>> entry : playersByTeam.entrySet()) {
            String teamName = entry.getKey();
            List<Player> teamPlayers = entry.getValue();
            
            Row row = sheet.createRow(rowNum++);
            
            // Team name
            Cell teamCell = row.createCell(0);
            teamCell.setCellValue(teamName);
            teamCell.setCellStyle(dataStyle);
            
            // Total players
            Cell countCell = row.createCell(1);
            countCell.setCellValue(teamPlayers.size());
            countCell.setCellStyle(dataStyle);
            
            // Total value
            double totalValue = teamPlayers.stream().mapToDouble(Player::getPrice).sum();
            Cell totalCell = row.createCell(2);
            totalCell.setCellValue(totalValue);
            totalCell.setCellStyle(currencyStyle);
            
            // Average value
            double avgValue = totalValue / teamPlayers.size();
            Cell avgCell = row.createCell(3);
            avgCell.setCellValue(avgValue);
            avgCell.setCellStyle(currencyStyle);
            
            // Top player
            Player topPlayer = teamPlayers.stream()
                    .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                    .orElse(null);
            Cell topPlayerCell = row.createCell(4);
            if (topPlayer != null) {
                topPlayerCell.setCellValue(topPlayer.getName() + " (" + topPlayer.getPrice() + " Cr)");
            }
            topPlayerCell.setCellStyle(dataStyle);
        }
        
        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }
    
    /**
     * Create enhanced team sheet with better formatting
     */
    private void createEnhancedTeamSheet(Workbook workbook, String teamName, List<Player> players) {
        Sheet sheet = workbook.createSheet(teamName);
        
        // Team title
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(teamName + " - Player Roster");
        titleCell.setCellStyle(createTitleStyle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        
        // Team summary
        Row summaryRow = sheet.createRow(1);
        Cell summaryCell = summaryRow.createCell(0);
        double totalValue = players.stream().mapToDouble(Player::getPrice).sum();
        summaryCell.setCellValue("Total Players: " + players.size() + " | Total Value: " + 
                String.format("%.2f", totalValue) + " Cr | Average Value: " + 
                String.format("%.2f", totalValue / players.size()) + " Cr");
        summaryCell.setCellStyle(createSummaryStyle(workbook));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
        
        // Create header row
        Row headerRow = sheet.createRow(3);
        String[] headers = {"Name", "Role", "Country", "Team", "Price (Cr)"};
        
        CellStyle headerStyle = createHeaderStyle(workbook);
        
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Create data rows with conditional formatting
        CellStyle dataStyle = createDataStyle(workbook);
        CellStyle priceStyle = createPriceStyle(workbook);
        CellStyle highValueStyle = createHighValueStyle(workbook);
        
        // Sort players by price (descending)
        List<Player> sortedPlayers = players.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .collect(Collectors.toList());
        
        for (int i = 0; i < sortedPlayers.size(); i++) {
            Player player = sortedPlayers.get(i);
            Row row = sheet.createRow(i + 4);
            
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
            
            // Price with conditional formatting
            Cell priceCell = row.createCell(4);
            priceCell.setCellValue(player.getPrice());
            
            // Apply high value styling for players above 15 Cr
            if (player.getPrice() > 15.0) {
                priceCell.setCellStyle(highValueStyle);
            } else {
                priceCell.setCellStyle(priceStyle);
            }
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
     * Create title cell style
     */
    private CellStyle createTitleStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        
        style.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        
        return style;
    }
    
    /**
     * Create summary cell style
     */
    private CellStyle createSummaryStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        
        return style;
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
    
    /**
     * Create high value cell style
     */
    private CellStyle createHighValueStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        
        DataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("#,##0.00"));
        
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        
        return style;
    }
    
    /**
     * Create currency cell style
     */
    private CellStyle createCurrencyStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        
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