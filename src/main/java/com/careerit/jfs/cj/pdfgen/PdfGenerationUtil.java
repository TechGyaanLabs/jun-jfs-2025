package com.careerit.jfs.cj.pdfgen;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class PdfGenerationUtil {


    public String convertToXmlString(Map<String, Object> data, String rootElement) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.setDefaultUseWrapper(false);
            
            // Convert the map to XML without wrapper
            StringWriter writer = new StringWriter();
            xmlMapper.writeValue(writer, data);
            String xmlContent = writer.toString();
            
            // Extract the content between the first and last tags
            int startIndex = xmlContent.indexOf(">") + 1;
            int endIndex = xmlContent.lastIndexOf("<");
            String innerContent = xmlContent.substring(startIndex, endIndex);
            
            // Wrap with the desired root element
            return "<" + rootElement + ">" + innerContent + "</" + rootElement + ">";
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert data to XML string", e);
        }
    }

    public File generatePdf(String xmlString, String xslFilePath) {
        try {
            // Create a temporary file for the PDF output
            File pdfFile = File.createTempFile("generated", ".pdf");
            
            // Configure FOP
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            
            // Setup output stream
            try (FileOutputStream out = new FileOutputStream(pdfFile)) {
                // Construct FOP with desired output format
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
                
                // Setup XSLT transformer
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(new File(xslFilePath)));
                
                // Setup input and output
                Source xmlSource = new javax.xml.transform.stream.StreamSource(
                    new java.io.StringReader(xmlString));
                Result result = new SAXResult(fop.getDefaultHandler());
                
                // Transform XML to PDF
                transformer.transform(xmlSource, result);
            }
            
            return pdfFile;
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate PDF", e);
        }
    }
    
    /**
     * Complete workflow: Convert data to XML and generate PDF
     * @param data The data to convert
     * @param rootElement The root element name for XML
     * @param xslFilePath Path to the XSL file
     * @return Generated PDF file
     */
    public File generatePdfFromData(Map<String, Object> data, String rootElement, String xslFilePath) {
        String xmlString = convertToXmlString(data, rootElement);
        return generatePdf(xmlString, xslFilePath);
    }
    
    /**
     * Generate PDF with custom output file name
     * @param xmlString XML content as string
     * @param xslFilePath Path to the XSL file
     * @param outputFileName Custom output file name (without extension)
     * @return Generated PDF file
     */
    public File generatePdf(String xmlString, String xslFilePath, String outputFileName) {
        try {
            // Create a file with custom name
            File pdfFile = new File(outputFileName + ".pdf");
            
            // Configure FOP
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            
            // Setup output stream
            try (FileOutputStream out = new FileOutputStream(pdfFile)) {
                // Construct FOP with desired output format
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
                
                // Setup XSLT transformer
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(new File(xslFilePath)));
                
                // Setup input and output
                Source xmlSource = new javax.xml.transform.stream.StreamSource(
                    new java.io.StringReader(xmlString));
                Result result = new SAXResult(fop.getDefaultHandler());
                
                // Transform XML to PDF
                transformer.transform(xmlSource, result);
            }
            
            return pdfFile;
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate PDF", e);
        }
    }
}
