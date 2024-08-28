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
* NICOLAS FELIPE GONZALEZ BELLO 
 */
import java.util.List;
import java.util.Scanner;

public class PeliculasVista {
    private PeliculasModelo modelo;
    private PeliculasControlador controlador;
    private Scanner scanner;

    public PeliculasVista() {
        modelo = new PeliculasModelo();
        controlador = new PeliculasControlador(modelo, this);
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        PeliculasVista app = new PeliculasVista();
        app.mostrarMenu();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú de Catálogo de Películas");
            System.out.println("1. Añadir nueva película");
            System.out.println("2. Mostrar películas ordenadas por año de lanzamiento");
            System.out.println("3. Mostrar películas ordenadas por calificación");
            System.out.println("4. Buscar película por título");
            System.out.println("5. Buscar película por director");
            System.out.println("6. Mostrar película con calificación más alta");
            System.out.println("7. Mostrar película con calificación más baja");
            System.out.println("8. Mostrar todo el catálogo");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarPelicula();
                    break;
                case 2:
                    controlador.ordenarPeliculasPorAno();
                    break;
                case 3:
                    controlador.ordenarPeliculasPorCalificacion();
                    break;
                case 4:
                    buscarPeliculaPorTitulo();
                    break;
                case 5:
                    buscarPeliculaPorDirector();
                    break;
                case 6:
                    controlador.mostrarPeliculaConCalificacionMasAlta();
                    break;
                case 7:
                    controlador.mostrarPeliculaConCalificacionMasBaja();
                    break;
                case 8:
                    mostrarCatalogoSoloLectura();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);
    }

    private void agregarPelicula() {
        System.out.print("Ingrese el título de la película: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el director de la película: ");
        String director = scanner.nextLine();
        System.out.print("Ingrese el año de lanzamiento: ");
        int anoLanzamiento = scanner.nextInt();
        System.out.print("Ingrese la calificación (0.0 - 10.0): ");
        double calificacion = scanner.nextDouble();
        scanner.nextLine();  

        controlador.anadirPelicula(titulo, director, anoLanzamiento, calificacion);
    }

    private void buscarPeliculaPorTitulo() {
        System.out.print("Ingrese el título de la película: ");
        String titulo = scanner.nextLine();
        controlador.buscarPeliculaPorTitulo(titulo);
    }

    private void buscarPeliculaPorDirector() {
        System.out.print("Ingrese el director de la película: ");
        String director = scanner.nextLine();
        controlador.buscarPeliculaPorDirector(director);
    }

    private void mostrarCatalogoSoloLectura() {
        List<PeliculasModelo.Pelicula> catalogoSoloLectura = modelo.obtenerCatalogoSoloLectura();
        System.out.println("Catálogo de películas (Solo Lectura):");
        for (PeliculasModelo.Pelicula pelicula : catalogoSoloLectura) {
            System.out.println(pelicula.getTitulo() + " - " + pelicula.getDirector() + " - " +
                               pelicula.getAnoLanzamiento() + " - " + pelicula.getCalificacion());
        }
    }

    public void mostrarCatalogo(List<PeliculasModelo.Pelicula> catalogo) {
        System.out.println("Catálogo de películas:");
        for (PeliculasModelo.Pelicula pelicula : catalogo) {
            System.out.println(pelicula.getTitulo() + " - " + pelicula.getDirector() + " - " +
                               pelicula.getAnoLanzamiento() + " - " + pelicula.getCalificacion());
        }
    }

    public void mostrarPelicula(PeliculasModelo.Pelicula pelicula) {
        System.out.println("Película encontrada:");
        System.out.println(pelicula.getTitulo() + " - " + pelicula.getDirector() + " - " +
                           pelicula.getAnoLanzamiento() + " - " + pelicula.getCalificacion());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
