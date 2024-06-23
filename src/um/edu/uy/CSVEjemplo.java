package um.edu.uy;

import um.edu.uy.adt.hash.MyHash;
import um.edu.uy.adt.hash.MyHashImpl;
import um.edu.uy.adt.linkedlist.MyLinkedListImpl;
import um.edu.uy.adt.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class CSVEjemplo {
    private MyHash<String, MyHash<String, MyList<String>>> hashCancionesFechaPais;
    private MyHash<String, MyList<String>> hashCancionesFecha;
    private MyHash<String, MyHash<BigDecimal, MyList<String>>> hashCancionesFechaTempo;

    public MyHash<String, MyHash<String, MyList<String>>> getHashCancionesFechaPais() {
        return hashCancionesFechaPais;
    }

    public MyHash<String, MyList<String>> getHashCancionesFecha() {
        return hashCancionesFecha;
    }

    public MyHash<String, MyHash<BigDecimal, MyList<String>>> getHashCancionesFechaTempo() {
        return hashCancionesFechaTempo;
    }

    public CSVEjemplo() {
        Runtime.getRuntime().gc();
        // Capturar la memoria utilizada antes de ejecutar el método
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        this.hashCancionesFechaPais = new MyHashImpl<>();
        this.hashCancionesFecha = new MyHashImpl<>();
        this.hashCancionesFechaTempo = new MyHashImpl<>();

        try (BufferedReader in = new BufferedReader(new FileReader(new File("/Users/joaco/Desktop/universal_top_spotify_songs.csv")))) { //aca va la direccion en tu compu

            int line = 0;
            for (String a = in.readLine(); a != null; a = in.readLine()) {
                line++;
                String[] valores = a.split("\",\"");
                for (int i = 0; i < valores.length; i++) {
                    valores[i] = valores[i].replace("\"", "");
                }

                if (line != 1) {
                    MyHash<String, MyList<String>> hashPais = this.hashCancionesFechaPais.get(valores[7]);
                    MyList<String> listaCancionesFP = new MyLinkedListImpl<>();
                    MyList<String> listaCancionesF = this.hashCancionesFecha.get(valores[7]);
                    MyHash<BigDecimal, MyList<String>> hashTempo = this.hashCancionesFechaTempo.get(valores[7]);
                    MyList<String> listaCancionesFT = new MyLinkedListImpl<>();

                    if (hashPais == null) {
                        hashPais = new MyHashImpl<>();
                        listaCancionesFP.add(a);
                        hashPais.put(valores[6], listaCancionesFP);
                        this.hashCancionesFechaPais.put(valores[7], hashPais);

                    } else {
                        listaCancionesFP = hashPais.get(valores[6]);

                        if (listaCancionesFP == null) {
                            listaCancionesFP = new MyLinkedListImpl<>();
                            listaCancionesFP.add(a);
                            hashPais.put(valores[6], listaCancionesFP);

                        } else {
                            listaCancionesFP.add(a);
                        }
                    }

                    if (listaCancionesF == null) {
                        listaCancionesF = new MyLinkedListImpl<>();
                        listaCancionesF.add(a);
                        this.hashCancionesFecha.put(valores[7], listaCancionesF);
                    } else {
                        listaCancionesF.add(a);
                    }

                    if (hashTempo == null) {
                        hashTempo = new MyHashImpl<>();
                        listaCancionesFT.add(a);
                        hashTempo.put(new BigDecimal(valores[23]), listaCancionesFT);
                        this.hashCancionesFechaTempo.put(valores[7], hashTempo);

                    } else {
                        listaCancionesFT = hashTempo.get(new BigDecimal(valores[23]));

                        if (listaCancionesFT == null) {
                            listaCancionesFT = new MyLinkedListImpl<>();
                            listaCancionesFT.add(a);
                            hashTempo.put(new BigDecimal(valores[23]), listaCancionesFT);
                        } else {
                            listaCancionesFT.add(a);
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("File I/O error!");
            e.printStackTrace();
        }
        long endTime = System.nanoTime();

        // Calcular el tiempo de ejecución
        long duration = endTime - startTime; // tiempo en nanosegundos

        // Convertir a milisegundos si es necesario
        double durationInMilliseconds = duration / 1_000_000.0;
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Calcular el uso de memoria
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println("La carga de datos utilizó: " + memoryUsed + " bytes de memoria");

        System.out.println("La carga de datos se ejecutó en: " + durationInMilliseconds + " ms");
    }
}

