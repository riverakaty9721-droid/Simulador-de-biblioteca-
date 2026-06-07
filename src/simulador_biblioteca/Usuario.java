package simulador_biblioteca;

public class Usuario {
    private int id;
    private String nombre;
    private String[] librosPrestados;
    private int cantidadPrestados;
    private static final int MAX_PRESTAMOS = 3;

    public Usuario(int id, String nombre) {
        this.id               = id;
        this.nombre           = nombre;
        this.librosPrestados  = new String[MAX_PRESTAMOS];
        this.cantidadPrestados = 0;
    }

    public int    getId()               { return id; }
    public String getNombre()           { return nombre; }
    public int    getCantidadPrestados(){ return cantidadPrestados; }

    public boolean agregarPrestamo(String tituloLibro) {
        if (cantidadPrestados >= MAX_PRESTAMOS) return false;
        librosPrestados[cantidadPrestados++] = tituloLibro;
        return true;
    }

    public boolean devolverPrestamo(String tituloLibro) {
        for (int i = 0; i < cantidadPrestados; i++) {
            if (librosPrestados[i].equalsIgnoreCase(tituloLibro)) {
                librosPrestados[i] = librosPrestados[--cantidadPrestados];
                librosPrestados[cantidadPrestados] = null;
                return true;
            }
        }
        return false;
    }

    public void mostrarLibrosPrestados() {
        String C = Colores.RESET;
        if (cantidadPrestados == 0) {
            System.out.println(Colores.AMARILLO + "   ⚠  " + nombre + " no tiene libros prestados." + C);
            return;
        }
        System.out.println(Colores.CIAN_BRILLANTE + "   📚 Libros de " + nombre + ":" + C);
        for (int i = 0; i < cantidadPrestados; i++) {
            System.out.println(Colores.MAGENTA + "     [" + (i+1) + "] " + librosPrestados[i] + C);
        }
    }

    @Override
    public String toString() {
        String C = Colores.RESET;
        String bar = Colores.AMARILLO + "█".repeat(cantidadPrestados)
                   + Colores.BLANCO  + "░".repeat(MAX_PRESTAMOS - cantidadPrestados) + C;
        return Colores.AZUL_BRILLANTE + "[ID: " + id + "]" + C
             + " " + Colores.BLANCO_BRILLANTE + nombre + C
             + " | Prestados: " + Colores.AMARILLO + cantidadPrestados + "/" + MAX_PRESTAMOS + C
             + " " + bar;
    }
}
