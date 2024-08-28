/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculasVista;

/**
* LAURA VALENTINA ORTIZ BUSTOS
 * NICOLAS FELIPE GONZALEZ BELLO 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PeliculasModelo {
    private ArrayList<Pelicula> catalogo;

    public PeliculasModelo() {
        catalogo = new ArrayList<>();
    }

    // Clase Pelicula
    public static class Pelicula {
        private String titulo;
        private String director;
        private int anoLanzamiento;
        private double calificacion;

        public Pelicula(String titulo, String director, int anoLanzamiento, double calificacion) {
            this.titulo = titulo;
            this.director = director;
            this.anoLanzamiento = anoLanzamiento;
            this.calificacion = calificacion;
        }

        // Getters
        public String getTitulo() { return titulo; }
        public String getDirector() { return director; }
        public int getAnoLanzamiento() { return anoLanzamiento; }
        public double getCalificacion() { return calificacion; }
    }

    // Métodos para manipular el catálogo
    public void anadirPelicula(Pelicula pelicula) {
        catalogo.add(pelicula);
    }

    public void ordenarPorAno() {
        Collections.sort(catalogo, Comparator.comparingInt(Pelicula::getAnoLanzamiento));
    }

    public void ordenarPorCalificacion() {
        Collections.sort(catalogo, Comparator.comparingDouble(Pelicula::getCalificacion));
    }

    public Pelicula buscarPorTitulo(String titulo) {
        for (Pelicula pelicula : catalogo) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }

    public Pelicula buscarPorDirector(String director) {
        for (Pelicula pelicula : catalogo) {
            if (pelicula.getDirector().equalsIgnoreCase(director)) {
                return pelicula;
            }
        }
        return null;
    }

    public Pelicula peliculaConCalificacionMasAlta() {
        return Collections.max(catalogo, Comparator.comparingDouble(Pelicula::getCalificacion));
    }

    public Pelicula peliculaConCalificacionMasBaja() {
        return Collections.min(catalogo, Comparator.comparingDouble(Pelicula::getCalificacion));
    }

    public List<Pelicula> obtenerCatalogoSoloLectura() {
        return Collections.unmodifiableList(catalogo);
    }
}

