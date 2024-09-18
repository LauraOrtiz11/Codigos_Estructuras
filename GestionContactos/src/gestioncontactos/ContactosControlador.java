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
public class ContactosControlador {

    private ContactosModelo head;
    private ContactosModelo tail;

    public ContactosControlador() {
        this.head = null;
        this.tail = null;
    }

    // Agregar un contacto
    public void agregarContacto(String nombre, String telefono, String correo) {
        ContactosModelo nuevoContacto = new ContactosModelo(nombre, telefono, correo);
        if (head == null) {
            head = tail = nuevoContacto;
        } else {
            tail.siguiente = nuevoContacto;
            nuevoContacto.anterior = tail;
            tail = nuevoContacto;
        }
    }

    // Eliminar un contacto por nombre
    public void eliminarContacto(String nombre) {
        ContactosModelo actual = head;
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                if (actual == head) {
                    head = head.siguiente;
                    if (head != null) {
                        head.anterior = null;
                    }
                } else if (actual == tail) {
                    tail = tail.anterior;
                    if (tail != null) {
                        tail.siguiente = null;
                    }
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                System.out.println("Contacto " + nombre + " eliminado.");
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Contacto " + nombre + " no encontrado.");
    }

    // Mostrar todos los contactos
    public void mostrarContactos() {
        if (head == null) {
            System.out.println("La lista de contactos está vacía.");
            return;
        }
        ContactosModelo actual = head;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.siguiente;
        }
    }

    // Buscar un contacto por nombre
    public void buscarContacto(String nombre) {
        ContactosModelo actual = head;
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                System.out.println("Contacto encontrado: " + actual);
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Contacto " + nombre + " no encontrado.");
    }
}
