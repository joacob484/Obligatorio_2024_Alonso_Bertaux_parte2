package um.edu.uy;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;

public class CSVEjemplo {
    public static void main(String[] args) {
        String csvFile = "/Users/joaco/Desktop/TuplasObligatorio.csv";
        try (CSVParser parser = new CSVParser(new FileReader(csvFile), CSVFormat.DEFAULT)) {
            for (CSVRecord record : parser) {
                for (String cell : record) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
