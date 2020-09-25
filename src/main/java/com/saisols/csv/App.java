package com.saisols.csv;

import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import de.siegmar.fastcsv.writer.CsvAppender;
import de.siegmar.fastcsv.writer.CsvWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    void run(InputStream inputStream, OutputStream outputStream) throws IOException {
        CsvWriter csvWriter = new CsvWriter();
        CsvAppender csvAppender = csvWriter.append(new OutputStreamWriter(outputStream));

        CsvReader csvReader = new CsvReader();
        CsvParser csvParser = csvReader.parse(new InputStreamReader(inputStream));
        long rowCount = 1;
        CsvRow row;
        while ((row = csvParser.nextRow()) != null) {
            List<String> fields = row.getFields();
            for (String field : fields) {
                if (field != null && field.contains("\n")) {
                    field = field.replaceAll("\n", "<br/>");
                }
                csvAppender.appendField(field);
            }
            csvAppender.endLine();
            rowCount++;
        }
        csvAppender.flush();
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.run(System.in, System.out);
    }
}
