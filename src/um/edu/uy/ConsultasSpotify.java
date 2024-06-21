package um.edu.uy;

import um.edu.uy.adt.hash.MyHash;
import um.edu.uy.adt.hash.MyHashImpl;
import um.edu.uy.adt.linkedlist.MyLinkedListImpl;
import um.edu.uy.adt.linkedlist.MyList;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ConsultasSpotify {

    private CSVEjemplo CSVEjemplo;

    public ConsultasSpotify(CSVEjemplo pruebaCSV) {
        this.CSVEjemplo = pruebaCSV;
    }
    public void top10CancionesPais(String pais, String fecha) {
        Runtime.getRuntime().gc();
        // Capturar la memoria utilizada antes de ejecutar el método
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        LocalDate date = LocalDate.parse(fecha);
        MyHash<String, MyHash<String, MyList<String>>> hashCancionesFechaPais = CSVEjemplo.getHashCancionesFechaPais();

        System.out.println("Fecha: " + fecha);
        System.out.println("Pais: " + pais);

        MyList<String> top10 = new MyLinkedListImpl<>();
        MyHash<String, MyList<String>> hashPais = hashCancionesFechaPais.get(fecha);

        if (hashPais == null) {
            System.out.println("No se encontraron canciones para la fecha especificada.");
            return;
        }

        MyList<String> canciones = hashPais.get(pais);
        if (canciones == null) {
            System.out.println("No se encontraron canciones para el país especificado.");
            return;
        }

        for (int i = 0; i < canciones.size(); i++) {
            String cancion = canciones.get(i);
            String[] valores = cancion.split("\",\"");
            for (int j = 0; j < valores.length; j++) {
                valores[j] = valores[j].replace("\"", "");
            }
            int ranking = Integer.parseInt(valores[3]);
            if (top10.size() < 10) {
                top10.add(cancion);
            } else {
                int maxIndex = 0;
                for (int h = 1; h < top10.size(); h++) {
                    String[] top10Valores = cancion.split("\",\"");
                    for (int k = 0; k < top10Valores.length; k++) {
                        top10Valores[k] = top10Valores[k].replace("\"", "");
                    }

                    int top10Ranking = Integer.parseInt(top10Valores[3]);
                    if (top10Ranking > ranking) {
                        maxIndex = h;
                    }
                }
                if (ranking < Integer.parseInt(top10.get(maxIndex).split("\",\"")[3])) {
                    top10.set(maxIndex, cancion);
                }
            }
        }

        System.out.println("Top 10 canciones en " + pais + " el " + fecha + ":");
        for (int i = 0; i < top10.size(); i++) {
            String[] valores = top10.get(i).split(",");
            System.out.println((i + 1) + ". "  + valores[1] + " (Ranking: " + valores[3] + ")");
        }
        long endTime = System.nanoTime();

        // Calcular el tiempo de ejecución
        long duration = endTime - startTime; // tiempo en nanosegundos

        // Convertir a milisegundos si es necesario
        double durationInMilliseconds = duration / 1_000_000.0;
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Calcular el uso de memoria
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println("El método utilizó: " + memoryUsed + " bytes de memoria");

        System.out.println("El método se ejecutó en: " + durationInMilliseconds + " ms");
    }


    public void top5CancionesMasTop50(String dia) {
        Runtime.getRuntime().gc();
        // Capturar la memoria utilizada antes de ejecutar el método
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        LocalDate fecha = LocalDate.parse(dia);
        MyHash<String, MyList<String>> hashCancionesFecha = CSVEjemplo.getHashCancionesFecha();
        MyHash<String, Integer> countMap = new MyHashImpl<>();

        MyList<String> canciones = hashCancionesFecha.get(dia);
        if (canciones != null) {
            for (int i = 0; i < canciones.size(); i++) {
                String cancion = canciones.get(i);
                String[] valores = cancion.split("\",\"");
                String titulo = valores[0];
                if (countMap.contains(titulo)) {
                    int count = countMap.get(titulo);
                    countMap.put(titulo, count + 1);
                } else {
                    countMap.put(titulo, 1);
                }
            }
        }
        MyList<String> top5 = new MyLinkedListImpl<>();
        for (int i = 0; i < 5; i++) {
            String maxTitulo = null;
            int maxCount = -1;
            MyList<String> keys = countMap.keys();
            for (int j = 0; j < keys.size(); j++) {
                String titulo = keys.get(j);
                int count = countMap.get(titulo);
                if (count > maxCount) {
                    maxCount = count;
                    maxTitulo = titulo;
                }
            }
            if (maxTitulo != null) {
                for (int j = 0; j < canciones.size(); j++) {
                    String cancion = canciones.get(j);
                    if (cancion.split("\",\"")[0].equals(maxTitulo)) {
                        top5.add(cancion);
                        countMap.remove(maxTitulo);
                        break;
                    }
                }
            }
        }

        System.out.println("Top 5 canciones que aparecen más veces en el top 50 el " + dia + ":");
        for (int i = 0; i < top5.size(); i++) {
            String[] valores = top5.get(i).split("\",\"");
            System.out.println((i + 1)  + " - " + valores[1]);
        }
        long endTime = System.nanoTime();
        // Calcular el tiempo de ejecución
        long duration = endTime - startTime; // tiempo en nanosegundos

        // Convertir a milisegundos si es necesario
        double durationInMilliseconds = duration / 1_000_000.0;
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Calcular el uso de memoria
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println("El método utilizó: " + memoryUsed + " bytes de memoria");

        System.out.println("El método se ejecutó en: " + durationInMilliseconds + " ms");
    }


    public void top7ArtistasMasTop50(String inicio, String fin){
        Runtime.getRuntime().gc();
        // Capturar la memoria utilizada antes de ejecutar el método
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);
        MyHash<String, MyList<String>> hashCancionesFecha = CSVEjemplo.getHashCancionesFecha();
        MyHash<String, Integer> countMap = new MyHashImpl<>();

        for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)) {
            MyList<String> canciones = hashCancionesFecha.get(date.toString());
            if (canciones != null) {
                for (int i = 0; i < canciones.size(); i++) {
                    String cancion = canciones.get(i);
                    String[] valores = cancion.split(",");
                    String[] artistas = valores[2].split(";");
                    for (String artista : artistas) {
                        if (countMap.contains(artista)) {
                            int count = countMap.get(artista);
                            countMap.put(artista, count + 1);
                        } else {
                            countMap.put(artista, 1);
                        }
                    }
                }
            }
        }
        String[] top7Artistas = new String[7];
        int[] top7Counts = new int[7];
        MyList<String> keys = countMap.keys();
        for (int i = 0; i < keys.size(); i++) {
            String artista = keys.get(i);
            int count = countMap.get(artista);
            for (int j = 0; j < 7; j++) {
                if (count > top7Counts[j]) {
                    for (int k = 6; k > j; k--) {
                        top7Counts[k] = top7Counts[k - 1];
                        top7Artistas[k] = top7Artistas[k - 1];
                    }
                    top7Counts[j] = count;
                    top7Artistas[j] = artista;
                    break;
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            if (top7Artistas[i] != null) {
                System.out.println((i + 1) + ". " + top7Artistas[i] + " - Veces: " + top7Counts[i]);
            }
        }
        long endTime = System.nanoTime();
        // Calcular el tiempo de ejecución
        long duration = endTime - startTime; // tiempo en nanosegundos

        // Convertir a milisegundos si es necesario
        double durationInMilliseconds = duration / 1_000_000.0;
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Calcular el uso de memoria
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println("El método utilizó: " + memoryUsed + " bytes de memoria");

        System.out.println("El método se ejecutó en: " + durationInMilliseconds + " ms");

    }

    public  void CantVecesArtistaTop50( String fecha, String nombreArtista,String pais) {
        Runtime.getRuntime().gc();
        // Capturar la memoria utilizada antes de ejecutar el método
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        LocalDate date = LocalDate.parse(fecha);
        MyHash<String, MyHash<String, MyList<String>>> hashCancionesFechaPais = CSVEjemplo.getHashCancionesFechaPais();

        MyHash<String, MyList<String>> hashPais = hashCancionesFechaPais.get(fecha);
        if (hashPais == null) {
            System.out.println("No se encontraron canciones para la fecha especificada.");
            return;
        }

        MyList<String> canciones = hashPais.get(pais);
        if (canciones == null) {
            System.out.println("No se encontraron canciones para el país especificado.");
            return;
        }

        int count = 0;
        System.out.println("Procesando " + canciones.size() + " canciones...");
        for (int i = 0; i < canciones.size(); i++) {
            String cancion = canciones.get(i);
            String[] valores = cancion.split("\",\"");
            for (int j = 0; j < valores.length; j++) {
                valores[j] = valores[j].replace("\"", "");
            }
            String[] artistas = valores[2].split("\",\"");
            for (int k = 0; k < artistas.length; k++) {
                artistas[k] = artistas[k].replace("\"", "");
            }
            for (String artista : artistas) {
                if (artista.trim().equalsIgnoreCase(nombreArtista)) {
                    count++;
                }
            }
        }
        System.out.println("El artista " + nombreArtista + " aparece " + count + " veces en el top 50 de " + pais + " el " + fecha);
        long endTime = System.nanoTime();

        // Calcular el tiempo de ejecución
        long duration = endTime - startTime; // tiempo en nanosegundos

        // Convertir a milisegundos si es necesario
        double durationInMilliseconds = duration / 1_000_000.0;
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Calcular el uso de memoria
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println("El método utilizó: " + memoryUsed + " bytes de memoria");

        System.out.println("El método se ejecutó en: " + durationInMilliseconds + " ms");
    }

    public void CantCancionesTempoEspecifico(String inicioFecha, String finFecha, BigDecimal tempoMinimo, BigDecimal tempoMaximo) {
        Runtime.getRuntime().gc();
        // Capturar la memoria utilizada antes de ejecutar el método
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        LocalDate fechaInicio = LocalDate.parse(inicioFecha);
        LocalDate fechaFin = LocalDate.parse(finFecha);
        MyHash<String, MyHash<BigDecimal, MyList<String>>> hashCancionesFechaTempo = CSVEjemplo.getHashCancionesFechaTempo();


        int count = 0;
        MyHash<String, Boolean> cancionesProcesadas = new MyHashImpl<>(); // Hash para rastrear canciones únicas

        for (LocalDate date = fechaInicio; !date.isAfter(fechaFin); date = date.plusDays(1)) {
            String fechaStr = date.toString();
            MyHash<BigDecimal, MyList<String>> hashTempo = hashCancionesFechaTempo.get(fechaStr);
            if (hashTempo == null) {
                System.out.println("No se encontraron canciones para la fecha: " + fechaStr);
                continue;
            }

            MyList<BigDecimal> tempos = hashTempo.keys();
            for (int i = 0; i < tempos.size(); i++) {
                BigDecimal tempo = tempos.get(i);
                if (tempo.compareTo(tempoMinimo) >= 0 && tempo.compareTo(tempoMaximo) <= 0) {
                    MyList<String> canciones = hashTempo.get(tempo);
                    for (int j = 0; j < canciones.size(); j++) {
                        String cancion = canciones.get(j);
                        String[] valores = cancion.split(",");
                        String id = valores[0].trim();
                        if (!cancionesProcesadas.contains(id)) {
                            cancionesProcesadas.put(id, true);
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println("El número total de canciones únicas con tempo entre " + tempoMinimo + " y " + tempoMaximo + " desde " + inicioFecha + " hasta " + finFecha + " es: " + count);
        long endTime = System.nanoTime();

        // Calcular el tiempo de ejecución
        long duration = endTime - startTime; // tiempo en nanosegundos

        // Convertir a milisegundos si es necesario
        double durationInMilliseconds = duration / 1_000_000.0;
        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Calcular el uso de memoria
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println("El método utilizó: " + memoryUsed + " bytes de memoria");

        System.out.println("El método se ejecutó en: " + durationInMilliseconds + " ms");
    }

}

