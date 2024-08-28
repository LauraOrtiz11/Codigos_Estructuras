/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculasVista;

/**
 *
 * @author * 
 *LAURA VALENTINA ORTIZ BUSTOS
 *NICOLAS FELIPE GONZALEZ BELLO 
 */
public class PeliculasControlador {
    private PeliculasModelo modelo;
    private PeliculasVista vista;

    public PeliculasControlador(PeliculasModelo modelo, PeliculasVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void anadirPelicula(String titulo, String director, int anoLanzamiento, double calificacion) {
        PeliculasModelo.Pelicula nuevaPelicula = new PeliculasModelo.Pelicula(titulo, director, anoLanzamiento, calificacion);
        modelo.anadirPelicula(nuevaPelicula);
        vista.mostrarMensaje("Película añadida: " + titulo);
    }

    public void ordenarPeliculasPorAno() {
        modelo.ordenarPorAno();
        vista.mostrarCatalogo(modelo.obtenerCatalogoSoloLectura());
    }

    public void ordenarPeliculasPorCalificacion() {
        modelo.ordenarPorCalificacion();
        vista.mostrarCatalogo(modelo.obtenerCatalogoSoloLectura());
    }

    public void buscarPeliculaPorTitulo(String titulo) {
        PeliculasModelo.Pelicula pelicula = modelo.buscarPorTitulo(titulo);
        if (pelicula != null) {
            vista.mostrarPelicula(pelicula);
        } else {
            vista.mostrarMensaje("Película no encontrada: " + titulo);
        }
    }

    public void buscarPeliculaPorDirector(String director) {
        PeliculasModelo.Pelicula pelicula = modelo.buscarPorDirector(director);
        if (pelicula != null) {
            vista.mostrarPelicula(pelicula);
        } else {
            vista.mostrarMensaje("Película no encontrada para el director: " + director);
        }
    }

    public void mostrarPeliculaConCalificacionMasAlta() {
        PeliculasModelo.Pelicula pelicula = modelo.peliculaConCalificacionMasAlta();
        vista.mostrarPelicula(pelicula);
    }

    public void mostrarPeliculaConCalificacionMasBaja() {
        PeliculasModelo.Pelicula pelicula = modelo.peliculaConCalificacionMasBaja();
        vista.mostrarPelicula(pelicula);
    }
}
