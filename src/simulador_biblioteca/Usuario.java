package simulador_biblioteca;

public class Usuario {

    // ===== ATRIBUTOS =====
    private int id;
    private String nombre;
    private String[] librosPrestados;   // Arreglo de títulos prestados
    private int cantidadPrestados;
    private static final int MAX_PRESTAMOS = 3; // Máximo de libros por usuario

    // ===== CONSTRUCTOR =====
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.librosPrestados = new String[MAX_PRESTAMOS];
        this.cantidadPrestados = 0;
    }

    // ===== GETTERS =====
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadPrestados() {
        return cantidadPrestados;
    }

    // ===== MÉTODOS =====

    /**
     * Agrega un libro al registro de préstamos del usuario.
     * Retorna true si se pudo agregar, false si ya llegó al límite.
     */
    public boolean agregarPrestamo(String tituloLibro) {
        if (cantidadPrestados < MAX_PRESTAMOS) {
            librosPrestados[cantidadPrestados] = tituloLibro;
            cantidadPrestados++;
            return true;
        }
        return false; // Ya tiene el máximo de libros
    }

    /**
     * Elimina un libro del registro de préstamos del usuario.
     * Retorna true si se encontró y eliminó, false si no tenía ese libro.
     */
    public boolean devolverPrestamo(String tituloLibro) {
        for (int i = 0; i < cantidadPrestados; i++) {
            if (librosPrestados[i].equalsIgnoreCase(tituloLibro)) {
                // Desplazar los demás libros hacia la izquierda
                for (int j = i; j < cantidadPrestados - 1; j++) {
                    librosPrestados[j] = librosPrestados[j + 1];
                }
                librosPrestados[cantidadPrestados - 1] = null;
                cantidadPrestados--;
                return true;
            }
        }
        return false; // No tenía ese libro
    }

    /**
     * Muestra los libros que tiene prestados el usuario.
     */
    public void mostrarLibrosPrestados() {
        if (cantidadPrestados == 0) {
            System.out.println("   " + nombre + " no tiene libros prestados.");
        } else {
            System.out.println("   Libros de " + nombre + ":");
            for (int i = 0; i < cantidadPrestados; i++) {
                System.out.println("     - " + librosPrestados[i]);
            }
        }
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "[ID: " + id + "] " + nombre + " | Libros prestados: " + cantidadPrestados + "/" + MAX_PRESTAMOS;
    }
}
