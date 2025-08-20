package ConvertingFiles;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class JsonToExcelConverter {
    public static void main(String[] args) {
        try {
            // Step 1: Read JSON file
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> data = mapper.readValue(
                    new FileReader("C:\\Users\\Amrutha\\Desktop\\javatraining\\jun-jfs-2025\\out_put.json"),
                    new TypeReference<List<Map<String, Object>>>() {}
            );

            // Step 2: Create Excel workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Players");

            // Step 3: Write header row
            if (!data.isEmpty()) {
                String[] headers = data.get(0).keySet().toArray(new String[0]);

                // Write header to Excel
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                }

                // Print header to console
                System.out.println(String.join(", ", headers));

                // Step 4: Write and print data rows
                for (int i = 0; i < data.size(); i++) {
                    Row row = sheet.createRow(i + 1);
                    Map<String, Object> rowData = data.get(i);

                    StringBuilder consoleRow = new StringBuilder();

                    for (int j = 0; j < headers.length; j++) {
                        Object value = rowData.get(headers[j]);
                        String strValue = value != null ? value.toString() : "";
                        row.createCell(j).setCellValue(strValue);

                        consoleRow.append(strValue).append(", ");
                    }

                    // Print each row to console
                    System.out.println(consoleRow.toString().replaceAll(", $", ""));
                }

                // Step 5: Save to Excel file
                try (FileOutputStream fileOut = new FileOutputStream("players.xlsx")) {
                    workbook.write(fileOut);
                }

                workbook.close();
                System.out.println("\n✅ JSON converted to Excel and printed to console successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




