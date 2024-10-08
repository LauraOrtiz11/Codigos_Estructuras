/*
 *Nicolas Felipe Gonzalez Bello, Laura Valentina Ortiz Bustos 
 */
package prueba_priorityqueue;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Controlador {
    private Vista vista;
    private PriorityQueue<Paquete> colaDePaquetes;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.colaDePaquetes = new PriorityQueue<>();
    }

    //Iniciar el controlador
    public void iniciar() {
        while (true) {
            vista.mostrarMenu();
            int opcion = vista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    agregarPaquete();
                    break;
                case 2:
                    procesarPaquete();
                    break;
                case 3:
                    mostrarTodosLosPaquetes();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return; 
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Agregar un paquete a la cola
    private void agregarPaquete() {
        String nombre = vista.obtenerNombrePaquete(); 
        String destino = vista.obtenerDestino();       
        int prioridad = vista.obtenerPrioridad();     
        
        Paquete paquete = new Paquete(nombre, destino, prioridad); 
        colaDePaquetes.offer(paquete); 
        
        System.out.println("Paquete agregado: " + paquete);
    }

    // Procesar el paquete de mayor prioridad
    private void procesarPaquete() {
        Paquete paquete = colaDePaquetes.poll(); // Obtener y eliminar el paquete de mayor prioridad
        if (paquete != null) {
            vista.mostrarPaqueteProcesado(paquete); // Mostrar información del paquete procesado
        } else {
            System.out.println("No hay paquetes para procesar.");
        }
    }

    // Mostrar todos los paquetes disponibles
    private void mostrarTodosLosPaquetes() {
        List<Paquete> paquetes = new ArrayList<>(colaDePaquetes); 
        vista.mostrarPaquetes(paquetes); 
    }
}