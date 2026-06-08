
package simulador_biblioteca;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Biblioteca biblioteca = new Biblioteca();
    private static final MusicaFondo musica = new MusicaFondo(
    	    "sounds/fondo.wav"
    	);
    

    public static void main(String[] args) {
        musica.iniciar();
        mostrarBienvenida();

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEnteroValidado(Colores.AMARILLO_BRILLANTE
                    + "  ➤  Elige una opción: " + Colores.RESET);
            switch (opcion) {
                case 1 -> mostrarGuia();
                case 2 -> menuLibros();
                case 3 -> menuUsuarios();
                case 4 -> menuPrestamos();
                case 5 -> menuConsultas();
                case 0 -> despedida();
                default -> System.out.println(Colores.ROJO_BRILLANTE
                        + "\n  ✘ Opción no válida. Por favor elige entre las opciones del menú.\n"
                        + Colores.RESET);
            }
        } while (opcion != 0);

        musica.detener();
        scanner.close();
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  PANTALLAS PRINCIPALES
    // ══════════════════════════════════════════════════════════════════════════

    private static void mostrarBienvenida() {
        Colores.limpiarPantalla();
        String C = Colores.RESET;
        Colores.linea("═", 50, Colores.AZUL_BRILLANTE);
        System.out.println(Colores.AZUL_BRILLANTE + "  ╔══════════════════════════════════════════╗" + C);
        System.out.println(Colores.AZUL_BRILLANTE + "  ║" + Colores.AMARILLO_BRILLANTE
                + "        📚  SISTEMA DE BIBLIOTECA  📚      "
                + Colores.AZUL_BRILLANTE + "║" + C);
        System.out.println(Colores.AZUL_BRILLANTE + "  ╚══════════════════════════════════════════╝" + C);
        Colores.linea("═", 50, Colores.AZUL_BRILLANTE);
        System.out.println(Colores.CIAN    + "  📖  Sistema de Gestión de Biblioteca"         + C);
        System.out.println(Colores.BLANCO  + "  🏫  Instituto Nacional de Sonzacate"          + C);
        System.out.println(Colores.MAGENTA + "  👥  Integrantes: Melder | Katherin | Kenneth" + C);
        Colores.linea("═", 50, Colores.AZUL_BRILLANTE);
        System.out.println(Colores.VERDE_BRILLANTE + "\n  ✔  Sistema iniciado correctamente." + C);
        System.out.println(Colores.VERDE_BRILLANTE + "  📂  Se cargaron datos de ejemplo.\n" + C);
        pausar();
    }

    private static void mostrarMenuPrincipal() {
        Colores.limpiarPantalla();
        String C = Colores.RESET;
        Colores.linea("═", 50, Colores.CIAN_BRILLANTE);
        System.out.println(Colores.CIAN_BRILLANTE + "  ╔══════════════════════════════════════════╗" + C);
        System.out.println(Colores.CIAN_BRILLANTE + "  ║" + Colores.BLANCO_BRILLANTE
                + "            📋  MENÚ PRINCIPAL  📋          "
                + Colores.CIAN_BRILLANTE + "║" + C);
        System.out.println(Colores.CIAN_BRILLANTE + "  ╚══════════════════════════════════════════╝" + C);
        Colores.linea("═", 50, Colores.CIAN_BRILLANTE);
        System.out.println(Colores.VERDE_BRILLANTE  + "   1. " + Colores.BLANCO + "📘  Guía de uso"              + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "   2. " + Colores.BLANCO + "📖  Gestión de Libros"        + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "   3. " + Colores.BLANCO + "👤  Gestión de Usuarios"      + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "   4. " + Colores.BLANCO + "🔄  Préstamos y Devoluciones" + C);
        System.out.println(Colores.AMARILLO_BRILLANTE + "   5. " + Colores.BLANCO + "🔍  Consultas y Reportes"     + C);
        System.out.println(Colores.ROJO_BRILLANTE     + "   0. " + Colores.BLANCO + "🚪  Salir del sistema"        + C);
        Colores.linea("─", 50, Colores.CIAN);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  GUÍA DE USO
    // ══════════════════════════════════════════════════════════════════════════

    private static void mostrarGuia() {
        Colores.limpiarPantalla();
        String C = Colores.RESET;
        Colores.linea("═", 50, Colores.VERDE_BRILLANTE);
        System.out.println(Colores.VERDE_BRILLANTE + "  ╔══════════════════════════════════════════╗" + C);
        System.out.println(Colores.VERDE_BRILLANTE + "  ║" + Colores.BLANCO_BRILLANTE
                + "           📘  GUÍA DE USO  📘             "
                + Colores.VERDE_BRILLANTE + "║" + C);
        System.out.println(Colores.VERDE_BRILLANTE + "  ╚══════════════════════════════════════════╝" + C);
        Colores.linea("═", 50, Colores.VERDE_BRILLANTE);

        System.out.println(Colores.AMARILLO_BRILLANTE + "\n  📤 ¿Cómo pedir prestado un libro?" + C);
        Colores.linea("─", 50, Colores.AMARILLO);
        System.out.println(Colores.BLANCO + "   1. Ve al menú principal opción 4"          + C);
        System.out.println(Colores.BLANCO + "   2. Elige opción 1 → Realizar préstamo"     + C);
        System.out.println(Colores.BLANCO + "   3. Revisa la lista de libros disponibles"  + C);
        System.out.println(Colores.BLANCO + "   4. Anota el ID del libro que deseas"       + C);
        System.out.println(Colores.BLANCO + "   5. Ingresa tu ID de usuario"               + C);
        System.out.println(Colores.VERDE_BRILLANTE + "   ✔  ¡Recibirás tu ticket de préstamo!" + C);

        System.out.println(Colores.AMARILLO_BRILLANTE + "\n  📥 ¿Cómo devolver un libro?" + C);
        Colores.linea("─", 50, Colores.AMARILLO);
        System.out.println(Colores.BLANCO + "   1. Ve al menú principal opción 4"          + C);
        System.out.println(Colores.BLANCO + "   2. Elige opción 2 → Registrar devolución"  + C);
        System.out.println(Colores.BLANCO + "   3. Ingresa el ID del libro a devolver"     + C);
        System.out.println(Colores.BLANCO + "   4. Ingresa tu ID de usuario"               + C);
        System.out.println(Colores.VERDE_BRILLANTE + "   ✔  ¡Devolución registrada!"       + C);

        System.out.println(Colores.AMARILLO_BRILLANTE + "\n  🔍 ¿Cómo buscar un libro?" + C);
        Colores.linea("─", 50, Colores.AMARILLO);
        System.out.println(Colores.BLANCO + "   1. Ve al menú principal opción 2"          + C);
        System.out.println(Colores.BLANCO + "   2. Elige opción 3 para buscar por título"  + C);
        System.out.println(Colores.BLANCO + "   3. Elige opción 4 para buscar por autor"   + C);

        System.out.println(Colores.AMARILLO_BRILLANTE + "\n  ⚠  Reglas importantes:" + C);
        Colores.linea("─", 50, Colores.AMARILLO);
        System.out.println(Colores.ROJO + "   ✘  Máximo 3 libros prestados por usuario"  + C);
        System.out.println(Colores.ROJO + "   ✘  Devolver en máximo 7 días"              + C);
        System.out.println(Colores.VERDE_BRILLANTE + "   ✔  Trata bien los libros 📖"    + C);

        Colores.linea("═", 50, Colores.VERDE_BRILLANTE);
        pausar();
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENÚ 2 - LIBROS
    // ══════════════════════════════════════════════════════════════════════════

    private static void menuLibros() {
        int op;
        do {
            String C = Colores.RESET;
            System.out.println();
            Colores.linea("═", 50, Colores.AZUL_BRILLANTE);
            System.out.println(Colores.AZUL_BRILLANTE + "  ╔══════════════════════════════════════════╗" + C);
            System.out.println(Colores.AZUL_BRILLANTE + "  ║" + Colores.BLANCO_BRILLANTE
                    + "           📖  GESTIÓN DE LIBROS  📖        "
                    + Colores.AZUL_BRILLANTE + "║" + C);
            System.out.println(Colores.AZUL_BRILLANTE + "  ╚══════════════════════════════════════════╝" + C);
            Colores.linea("═", 50, Colores.AZUL_BRILLANTE);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   1. " + Colores.BLANCO + "➕  Agregar nuevo libro"     + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   2. " + Colores.BLANCO + "📋  Ver todos los libros"    + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   3. " + Colores.BLANCO + "🔎  Buscar por título"       + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   4. " + Colores.BLANCO + "🔎  Buscar por autor"        + C);
            System.out.println(Colores.ROJO_BRILLANTE     + "   0. " + Colores.BLANCO + "↩  Volver al menú principal" + C);
            Colores.linea("─", 50, Colores.AZUL);

            op = leerEnteroValidado(Colores.AMARILLO_BRILLANTE + "  ➤  Opción: " + C);
            switch (op) {
            case 1 -> {
                System.out.print(Colores.CIAN + "  📖 Título del libro : " + Colores.RESET);
                String titulo = scanner.nextLine().trim();
                
                System.out.print(Colores.CIAN + "  ✍ Autor del libro  : " + Colores.RESET);
                String autor = scanner.nextLine().trim();
                
                // NUEVO: Pedimos la categoría
                System.out.print(Colores.CIAN + "  🏷 Categoría (Ej: Novela, Referencia) : " + Colores.RESET);
                String categoria = scanner.nextLine().trim();
                
                // Validamos que ninguno de los tres esté vacío
                if (titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty()) {
                    System.out.println(Colores.ROJO + "\n  ✖ El título, autor y categoría no pueden estar vacíos." + Colores.RESET);
                } else if (biblioteca.agregarLibro(titulo, autor, categoria)) { // Pasamos los 3 datos aquí
                    System.out.println(Colores.VERDE_BRILLANTE 
                        + "\n  ✔ ¡Libro \"" + titulo + "\" agregado exitosamente! 🎉" + Colores.RESET);
                }
            }
                case 2 -> { System.out.println(); biblioteca.mostrarTodosLosLibros(); }
                case 3 -> {
                    System.out.print(Colores.CIAN + "  🔎 Título a buscar: " + Colores.RESET);
                    biblioteca.buscarPorTitulo(scanner.nextLine().trim());
                }
                case 4 -> {
                    System.out.print(Colores.CIAN + "  🔎 Autor a buscar: " + Colores.RESET);
                    biblioteca.buscarPorAutor(scanner.nextLine().trim());
                }
                case 0  -> {}
                default -> System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ Opción no válida.\n" + Colores.RESET);
            }
            if (op != 0) pausar();
        } while (op != 0);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENÚ 3 - USUARIOS
    // ══════════════════════════════════════════════════════════════════════════

    private static void menuUsuarios() {
        int op;
        do {
            String C = Colores.RESET;
            System.out.println();
            Colores.linea("═", 50, Colores.MAGENTA_BRILLANTE);
            System.out.println(Colores.MAGENTA_BRILLANTE + "  ╔══════════════════════════════════════════╗" + C);
            System.out.println(Colores.MAGENTA_BRILLANTE + "  ║" + Colores.BLANCO_BRILLANTE
                    + "         👤  GESTIÓN DE USUARIOS  👤        "
                    + Colores.MAGENTA_BRILLANTE + "║" + C);
            System.out.println(Colores.MAGENTA_BRILLANTE + "  ╚══════════════════════════════════════════╝" + C);
            Colores.linea("═", 50, Colores.MAGENTA_BRILLANTE);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   1. " + Colores.BLANCO + "➕  Registrar nuevo usuario"  + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   2. " + Colores.BLANCO + "📋  Ver todos los usuarios"   + C);
            System.out.println(Colores.ROJO_BRILLANTE     + "   0. " + Colores.BLANCO + "↩  Volver al menú principal"  + C);
            Colores.linea("─", 50, Colores.MAGENTA);

            op = leerEnteroValidado(Colores.AMARILLO_BRILLANTE + "  ➤  Opción: " + C);
            switch (op) {
                case 1 -> {
                	System.out.print(Colores.CIAN + "  📖 Nombre del usuario: " + Colores.RESET);
                	String nombre = scanner.nextLine().trim();

                	if (nombre.isEmpty()) {
                	    System.out.println(Colores.ROJO + "\n  ✖ El nombre no puede estar vacío." + Colores.RESET);
                	    return;
                	}

                	// NUEVO: Preguntamos el tipo
                	System.out.println(Colores.AMARILLO_BRILLANTE + "  1. Estudiante (Max 3 libros)");
                	System.out.println("  2. Docente (Max 5 libros)" + Colores.RESET);
                	System.out.print(Colores.CIAN + "  ▶ Tipo de usuario: " + Colores.RESET);
                	int tipo = Integer.parseInt(scanner.nextLine());

                	// Pasamos la variable 'tipo' al método
                	if (biblioteca.registrarUsuario(nombre, tipo)) {
                	    System.out.println(Colores.VERDE_BRILLANTE + "\n  ✔ ¡Usuario registrado exitosamente!" + Colores.RESET);
                	}
                }
                case 2 -> { System.out.println(); biblioteca.mostrarUsuarios(); }
                case 0  -> {}
                default -> System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ Opción no válida.\n" + Colores.RESET);
            }
            if (op != 0) pausar();
        } while (op != 0);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENÚ 4 - PRÉSTAMOS Y DEVOLUCIONES
    // ══════════════════════════════════════════════════════════════════════════

    private static void menuPrestamos() {
        int op;
        do {
            String C = Colores.RESET;
            System.out.println();
            Colores.linea("═", 50, Colores.VERDE_BRILLANTE);
            System.out.println(Colores.VERDE_BRILLANTE + "  ╔══════════════════════════════════════════╗" + C);
            System.out.println(Colores.VERDE_BRILLANTE + "  ║" + Colores.NEGRO
                    + "      🔄  PRÉSTAMOS Y DEVOLUCIONES  🔄      "
                    + Colores.VERDE_BRILLANTE + "║" + C);
            System.out.println(Colores.VERDE_BRILLANTE + "  ╚══════════════════════════════════════════╝" + C);
            Colores.linea("═", 50, Colores.VERDE_BRILLANTE);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   1. " + Colores.BLANCO + "📤  Realizar préstamo"        + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   2. " + Colores.BLANCO + "📥  Registrar devolución"     + C);
            System.out.println(Colores.ROJO_BRILLANTE     + "   0. " + Colores.BLANCO + "↩  Volver al menú principal"  + C);
            Colores.linea("─", 50, Colores.VERDE);

            op = leerEnteroValidado(Colores.AMARILLO_BRILLANTE + "  ➤  Opción: " + C);
            switch (op) {
                case 1 -> {
                    System.out.println(Colores.CIAN_BRILLANTE + "\n  ── Libros disponibles ──" + Colores.RESET);
                    biblioteca.mostrarLibrosDisponibles();
                    System.out.println(Colores.CIAN_BRILLANTE + "\n  ── Usuarios registrados ──" + Colores.RESET);
                    biblioteca.mostrarUsuarios();
                    int idL = leerEnteroValidado(Colores.CIAN + "\n  ID del libro a prestar  : " + Colores.RESET);
                    int idU = leerEnteroValidado(Colores.CIAN + "  ID del usuario          : " + Colores.RESET);
                    biblioteca.realizarPrestamo(idL, idU);
                }
                case 2 -> {
                    System.out.println(Colores.CIAN_BRILLANTE + "\n  ── Libros prestados ──" + Colores.RESET);
                    biblioteca.mostrarLibrosPrestados();
                    System.out.println(Colores.CIAN_BRILLANTE + "\n  ── Usuarios registrados ──" + Colores.RESET);
                    biblioteca.mostrarUsuarios();
                    int idL = leerEnteroValidado(Colores.CIAN + "\n  ID del libro a devolver  : " + Colores.RESET);
                    int idU = leerEnteroValidado(Colores.CIAN + "  ID del usuario           : " + Colores.RESET);
                    biblioteca.realizarDevolucion(idL, idU);
                }
                case 0  -> {}
                default -> System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ Opción no válida.\n" + Colores.RESET);
            }
            if (op != 0) pausar();
        } while (op != 0);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENÚ 5 - CONSULTAS Y REPORTES
    // ══════════════════════════════════════════════════════════════════════════

    private static void menuConsultas() {
        int op;
        do {
            String C = Colores.RESET;
            System.out.println();
            Colores.linea("═", 50, Colores.AMARILLO_BRILLANTE);
            System.out.println(Colores.AMARILLO_BRILLANTE + "  ╔══════════════════════════════════════════╗" + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "  ║" + Colores.BLANCO_BRILLANTE
                    + "        🔍  CONSULTAS Y REPORTES  🔍        "
                    + Colores.AMARILLO_BRILLANTE + "║" + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "  ╚══════════════════════════════════════════╝" + C);
            Colores.linea("═", 50, Colores.AMARILLO_BRILLANTE);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   1. " + Colores.BLANCO + "✔  Ver libros disponibles"   + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   2. " + Colores.BLANCO + "✘  Ver libros prestados"     + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   3. " + Colores.BLANCO + "📖  Ver todos los libros"    + C);
            System.out.println(Colores.AMARILLO_BRILLANTE + "   4. " + Colores.BLANCO + "👤  Ver todos los usuarios"  + C);
            System.out.println(Colores.ROJO_BRILLANTE     + "   0. " + Colores.BLANCO + "↩  Volver al menú principal" + C);
            Colores.linea("─", 50, Colores.AMARILLO);

            op = leerEnteroValidado(Colores.AMARILLO_BRILLANTE + "  ➤  Opción: " + C);
            switch (op) {
                case 1 -> { System.out.println(); biblioteca.mostrarLibrosDisponibles(); }
                case 2 -> { System.out.println(); biblioteca.mostrarLibrosPrestados();   }
                case 3 -> { System.out.println(); biblioteca.mostrarTodosLosLibros();    }
                case 4 -> { System.out.println(); biblioteca.mostrarUsuarios();          }
                case 0  -> {}
                default -> System.out.println(Colores.ROJO_BRILLANTE + "\n  ✘ Opción no válida.\n" + Colores.RESET);
            }
            if (op != 0) pausar();
        } while (op != 0);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  DESPEDIDA
    // ══════════════════════════════════════════════════════════════════════════

    private static void despedida() {
        Colores.limpiarPantalla();
        String C = Colores.RESET;
        Colores.linea("★", 50, Colores.AMARILLO_BRILLANTE);
        System.out.println(Colores.AMARILLO_BRILLANTE + "\n  👋  ¡Hasta luego, Kenneth y equipo!" + C);
        System.out.println(Colores.CIAN    + "  💙  Gracias por usar el Sistema de Biblioteca." + C);
        System.out.println(Colores.MAGENTA + "  🏫  Instituto Nacional de Sonzacate\n" + C);
        Colores.linea("★", 50, Colores.AMARILLO_BRILLANTE);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  UTILIDADES
    // ══════════════════════════════════════════════════════════════════════════

    private static int leerEnteroValidado(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println(Colores.ROJO + "  ✘ Ingresa un número entero válido." + Colores.RESET);
            }
        }
    }

    private static void pausar() {
        System.out.print(Colores.BLANCO + "\n  Presiona " + Colores.AMARILLO_BRILLANTE
                + "[Enter]" + Colores.BLANCO + " para continuar..." + Colores.RESET);
        scanner.nextLine();
    }
}