package simulador_biblioteca;

public class Colores {
    // Reset
    public static final String RESET   = "\033[0m";

    // Colores normales
    public static final String NEGRO   = "\033[0;30m";
    public static final String ROJO    = "\033[0;31m";
    public static final String VERDE   = "\033[0;32m";
    public static final String AMARILLO= "\033[0;33m";
    public static final String AZUL    = "\033[0;34m";
    public static final String MAGENTA = "\033[0;35m";
    public static final String CIAN    = "\033[0;36m";
    public static final String BLANCO  = "\033[0;37m";

    // Colores brillantes
    public static final String ROJO_BRILLANTE    = "\033[1;31m";
    public static final String VERDE_BRILLANTE   = "\033[1;32m";
    public static final String AMARILLO_BRILLANTE= "\033[1;33m";
    public static final String AZUL_BRILLANTE    = "\033[1;34m";
    public static final String MAGENTA_BRILLANTE = "\033[1;35m";
    public static final String CIAN_BRILLANTE    = "\033[1;36m";
    public static final String BLANCO_BRILLANTE  = "\033[1;37m";

    // Fondos
    public static final String FONDO_AZUL    = "\033[44m";
    public static final String FONDO_VERDE   = "\033[42m";
    public static final String FONDO_ROJO    = "\033[41m";
    public static final String FONDO_MAGENTA = "\033[45m";
    public static final String FONDO_CIAN    = "\033[46m";
    public static final String FONDO_NEGRO   = "\033[40m";

    // Utilidades
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String colorear(String texto, String color) {
        return color + texto + RESET;
    }

    /** Imprime una línea decorativa */
    public static void linea(String caracter, int largo, String color) {
        System.out.println(color + caracter.repeat(largo) + RESET);
    }
}
