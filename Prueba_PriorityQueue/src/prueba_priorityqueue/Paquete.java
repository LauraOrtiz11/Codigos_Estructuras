/*
 *Nicolas Felipe Gonzalez Bello, Laura Valentina Ortiz Bustos 
 */
package prueba_priorityqueue;

public class Paquete implements Comparable<Paquete> {

    private final String nombre;
    private final String destino;
    private final int prioridad;

    public Paquete(String nombre, String destino, int prioridad) {
        this.nombre = nombre;
        this.destino = destino;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Paquete otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }

    @Override
    public String toString() {
        return "Paquete{"
                + "nombre='" + nombre + '\''
                + ", destino='" + destino + '\''
                + ", prioridad=" + prioridad
                + '}';
    }

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
