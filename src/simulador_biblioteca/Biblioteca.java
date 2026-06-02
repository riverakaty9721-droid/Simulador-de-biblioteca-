package simulador_biblioteca;

public class Biblioteca {

    // ===== ATRIBUTOS =====
    private Libro[] libros;
    private Usuario[] usuarios;
    private int totalLibros;
    private int totalUsuarios;
    private static final int MAX_LIBROS = 50;
    private static final int MAX_USUARIOS = 20;
    private int contadorIdLibros;
    private int contadorIdUsuarios;

    // ===== CONSTRUCTOR =====
    public Biblioteca() {
        libros = new Libro[MAX_LIBROS];
        usuarios = new Usuario[MAX_USUARIOS];
        totalLibros = 0;
        totalUsuarios = 0;
        contadorIdLibros = 1;
        contadorIdUsuarios = 1;

        // Cargar datos de ejemplo al iniciar
        cargarDatosEjemplo();
    }

    // ===== DATOS DE EJEMPLO =====
    private void cargarDatosEjemplo() {
        agregarLibro("Cien Años de Soledad", "Gabriel García Márquez");
        agregarLibro("El Principito", "Antoine de Saint-Exupéry");
        agregarLibro("Don Quijote de la Mancha", "Miguel de Cervantes");
        agregarLibro("Harry Potter y la Piedra Filosofal", "J.K. Rowling");
        agregarLibro("1984", "George Orwell");

        registrarUsuario("Ana López");
        registrarUsuario("Carlos Pérez");
        registrarUsuario("María González");
    }

    // =========================================================
    //   GESTIÓN DE LIBROS
    // =========================================================

    /**
     * Agrega un nuevo libro al catálogo.
     */
    public boolean agregarLibro(String titulo, String autor) {
        // Validar que no esté lleno
        if (totalLibros >= MAX_LIBROS) {
            System.out.println("  ✗ No se pueden agregar más libros. Catálogo lleno.");
            return false;
        }
        // Validar que no exista ya ese título
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("  ✗ Ya existe un libro con ese título.");
                return false;
            }
        }
        libros[totalLibros] = new Libro(contadorIdLibros++, titulo, autor);
        totalLibros++;
        return true;
    }

    /**
     * Muestra todos los libros del catálogo.
     */
    public void mostrarTodosLosLibros() {
        if (totalLibros == 0) {
            System.out.println("  No hay libros registrados.");
            return;
        }
        System.out.println("  ╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║               CATÁLOGO DE LIBROS                    ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝");
        for (int i = 0; i < totalLibros; i++) {
            System.out.println("   " + libros[i]);
        }
    }

    /**
     * Busca libros por título (búsqueda parcial).
     */
    public void buscarPorTitulo(String titulo) {
        boolean encontrado = false;
        System.out.println("  Resultados para: \"" + titulo + "\"");
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println("   " + libros[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("  ✗ No se encontró ningún libro con ese título.");
        }
    }

    /**
     * Busca libros por autor (búsqueda parcial).
     */
    public void buscarPorAutor(String autor) {
        boolean encontrado = false;
        System.out.println("  Resultados para el autor: \"" + autor + "\"");
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].getAutor().toLowerCase().contains(autor.toLowerCase())) {
                System.out.println("   " + libros[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("  ✗ No se encontró ningún libro de ese autor.");
        }
    }

    // =========================================================
    //   GESTIÓN DE USUARIOS
    // =========================================================

    /**
     * Registra un nuevo usuario.
     */
    public boolean registrarUsuario(String nombre) {
        if (totalUsuarios >= MAX_USUARIOS) {
            System.out.println("  ✗ No se pueden registrar más usuarios.");
            return false;
        }
        // Verificar que no exista ya
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("  ✗ Ya existe un usuario con ese nombre.");
                return false;
            }
        }
        usuarios[totalUsuarios] = new Usuario(contadorIdUsuarios++, nombre);
        totalUsuarios++;
        return true;
    }

    /**
     * Muestra todos los usuarios registrados.
     */
    public void mostrarUsuarios() {
        if (totalUsuarios == 0) {
            System.out.println("  No hay usuarios registrados.");
            return;
        }
        System.out.println("  ╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║               USUARIOS REGISTRADOS                  ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝");
        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println("   " + usuarios[i]);
            usuarios[i].mostrarLibrosPrestados();
        }
    }

    // =========================================================
    //   PRÉSTAMOS Y DEVOLUCIONES
    // =========================================================

    /**
     * Realiza el préstamo de un libro a un usuario.
     */
    public void realizarPrestamo(int idLibro, int idUsuario) {
        // Buscar el libro
        Libro libro = buscarLibroPorId(idLibro);
        if (libro == null) {
            System.out.println("  ✗ No existe un libro con el ID " + idLibro);
            return;
        }
        // Buscar el usuario
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("  ✗ No existe un usuario con el ID " + idUsuario);
            return;
        }
        // Verificar disponibilidad
        if (!libro.isDisponible()) {
            System.out.println("  ✗ El libro \"" + libro.getTitulo() + "\" ya está prestado.");
            return;
        }
        // Realizar el préstamo
        if (usuario.agregarPrestamo(libro.getTitulo())) {
            libro.setDisponible(false);
            System.out.println("  ✓ Préstamo exitoso:");
            System.out.println("    Libro  : " + libro.getTitulo());
            System.out.println("    Usuario: " + usuario.getNombre());
        } else {
            System.out.println("  ✗ " + usuario.getNombre() + " ya tiene el máximo de libros prestados (3).");
        }
    }

    /**
     * Realiza la devolución de un libro por parte de un usuario.
     */
    public void realizarDevolucion(int idLibro, int idUsuario) {
        // Buscar el libro
        Libro libro = buscarLibroPorId(idLibro);
        if (libro == null) {
            System.out.println("  ✗ No existe un libro con el ID " + idLibro);
            return;
        }
        // Buscar el usuario
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("  ✗ No existe un usuario con el ID " + idUsuario);
            return;
        }
        // Realizar devolución
        if (usuario.devolverPrestamo(libro.getTitulo())) {
            libro.setDisponible(true);
            System.out.println("  ✓ Devolución exitosa:");
            System.out.println("    Libro  : " + libro.getTitulo());
            System.out.println("    Usuario: " + usuario.getNombre());
        } else {
            System.out.println("  ✗ " + usuario.getNombre() + " no tiene prestado el libro \"" + libro.getTitulo() + "\"");
        }
    }

    /**
     * Muestra solo los libros disponibles.
     */
    public void mostrarLibrosDisponibles() {
        System.out.println("  ╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║               LIBROS DISPONIBLES                    ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝");
        boolean hay = false;
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].isDisponible()) {
                System.out.println("   " + libros[i]);
                hay = true;
            }
        }
        if (!hay) System.out.println("  No hay libros disponibles en este momento.");
    }

    /**
     * Muestra solo los libros prestados.
     */
    public void mostrarLibrosPrestados() {
        System.out.println("  ╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║               LIBROS PRESTADOS                      ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝");
        boolean hay = false;
        for (int i = 0; i < totalLibros; i++) {
            if (!libros[i].isDisponible()) {
                System.out.println("   " + libros[i]);
                hay = true;
            }
        }
        if (!hay) System.out.println("  No hay libros prestados en este momento.");
    }

    // =========================================================
    //   MÉTODOS PRIVADOS DE BÚSQUEDA INTERNA
    // =========================================================

    private Libro buscarLibroPorId(int id) {
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].getId() == id) return libros[i];
        }
        return null;
    }

    private Usuario buscarUsuarioPorId(int id) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getId() == id) return usuarios[i];
        }
        return null;
    }
}
