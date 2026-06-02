package simulador_biblioteca;

public class Libro {

    // ===== ATRIBUTOS =====
    private int id;
    private String titulo;
    private String autor;
    private boolean disponible;

    // ===== CONSTRUCTOR =====
    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true; // Por defecto, el libro está disponible
    }

    // ===== GETTERS Y SETTERS =====
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // ===== MÉTODO toString =====
    @Override
    public String toString() {
        String estado = disponible ? "DISPONIBLE" : "PRESTADO";
        return "[ID: " + id + "] " + titulo + " - Autor: " + autor + " | Estado: " + estado;
    }
}
