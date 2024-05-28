package um.edu.uy;

import java.time.LocalDate;
import java.util.Date;

public class ConsultasSpotify {


    public void top10CancionesPais(String pais, String dia) {

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

