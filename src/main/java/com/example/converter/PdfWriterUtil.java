package com.example.converter;

import org.apache.fop.apps.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfWriterUtil {
    
    public static void writeXml(List<Player> players, String xmlPath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        // Create root element
        Element rootElement = document.createElement("players");
        document.appendChild(rootElement);
        
        // Create player elements
        for (Player player : players) {
            Element playerElement = document.createElement("player");
            
            Element nameElement = document.createElement("name");
            nameElement.setTextContent(player.getName());
            playerElement.appendChild(nameElement);
            
            Element roleElement = document.createElement("role");
            roleElement.setTextContent(player.getRole());
            playerElement.appendChild(roleElement);
            
            Element countryElement = document.createElement("country");
            countryElement.setTextContent(player.getCountry());
            playerElement.appendChild(countryElement);
            
            Element teamElement = document.createElement("team");
            teamElement.setTextContent(player.getTeam());
            playerElement.appendChild(teamElement);
            
            Element priceElement = document.createElement("price");
            priceElement.setTextContent(String.valueOf(player.getPrice()));
            playerElement.appendChild(priceElement);
            
            rootElement.appendChild(playerElement);
        }
        
        // Write XML to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(xmlPath));
        transformer.transform(source, result);
    }
    
    public static void writeToPdf(String xmlPath, String xslPath, String pdfPath) throws Exception {
        // Configure FOP
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        
        // Setup output
        try (FileOutputStream out = new FileOutputStream(pdfPath)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            
            // Setup transformer
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xslPath));
            
            // Setup input and output
            Source xmlSource = new StreamSource(new File(xmlPath));
            Result result = new SAXResult(fop.getDefaultHandler());
            
            // Transform
            transformer.transform(xmlSource, result);
        }
    }
} 