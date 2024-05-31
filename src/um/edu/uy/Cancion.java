package um.edu.uy;

import java.time.LocalDate;
import java.util.Objects;

public class Cancion {

    private String titulo;
    private Artista artista;
    private int duracion;
    private Float tempo;
    private String pais;
    private LocalDate fecha;
    private int ranking;





    public Cancion(String titulo, Artista artista, int duracion, Float tempo , String pais,LocalDate fecha, int ranking) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.tempo = tempo;
        this.pais = pais;
        this.ranking = ranking;
        this.fecha = fecha;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Float getTempo() {
        return tempo;
    }

    public void setTempo(Float tempo) {
        this.tempo = tempo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return Objects.equals(titulo, cancion.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
