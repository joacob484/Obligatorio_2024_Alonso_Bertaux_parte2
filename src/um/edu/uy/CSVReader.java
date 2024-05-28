package um.edu.uy;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CSVReader {

    CSVReader reader = new FileReader("yourfile.csv")).withCSVParser(new CSVParserBuilder().withSeparator('\t').build().build();

    public CSVReader() throws FileNotFoundException {
    }
}
