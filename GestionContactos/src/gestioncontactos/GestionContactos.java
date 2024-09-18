/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncontactos;

/**
 *
 * @author LAURA VALENTINA ORTIZ BUSTOS NICOLAS FELIPE GONZALEZ BELLO
 */

import java.util.Scanner;

public class GestionContactos {
    public static void main(String[] args) {
        ContactosControlador controlador = new ContactosControlador();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestión de Contactos ---");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Eliminar Contacto");
            System.out.println("3. Mostrar Contactos");
            System.out.println("4. Buscar Contacto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    controlador.agregarContacto(nombre, telefono, correo);
                    break;
                case 2:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    controlador.eliminarContacto(nombreEliminar);
                    break;
                case 3:
                    controlador.mostrarContactos();
                    break;
                case 4:
                    System.out.print("Nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    controlador.buscarContacto(nombreBuscar);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Op xción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
