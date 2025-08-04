package ConvertingFiles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class JsonToCsvConverter {
    public static void main(String[] args) {
        try {
            // Step 1: Read JSON file
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> data = mapper.readValue(
                    new FileReader("C:\\Users\\Amrutha\\Desktop\\javatraining\\jun-jfs-2025\\out_put.json"),
                    new TypeReference<List<Map<String, Object>>>() {}
            );

            // Step 2: Write CSV file + console
            try (
                    CSVWriter fileWriter = new CSVWriter(new FileWriter("players.csv"));
                    CSVWriter consoleWriter = new CSVWriter(new OutputStreamWriter(System.out))
            ) {
                // Write header
                if (!data.isEmpty()) {
                    String[] header = data.get(0).keySet().toArray(new String[0]);
                    fileWriter.writeNext(header);
                    consoleWriter.writeNext(header);

                    // Write rows using header order
                    for (Map<String, Object> row : data) {
                        String[] values = new String[header.length];
                        for (int i = 0; i < header.length; i++) {
                            Object val = row.get(header[i]);
                            values[i] = val != null ? val.toString() : "";
                        }
                        fileWriter.writeNext(values);
                        consoleWriter.writeNext(values);
                    }
                }
            }

            System.out.println("✅ JSON converted to CSV successfully! (File + Console)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
