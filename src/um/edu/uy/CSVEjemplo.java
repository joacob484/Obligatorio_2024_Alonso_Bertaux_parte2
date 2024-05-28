package um.edu.uy;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVEjemplo {
    public static void main(String[] args) {
        String csvFile = "/Users/joaco/Desktop/TuplasObligatorio.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                for (String cell : line) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
