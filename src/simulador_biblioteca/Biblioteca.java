package simulador_biblioteca;

public class Biblioteca {
    private Libro[]   libros;
    private Usuario[] usuarios;
    private int totalLibros   = 0;
    private int totalUsuarios = 0;
    private static final int MAX_LIBROS   = 50;
    private static final int MAX_USUARIOS = 30;
    private int contadorIdLibros   = 1;
    private int contadorIdUsuarios = 1;

    public Biblioteca() {
        libros   = new Libro[MAX_LIBROS];
        usuarios = new Usuario[MAX_USUARIOS];
        cargarDatosEjemplo();
    }

    private void cargarDatosEjemplo() {
        agregarLibro("Cien Años de Soledad",             "Gabriel García Márquez");
        agregarLibro("El Principito",                    "Antoine de Saint-Exupéry");
        agregarLibro("Don Quijote de la Mancha",         "Miguel de Cervantes");
        agregarLibro("Harry Potter y la Piedra Filosofal","J.K. Rowling");
        agregarLibro("1984",                             "George Orwell");
        registrarUsuario("Ana López");
        registrarUsuario("Carlos Pérez González");
    }

    // ─── LIBROS ────────────────────────────────────────────────────────────────

    public boolean agregarLibro(String titulo, String autor) {
        String C = Colores.RESET;
        if (totalLibros >= MAX_LIBROS) {
            System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ ¡Catálogo lleno! No se pueden agregar más libros." + C);
            return false;
        }
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(Colores.AMARILLO + "\n  ⚠  Ya existe un libro con ese título en el catálogo." + C);
                return false;
            }
        }
        libros[totalLibros++] = new Libro(contadorIdLibros++, titulo, autor);
        return true;
    }

    public void mostrarTodosLosLibros() {
        String C = Colores.RESET;
        if (totalLibros == 0) {
            System.out.println(Colores.AMARILLO + "\n  ⚠  El catálogo está vacío. ¡Agrega el primer libro!" + C);
            return;
        }
        Colores.linea("═", 58, Colores.AZUL_BRILLANTE);
        System.out.println(Colores.FONDO_AZUL + Colores.BLANCO_BRILLANTE
                + "            📖  CATÁLOGO DE LIBROS  📖             " + C);
        Colores.linea("═", 58, Colores.AZUL_BRILLANTE);
        for (int i = 0; i < totalLibros; i++) {
            System.out.println("  " + libros[i]);
        }
        Colores.linea("─", 58, Colores.AZUL);
        System.out.println(Colores.CIAN + "  Total: " + totalLibros + " libro(s) registrado(s)." + C);
    }

    public void buscarPorTitulo(String titulo) {
        String C = Colores.RESET;
        boolean encontrado = false;
        Colores.linea("─", 58, Colores.CIAN);
        System.out.println(Colores.CIAN_BRILLANTE + "  🔍 Resultados para: \"" + titulo + "\"" + C);
        Colores.linea("─", 58, Colores.CIAN);
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println("  " + libros[i]);
                encontrado = true;
            }
        }
        if (!encontrado)
            System.out.println(Colores.ROJO + "\n  ✘ No se encontró ningún libro con ese título." + C);
    }

    public void buscarPorAutor(String autor) {
        String C = Colores.RESET;
        boolean encontrado = false;
        Colores.linea("─", 58, Colores.CIAN);
        System.out.println(Colores.CIAN_BRILLANTE + "  🔍 Resultados para autor: \"" + autor + "\"" + C);
        Colores.linea("─", 58, Colores.CIAN);
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].getAutor().toLowerCase().contains(autor.toLowerCase())) {
                System.out.println("  " + libros[i]);
                encontrado = true;
            }
        }
        if (!encontrado)
            System.out.println(Colores.ROJO + "\n  ✘ No se encontró ningún libro de ese autor." + C);
    }

    // ─── USUARIOS ──────────────────────────────────────────────────────────────

    public boolean registrarUsuario(String nombre) {
        String C = Colores.RESET;
        if (totalUsuarios >= MAX_USUARIOS) {
            System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ ¡Límite de usuarios alcanzado!" + C);
            return false;
        }
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(Colores.AMARILLO + "\n  ⚠  Ya existe un usuario con ese nombre." + C);
                return false;
            }
        }
        usuarios[totalUsuarios++] = new Usuario(contadorIdUsuarios++, nombre);
        return true;
    }

    public void mostrarUsuarios() {
        String C = Colores.RESET;
        if (totalUsuarios == 0) {
            System.out.println(Colores.AMARILLO + "\n  ⚠  No hay usuarios registrados aún." + C);
            return;
        }
        Colores.linea("═", 58, Colores.MAGENTA_BRILLANTE);
        System.out.println(Colores.FONDO_MAGENTA + Colores.BLANCO_BRILLANTE
                + "          👤  USUARIOS REGISTRADOS  👤           " + C);
        Colores.linea("═", 58, Colores.MAGENTA_BRILLANTE);
        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println("  " + usuarios[i]);
        }
        Colores.linea("─", 58, Colores.MAGENTA);
        System.out.println(Colores.CIAN + "  Total: " + totalUsuarios + " usuario(s) registrado(s)." + C);
    }

    // ─── PRÉSTAMOS ─────────────────────────────────────────────────────────────

    public void mostrarLibrosDisponibles() {
        String C = Colores.RESET;
        boolean hay = false;
        Colores.linea("─", 58, Colores.VERDE);
        System.out.println(Colores.VERDE_BRILLANTE + "  ✔  Libros disponibles:" + C);
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].isDisponible()) { System.out.println("  " + libros[i]); hay = true; }
        }
        if (!hay) System.out.println(Colores.AMARILLO + "  ⚠  No hay libros disponibles en este momento." + C);
    }

    public void mostrarLibrosPrestados() {
        String C = Colores.RESET;
        boolean hay = false;
        Colores.linea("─", 58, Colores.ROJO);
        System.out.println(Colores.ROJO_BRILLANTE + "  ✘  Libros prestados:" + C);
        for (int i = 0; i < totalLibros; i++) {
            if (!libros[i].isDisponible()) { System.out.println("  " + libros[i]); hay = true; }
        }
        if (!hay) System.out.println(Colores.VERDE + "  ✔  Todos los libros están disponibles. ¡Genial!" + C);
    }

    public void realizarPrestamo1(int idLibro, int idUsuario) {
        String C = Colores.RESET;
        Libro lib   = buscarLibroPorId(idLibro);
        Usuario usr = buscarUsuarioPorId(idUsuario);
        if (lib == null) {
            System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ No existe ningún libro con ese ID." + C); return;
        }
        if (usr == null) {
            System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ No existe ningún usuario con ese ID." + C); return;
        }
        if (!lib.isDisponible()) {
            System.out.println(Colores.ROJO + "\n  ✘ El libro \"" + lib.getTitulo() + "\" ya está prestado." + C); return;
        }
        if (!usr.agregarPrestamo(lib.getTitulo())) {
            System.out.println(Colores.ROJO + "\n  ✘ " + usr.getNombre() + " ya tiene el máximo de préstamos (3)." + C); return;
        }
        lib.setDisponible(false);
        Colores.linea("★", 58, Colores.VERDE_BRILLANTE);
        System.out.println(Colores.VERDE_BRILLANTE
                + "  ✔  ¡Préstamo realizado exitosamente!" + C);
        System.out.println(Colores.CIAN + "  📖 Libro   : " + Colores.AMARILLO_BRILLANTE + lib.getTitulo() + C);
        System.out.println(Colores.CIAN + "  👤 Usuario : " + Colores.BLANCO_BRILLANTE   + usr.getNombre() + C);
        Colores.linea("★", 58, Colores.VERDE_BRILLANTE);
    }

    public void realizarDevolucion(int idLibro, int idUsuario) {
        String C = Colores.RESET;
        Libro lib   = buscarLibroPorId(idLibro);
        Usuario usr = buscarUsuarioPorId(idUsuario);
        if (lib == null) {
            System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ No existe ningún libro con ese ID." + C); return;
        }
        if (usr == null) {
            System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ No existe ningún usuario con ese ID." + C); return;
        }
        if (lib.isDisponible()) {
            System.out.println(Colores.AMARILLO + "\n  ⚠  El libro \"" + lib.getTitulo() + "\" no figura como prestado." + C); return;
        }
        if (!usr.devolverPrestamo(lib.getTitulo())) {
            System.out.println(Colores.ROJO + "\n  ✘ " + usr.getNombre() + " no tiene registrado ese libro." + C); return;
        }
        lib.setDisponible(true);
        Colores.linea("★", 58, Colores.CIAN_BRILLANTE);
        System.out.println(Colores.CIAN_BRILLANTE
                + "  ✔  ¡Devolución registrada exitosamente!" + C);
        System.out.println(Colores.CIAN + "  📖 Libro   : " + Colores.AMARILLO_BRILLANTE + lib.getTitulo() + C);
        System.out.println(Colores.CIAN + "  👤 Usuario : " + Colores.BLANCO_BRILLANTE   + usr.getNombre() + C);
        Colores.linea("★", 58, Colores.CIAN_BRILLANTE);
    }

    // ─── HELPERS ───────────────────────────────────────────────────────────────

    public String nombreLibroPorId(int id) {
        Libro l = buscarLibroPorId(id);
        return l != null ? l.getTitulo() : "Desconocido";
    }

    public Libro buscarLibroPorId(int id) {
        for (int i = 0; i < totalLibros; i++)
            if (libros[i].getId() == id) return libros[i];
        return null;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (int i = 0; i < totalUsuarios; i++)
            if (usuarios[i].getId() == id) return usuarios[i];
        return null;
    }
    public void realizarPrestamo(int idLibro, int idUsuario) {
        String C = Colores.RESET;
        Libro lib   = buscarLibroPorId(idLibro);
        Usuario usr = buscarUsuarioPorId(idUsuario);
        if (lib == null) {
            System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ No existe ningún libro con ese ID." + C); return;
        }
        if (usr == null) {
            System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ No existe ningún usuario con ese ID." + C); return;
        }
        if (!lib.isDisponible()) {
            System.out.println(Colores.ROJO + "\n  ✘ El libro \"" + lib.getTitulo() + "\" ya está prestado." + C); return;
        }
        if (!usr.agregarPrestamo(lib.getTitulo())) {
            System.out.println(Colores.ROJO + "\n  ✘ " + usr.getNombre() + " ya tiene el máximo de préstamos (3)." + C); return;
        }
        lib.setDisponible(false);
        imprimirTicket(lib, usr);
    }

    public void imprimirTicket(Libro lib, Usuario usr) {
        String C = Colores.RESET;
        java.time.LocalDateTime ahora = java.time.LocalDateTime.now();
        String fecha = String.format("%02d/%02d/%04d",
                ahora.getDayOfMonth(), ahora.getMonthValue(), ahora.getYear());
        String hora  = String.format("%02d:%02d",
                ahora.getHour(), ahora.getMinute());

        System.out.println();
        Colores.linea("═", 50, Colores.AMARILLO_BRILLANTE);
        System.out.println(Colores.AMARILLO_BRILLANTE
                + "  ╔══════════════════════════════════════════╗" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "  ║" + Colores.BLANCO_BRILLANTE
                + "          🎫  TICKET DE PRÉSTAMO  🎫        "
                + Colores.AMARILLO_BRILLANTE + "║" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE
                + "  ╠══════════════════════════════════════════╣" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "  ║ " + Colores.CIAN
                + "  📖 Libro   : " + Colores.BLANCO_BRILLANTE
                + padDerecha(lib.getTitulo(), 27)
                + Colores.AMARILLO_BRILLANTE + "║" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "  ║ " + Colores.CIAN
                + "  👤 Usuario : " + Colores.BLANCO_BRILLANTE
                + padDerecha(usr.getNombre(), 27)
                + Colores.AMARILLO_BRILLANTE + "║" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "  ║ " + Colores.CIAN
                + "  📅 Fecha   : " + Colores.BLANCO_BRILLANTE
                + padDerecha(fecha, 27)
                + Colores.AMARILLO_BRILLANTE + "║" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "  ║ " + Colores.CIAN
                + "  🕐 Hora    : " + Colores.BLANCO_BRILLANTE
                + padDerecha(hora, 27)
                + Colores.AMARILLO_BRILLANTE + "║" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "  ║ " + Colores.VERDE_BRILLANTE
                + "  ✔  Estado  : PRESTADO                    "
                + Colores.AMARILLO_BRILLANTE + "║" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE
                + "  ╠══════════════════════════════════════════╣" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "  ║ " + Colores.ROJO
                + "  ⚠  Devolver en máximo 7 días             "
                + Colores.AMARILLO_BRILLANTE + "║" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "  ║ " + Colores.MAGENTA
                + "  🏫 Instituto Nacional de Sonzacate        "
                + Colores.AMARILLO_BRILLANTE + "║" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE
                + "  ╚══════════════════════════════════════════╝" + C);
        Colores.linea("═", 50, Colores.AMARILLO_BRILLANTE);
        System.out.println(Colores.VERDE_BRILLANTE
                + "\n  ✔  ¡Préstamo registrado exitosamente! 🎉" + C);
    }

    private String padDerecha(String texto, int largo) {
        if (texto.length() > largo) texto = texto.substring(0, largo - 3) + "...";
        return String.format("%-" + largo + "s", texto);
    }
}
