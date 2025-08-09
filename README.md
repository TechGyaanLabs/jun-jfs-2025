# Player Data Converter

A Java application that converts player data between different formats: JSON, CSV, Excel, XML, and PDF.

## Features

- **JSON to CSV**: Converts player data from JSON to CSV format
- **JSON to Excel**: Converts player data from JSON to Excel (.xlsx) format
- **JSON to XML**: Converts player data from JSON to XML format
- **JSON to PDF**: Converts player data from JSON to PDF using Apache FOP

## Project Structure

```
src/main/java/com/example/converter/
├── Player.java                 # POJO class for player data
├── JsonReaderUtil.java         # Utility to read JSON files
├── CsvWriterUtil.java          # Utility to write CSV files
├── ExcelWriterUtil.java        # Utility to write Excel files
├── PdfWriterUtil.java          # Utility to write XML and PDF files
└── MainConverter.java          # Main class that orchestrates conversions

src/main/resources/
├── players.json               # Sample player data in JSON format
└── template.xsl               # XSL template for PDF generation
```

## Dependencies

- **Jackson**: For JSON processing
- **OpenCSV**: For CSV file operations
- **Apache POI**: For Excel file operations
- **Apache FOP**: For PDF generation from XML

## Usage

1. **Compile the project**:
   ```bash
   mvn compile
   ```

2. **Run the converter**:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.converter.MainConverter"
   ```

3. **Or run directly**:
   ```bash
   java -cp target/classes com.example.converter.MainConverter
   ```

## Output Files

The application generates the following output files:
- `players.csv` - CSV format
- `players.xlsx` - Excel format
- `players.xml` - XML format
- `players.pdf` - PDF format

## Player Data Format

The Player class contains the following fields:
- `name` (String): Player's name
- `role` (String): Player's role (e.g., Batsman, Bowler)
- `country` (String): Player's country
- `team` (String): Player's team
- `price` (double): Player's price/value

## Sample Data

The `src/main/resources/players.json` file contains sample player data for testing:

```json
[
  {
    "name": "Virat Kohli",
    "role": "Batsman",
    "country": "India",
    "team": "Royal Challengers Bangalore",
    "price": 17.0
  }
]
```

## Technologies Used

- **Java 11**
- **Maven** for dependency management
- **Jackson** for JSON processing
- **OpenCSV** for CSV operations
- **Apache POI** for Excel operations
- **Apache FOP** for PDF generation
- **XSLT** for XML to PDF transformation 