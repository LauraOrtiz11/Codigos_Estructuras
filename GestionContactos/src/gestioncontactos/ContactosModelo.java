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
public class ContactosModelo {

    private String nombre;
    private String telefono;
    private String correo;
    ContactosModelo siguiente;
    ContactosModelo anterior;

    public ContactosModelo(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Correo: " + correo;
    }
}
