package ConvertingFiles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // Step 1: Read JSON as List<Player>
            ObjectMapper jsonMapper = new ObjectMapper();
            List<Player> playersList = jsonMapper.readValue(
                    new FileReader("C:\\Users\\Amrutha\\Desktop\\javatraining\\jun-jfs-2025\\out_put.json"),
                    new TypeReference<List<Player>>() {}
            );

            // Step 2: Wrap in Players object
            Players playersWrapper = new Players(playersList);

            // Step 3: Write XML
            XmlMapper xmlMapper = new XmlMapper();
            File xmlFile = new File("players.xml");
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(xmlFile, playersWrapper);

            System.out.println("✅ XML generated successfully: players.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
