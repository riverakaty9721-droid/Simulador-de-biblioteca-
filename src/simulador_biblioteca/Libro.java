package simulador_biblioteca;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String categoria; // <-- NUEVO ATRIBUTO
    private boolean disponible;

    public Libro(int id, String titulo, String autor, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; } // <-- NUEVO GETTER
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    @Override
    public String toString() {
        String estado = disponible ? (Colores.VERDE_BRILLANTE + "✔ DISPONIBLE") : (Colores.ROJO_BRILLANTE + "✖ PRESTADO  ");
        
        // Formateamos cómo se verá cada libro en la lista
        return Colores.CIAN + "[ID: " + String.format("%02d", id) + "] " 
               + Colores.AMARILLO_BRILLANTE + titulo 
               + Colores.RESET + " - " + autor 
               + Colores.MAGENTA + " (" + categoria + ") " 
               + estado + Colores.RESET;
    }
}