/*
 *Nicolas Felipe Gonzalez Bello, Laura Valentina Ortiz Bustos 
 */
package prueba_priorityqueue;

import java.util.Scanner;
import java.util.List;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("1. Agregar paquete");
        System.out.println("2. Procesar paquete");
        System.out.println("3. Mostrar todos los paquetes");
        System.out.println("4. Salir");
    }

    public int obtenerOpcion() {
        return scanner.nextInt();
    }

    public String obtenerNombrePaquete() {
        System.out.print("Ingrese el nombre del paquete: ");
        scanner.nextLine(); 
        return scanner.nextLine();
    }

    public String obtenerDestino() {
        System.out.print("Ingrese el destino del paquete: ");
        return scanner.nextLine();
    }

    public int obtenerPrioridad() {
        int prioridad;
        do {
            System.out.print("Ingrese la prioridad (1-5): ");
            prioridad = scanner.nextInt();
            if (prioridad < 1 || prioridad > 5) {
                System.out.println("Prioridad no válida. Debe ser un número entre 1 y 5.");
            }
        } while (prioridad < 1 || prioridad > 5);
        return prioridad;
    }

    public void mostrarPaqueteProcesado(Paquete paquete) {
        System.out.println("Procesando paquete: " + paquete);
    }

    public void mostrarPaquetes(List<Paquete> paquetes) {
        if (paquetes.isEmpty()) {
            System.out.println("No hay paquetes disponibles.");
            return;
        }
        
        System.out.println("Paquetes disponibles:");
        for (Paquete paquete : paquetes) {
            System.out.println(paquete);
        }
    }
}