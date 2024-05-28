package um.edu.uy;

import java.util.LinkedList;
import java.util.Objects;

public class Artista {
    private String nombre;
    private String cedula;
    private LinkedList<Cancion> canciones;

    public Artista(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.canciones = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LinkedList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(LinkedList<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(cedula, artista.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
