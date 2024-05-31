package um.edu.uy;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import um.edu.uy.CSVEjemplo;
public class ConsultasSpotify {

    private CSVEjemplo CSVEjemplo;

    public ConsultasSpotify(CSVEjemplo CSVEjemplo) {
        this.CSVEjemplo = CSVEjemplo;
    }

    public List<Cancion> top10CancionesPais(String pais, String dia) {
        LocalDate fecha = LocalDate.parse(dia);
    return CSVEjemplo.stream().filter(cancion -> cancion.getPais().equals(pais) && cancion.getFecha().equals(fecha)).sorted(Comparator.comparing(Cancion::getRanking)).limit(10).collect(Collectors.toList());
    }

    public void top5CancionesMasTop50(String dia ){
        LocalDate fecha = LocalDate.parse(dia);

    }

    public void top7ArtistasMasTop50(String inicio, String fin){
        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);

    }

    public  int CantVecesArtistaTop50( String fecha, String cedulaArtista) {
        LocalDate fecha1 = LocalDate.parse(fecha);
        Integer cedula = Integer.parseInt(cedulaArtista);


        return 0;

    }

    public int CantCancionesTempoEspecifico( String iniciofecha, String finfecha,String tituloCancion) {
        return 0;
    }


}

