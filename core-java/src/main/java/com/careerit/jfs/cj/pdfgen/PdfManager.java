package com.careerit.jfs.cj.pdfgen;

import com.careerit.jfs.cj.day26.InvoiceManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public class PdfManager {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final PdfGenerationUtil pdfGenerationUtil = new PdfGenerationUtil();

    public static void main(String[] args) {
        try {
            generatePlayerPdf();
            generateInvoicePdf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generic method to generate PDF from JSON data
     * @param jsonResourcePath Path to JSON resource file
     * @param rootElement Root element name for XML
     * @param xslResourcePath Path to XSL resource file
     * @param outputFileName Optional custom output file name
     * @return Generated PDF file
     */
    public static File generatePdfFromJson(String jsonResourcePath, String rootElement, 
                                         String xslResourcePath, String outputFileName) {
        try {
            // Read JSON data
            InputStream inputStream = InvoiceManager.class.getClassLoader()
                    .getResourceAsStream(jsonResourcePath);
            Map<String, Object> data = objectMapper.readValue(inputStream, Map.class);
            
            // Convert to XML and print
            String xmlString = pdfGenerationUtil.convertToXmlString(data, rootElement);
            System.out.println("Generated XML for " + rootElement + ":");
            System.out.println(xmlString);
            
            // Get XSL file path
            String xslFilePath = InvoiceManager.class.getClassLoader()
                    .getResource(xslResourcePath).getPath();
            System.out.println("Using XSL file: " + xslFilePath);
            
            // Generate PDF
            File pdfFile;
            if (outputFileName != null && !outputFileName.trim().isEmpty()) {
                pdfFile = pdfGenerationUtil.generatePdf(xmlString, xslFilePath, outputFileName);
            } else {
                pdfFile = pdfGenerationUtil.generatePdf(xmlString, xslFilePath);
            }
            
            System.out.println("PDF generated: " + pdfFile.getAbsolutePath());
            return pdfFile;
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate PDF from " + jsonResourcePath, e);
        }
    }

    /**
     * Generate PDF from data using the optimized workflow
     * @param jsonResourcePath Path to JSON resource file
     * @param rootElement Root element name for XML
     * @param xslResourcePath Path to XSL resource file
     * @return Generated PDF file
     */
    public static File generatePdfFromDataOptimized(String jsonResourcePath, String rootElement, 
                                                   String xslResourcePath) {
        try {
            // Read JSON data
            InputStream inputStream = InvoiceManager.class.getClassLoader()
                    .getResourceAsStream(jsonResourcePath);
            Map<String, Object> data = objectMapper.readValue(inputStream, Map.class);
            
            // Get XSL file path
            String xslFilePath = InvoiceManager.class.getClassLoader()
                    .getResource(xslResourcePath).getPath();
            
            // Use the optimized workflow method
            return pdfGenerationUtil.generatePdfFromData(data, rootElement, xslFilePath);
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate PDF from " + jsonResourcePath, e);
        }
    }

    public static void generatePlayerPdf() {
        System.out.println("\n=== Generating Player PDF ===");
        generatePdfFromJson("players_data.json", "players", "players.xsl", "players_report");
    }

    public static void generateInvoicePdf() {
        System.out.println("\n=== Generating Invoice PDF ===");
        generatePdfFromJson("invoice.json", "invoice", "invoice.xsl", "invoice_report");
    }
}
