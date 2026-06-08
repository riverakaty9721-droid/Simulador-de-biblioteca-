package simulador_biblioteca;

public abstract class Usuario {
	protected int id;
	protected String nombre;
	protected String[] librosPrestados;
	protected int cantidadPrestados;
	protected int maxPrestamos; // <-- Nueva variable

	public Usuario(int id, String nombre, int maxPrestamos) { // <-- Agregas parámetro
	    this.id = id;
	    this.nombre = nombre;
	    this.maxPrestamos = maxPrestamos; // <-- Lo guardas
	    this.librosPrestados = new String[this.maxPrestamos]; // <-- El arreglo usa el nuevo límite
	    this.cantidadPrestados = 0;
	}

    public int    getId()               { return id; }
    public String getNombre()           { return nombre; }
    public int    getCantidadPrestados(){ return cantidadPrestados; }

    public boolean agregarPrestamo(String tituloLibro) {
    	if (cantidadPrestados >= maxPrestamos) return false;
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
                   + Colores.BLANCO  + "░".repeat(maxPrestamos - cantidadPrestados) + C;
        return Colores.AZUL_BRILLANTE + "[ID: " + id + "]" + C
             + " " + Colores.BLANCO_BRILLANTE + nombre + C
             + " | Prestados: " + Colores.AMARILLO + cantidadPrestados + "/" + maxPrestamos + C
             + " " + bar;
    }
}
