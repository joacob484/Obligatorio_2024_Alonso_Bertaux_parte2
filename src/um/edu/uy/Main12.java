package um.edu.uy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main12 {
    int numero =0;


    public static void main(String[] args) {
        int numero =0;
        Scanner scanner = new Scanner(System.in);
        CSVEjemplo csvEjemplo = new CSVEjemplo();
        ConsultasSpotify consultasSpotify = new ConsultasSpotify(csvEjemplo);
        while(numero == 0){
            System.out.println("Bienvenido a Spotify!");
            System.out.println("A continuación se presentan las consultas que puede realizar:");
            System.out.println("1. Consultar las 10 canciones más escuchadas en un país en un día específico.");
            System.out.println("2. Consultar las 5 canciones más escuchadas en el top 50 en un día específico.");
            System.out.println("3. Consultar los 7 artistas más escuchados en el top 50 en un rango de fechas.");
            System.out.println("4. Consultar la cantidad de veces que un artista aparece en el top 50 en un día específico.");
            System.out.println("5. Consultar la cantidad de canciones de un artista que tienen una duración específica en un rango de fechas.");
            System.out.println("6. Salir.");
            System.out.println("Por favor, ingrese el número de la consulta que desea realizar:");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            int consulta = scanner.nextInt();
            scanner.nextLine();
            switch (consulta) {
                case 1:
                    System.out.println("Ingrese el codigo del pais EJ:'UY','AR': ");
                    String pais = scanner.nextLine();
                    String fecha;
                    while (true) {
                        System.out.print("Ingrese la fecha en formato yyyy-MM-dd: ");
                        fecha = scanner.nextLine();
                        if (fecha.isEmpty()) {
                            System.out.println("La fecha no puede estar vacía. Intente nuevamente.");
                            continue;
                        }
                        try {
                            LocalDate.parse(fecha, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("La fecha debe estar en el formato yyyy-MM-dd. Intente nuevamente.");
                        }
                    }
                    consultasSpotify.top10CancionesPais(pais,fecha);
                    System.out.println("Las 10 canciones más escuchadas en " + pais + " el " + fecha + " son:");
                    break;
                case 2:
                    String fecha2;
                    while (true) {
                        System.out.print("Ingrese la fecha en formato yyyy-MM-dd: ");
                        fecha2 = scanner.nextLine();
                        if (fecha2.isEmpty()) {
                            System.out.println("La fecha no puede estar vacía. Intente nuevamente.");
                            continue;
                        }
                        try {
                            LocalDate.parse(fecha2, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("La fecha debe estar en el formato yyyy-MM-dd. Intente nuevamente.");
                        }
                    }
                    consultasSpotify.top5CancionesMasTop50(fecha2);
                    break;
                case 3:
                    System.out.println("Ingrese la fecha de inicio en el fomrato 'YYYY-MM-DD':");
                    String inicio;
                    while (true) {
                        inicio = scanner.nextLine();
                        if (inicio.isEmpty()) {
                            System.out.println("La fecha no puede estar vacía. Intente nuevamente.");
                            continue;
                        }
                        try {
                            LocalDate.parse(inicio, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("La fecha debe estar en el formato yyyy-MM-dd. Intente nuevamente.");
                        }
                    }
                    System.out.println("Ingrese la fecha de fin en el fomrato 'YYYY-MM-DD':");
                    String fin;
                    while (true) {
                        fin = scanner.nextLine();
                        if (fin.isEmpty()) {
                            System.out.println("La fecha no puede estar vacía. Intente nuevamente.");
                            continue;
                        }
                        try {
                            LocalDate.parse(fin, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("La fecha debe estar en el formato yyyy-MM-dd. Intente nuevamente.");
                        }
                    }
                    System.out.println("Las 7 artistas con mas top 50 en "  + inicio + " hasta " + fin + " son:");
                    consultasSpotify.top7ArtistasMasTop50(inicio,fin);
                    break;
                case 4:
                    System.out.println("Ingrese la fecha en el fomrato 'YYYY-MM-DD':");
                    String fecha3;
                    while (true) {
                        fecha3 = scanner.nextLine();
                        if (fecha3.isEmpty()) {
                            System.out.println("La fecha no puede estar vacía. Intente nuevamente.");
                            continue;
                        }
                        try {
                            LocalDate.parse(fecha3, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("La fecha debe estar en el formato yyyy-MM-dd. Intente nuevamente.");
                        }
                    }
                    System.out.println("Ingrese el nombre del artista:");
                    String artista = scanner.nextLine();
                    System.out.println("Ingrese el codigo del pais EJ:'UY','AR' :");
                    String paisA = scanner.nextLine();
                    consultasSpotify.CantVecesArtistaTop50(fecha3,artista,paisA);

                    break;
                case 5:
                    System.out.println("Ingrese la fecha de inicio en el fomrato 'YYYY-MM-DD':");
                    String inicio2;
                    while (true) {
                        inicio2 = scanner.nextLine();
                        if (inicio2.isEmpty()) {
                            System.out.println("La fecha no puede estar vacía. Intente nuevamente.");
                            continue;
                        }
                        try {
                            LocalDate.parse(inicio2, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("La fecha debe estar en el formato yyyy-MM-dd. Intente nuevamente.");
                        }
                    }
                    System.out.println("Ingrese la fecha de fin en el fomrato 'YYYY-MM-DD':");
                    String fin2;
                    while (true) {
                        fin2 = scanner.nextLine();
                        if (fin2.isEmpty()) {
                            System.out.println("La fecha no puede estar vacía. Intente nuevamente.");
                            continue;
                        }
                        try {
                            LocalDate.parse(fin2, formatter);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("La fecha debe estar en el formato yyyy-MM-dd. Intente nuevamente.");
                        }
                    }
                    System.out.println("Ingrese el tempo minimo:");
                    BigDecimal tempoMin = new BigDecimal(scanner.next());
                    System.out.println("Ingrese el tempo maximo:");
                    BigDecimal tempoMax =new BigDecimal(scanner.next());
                    consultasSpotify.CantCancionesTempoEspecifico(inicio2,fin2,tempoMin,tempoMax);
                    break;
                case 6:
                    numero = 1;
                    break;
                default:
                    System.out.println("Consulta inválida.");
            }
        }

    }
}
