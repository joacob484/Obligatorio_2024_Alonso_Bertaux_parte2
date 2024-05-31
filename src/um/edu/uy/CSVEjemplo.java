package um.edu.uy;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class CSVEjemplo {
    private static List<Cancion> canciones = new ArrayList<>();

    public static void  main(String[] args) {
        String csvFile = "/Users/joaco/Desktop/TuplasObligatorio.csv";
        try (CSVParser parser = new CSVParser(new FileReader(csvFile), CSVFormat.DEFAULT)) {
            for (CSVRecord record : parser) {
                for (String cell : record) {
                    if (Objects.equals(cell, " ,")){
                        cell = " ";
                    }
                    String titulo = record.get(0);
                    String nombre = record.get(1);
                    String ranking = record.get(2);
                    int ranking1 = Integer.parseInt(ranking);
                    String movimientoDiario = record.get(3);
                    int movDiario = Integer.parseInt(movimientoDiario);
                    String movimientoSemanal = record.get(4);
                    int movSemanal = Integer.parseInt(movimientoSemanal);
                    String pais = record.get(5);
                    String fecha = record.get(6);
                    LocalDate fecha1 = LocalDate.parse(fecha);
                    String duracion = record.get(8);
                    int duracion1 = Integer.parseInt(duracion);
                    String tempo = record.get(20);
                    Float tempo1 = Float.parseFloat(tempo);
                    Artista nuevoArtista = new Artista(nombre);
                    Cancion nuevaCancion = new Cancion(titulo, nuevoArtista, duracion1, tempo1, pais,fecha1,ranking1);
                    canciones.add(nuevaCancion);
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Stream<Cancion> stream(){
            return canciones.stream();
        }
    }

