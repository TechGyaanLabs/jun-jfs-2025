package com.careerit.jfs.cj.day7;

import java.util.Scanner;


public class ReportService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the report type (PDF/EXCEL/CSV/XML/JSON): ");
        String reportType = scanner.next();
        System.out.println(getReport(reportType));
        scanner.close();
    }

    public static String getReport(String type) {
        return switch (type) {
            case "PDF" -> "PDF Report";
            case "EXCEL" -> "Excel Report";
            case "CSV" -> "CSV Report";
            case "XML" -> "XML Report";
            case "JSON" -> "JSON Report";
            default -> "Invalid Report Type";
        };
    }
}
