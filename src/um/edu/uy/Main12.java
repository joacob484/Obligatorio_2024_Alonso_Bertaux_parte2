package um.edu.uy;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main12 {
    int numero =0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CSVEjemplo csvEjemplo = new CSVEjemplo();
        ConsultasSpotify consultasSpotify = new ConsultasSpotify(csvEjemplo);
        int numero =0;
    while(numero == 0){
        System.out.println("Bienvenido a Spotify!");
        System.out.println("A continuación se presentan las consultas que puede realizar:");
        System.out.println("1. Consultar las 10 canciones más escuchadas en un país en un día específico.");
        System.out.println("2. Consultar las 5 canciones más escuchadas en el top 50 en un día específico.");
        System.out.println("3. Consultar los 7 artistas más escuchados en el top 50 en un rango de fechas.");
        System.out.println("4. Consultar la cantidad de veces que un artista aparece en el top 50 en un día específico.");
        System.out.println("5. Consultar la cantidad de canciones de un artista que tienen una duración específica en un rango de fechas.");
        System.out.println("Por favor, ingrese el número de la consulta que desea realizar:");

            int consulta = scanner.nextInt();
            switch (consulta) {
                case 1:
                    System.out.println("Ingrese el país:");
                    String pais = scanner.nextLine();
                    System.out.println("Ingrese la fecha:");
                    String fecha = scanner.nextLine();
                    consultasSpotify.top10CancionesPais(pais,fecha);
                    System.out.println("Las 10 canciones más escuchadas en " + pais + " el " + fecha + " son:");
                    break;
                case 2:
                    System.out.println("Ingrese la fecha:");
                    String fecha2 = scanner.nextLine();
                    System.out.println("Las 5 canciones más escuchadas en "  + fecha2 + " son:");
                    consultasSpotify.top5CancionesMasTop50(fecha2);
                    break;
                case 3:
                    System.out.println("Ingrese la fecha de inicio:");
                    String inicio = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin:");
                    String fin = scanner.nextLine();
                    System.out.println("Las 7 artistas con mas top 50 en "  + inicio + " hasta " + fin + " son:");
                    consultasSpotify.top7ArtistasMasTop50(inicio,fin);
                    break;
                case 4:
                    System.out.println("Ingrese la fecha:");
                    String fecha3 = scanner.nextLine();
                    System.out.println("Ingrese el nombre del artista:");
                    String artista = scanner.nextLine();
                    System.out.println("Ingrese el nombre del pais:");
                    String paisA = scanner.nextLine();
                    consultasSpotify.CantVecesArtistaTop50(fecha3,artista,paisA);

                    break;
                case 5:
                    System.out.println("Ingrese la fecha de inicio:");
                    String inicio2 = scanner.nextLine();
                    System.out.println("Ingrese la fecha de fin:");
                    String fin2 = scanner.nextLine();
                    System.out.println("Ingrese el tempo minimo:");
                    BigDecimal tempoMin = new BigDecimal(scanner.nextLine());
                    System.out.println("Ingrese el tempo maximo:");
                    BigDecimal tempoMax =new BigDecimal(scanner.nextLine());
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
