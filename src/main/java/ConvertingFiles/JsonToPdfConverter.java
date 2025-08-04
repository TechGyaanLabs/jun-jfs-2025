package ConvertingFiles;

import org.apache.fop.apps.*;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class JsonToPdfConverter {
    public static void main(String[] args) {
        try {
            File xsltFile = new File("players.xsl");
            File xmlFile = new File("players.xml");
            File pdfFile = new File("players.pdf");

            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

            OutputStream out = new FileOutputStream(pdfFile);
            out = new BufferedOutputStream(out);

            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            StreamSource src = new StreamSource(xmlFile);
            SAXResult res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);

            out.close();
            System.out.println("✅ PDF generated successfully at: " + pdfFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

