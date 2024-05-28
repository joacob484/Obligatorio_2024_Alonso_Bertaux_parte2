package um.edu.uy;

import java.util.Date;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
    System.out.println("Bienvenido a Spotify!");
    System.out.println("A continuación se presentan las consultas que puede realizar:");
    System.out.println("1. Consultar las 10 canciones más escuchadas en un país en un día específico.");
    System.out.println("2. Consultar las 5 canciones más escuchadas en el top 50 en un día específico.");
    System.out.println("3. Consultar los 7 artistas más escuchados en el top 50 en un rango de fechas.");
    System.out.println("4. Consultar la cantidad de veces que un artista aparece en el top 50 en un día específico.");
    System.out.println("5. Consultar la cantidad de canciones de un artista que tienen una duración específica en un rango de fechas.");
    System.out.println("Por favor, ingrese el número de la consulta que desea realizar:");
        Scanner scanner = new Scanner(System.in);
        int consulta = scanner.nextInt();
        ConsultasSpotify consultasSpotify = new ConsultasSpotify();
        switch (consulta) {
            case 1:
                System.out.println("Ingrese el país:");
                String pais = scanner.next();
                System.out.println("Ingrese la fecha:");
                String fecha = scanner.next();
                consultasSpotify.top10CancionesPais(pais,fecha );
                break;
            case 2:
                System.out.println("Ingrese la fecha:");
                String fecha2 = scanner.next();
                consultasSpotify.top5CancionesMasTop50(fecha2);
                break;
            case 3:
                System.out.println("Ingrese la fecha de inicio:");
                String inicio = scanner.next();
                System.out.println("Ingrese la fecha de fin:");
                String fin = scanner.next();
                consultasSpotify.top7ArtistasMasTop50(inicio, fin);
                break;
            case 4:
                System.out.println("Ingrese la fecha:");
                String fecha3 = scanner.next();
                System.out.println("Ingrese el nombre del artista:");
                String artista = scanner.next();
                consultasSpotify.CantVecesArtistaTop50(fecha3, artista);
                break;
            case 5:
                System.out.println("Ingrese la fecha de inicio:");
                String inicio2 = scanner.next();
                System.out.println("Ingrese la fecha de fin:");
                String fin2 = scanner.next();
                System.out.println("Ingrese la duración de las canciones:");
                int duracion = scanner.nextInt();
                consultasSpotify.CantCancionesTempoEspecifico(inicio2, fin2, duracion);
                break;
            default:
                System.out.println("Consulta inválida.");
        }
    }
}
