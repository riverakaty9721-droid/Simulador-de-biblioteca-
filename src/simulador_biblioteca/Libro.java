package simulador_biblioteca;


public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(int id, String titulo, String autor) {
        this.id       = id;
        this.titulo   = titulo;
        this.autor    = autor;
        this.disponible = true;
    }

    public int    getId()        { return id; }
    public String getTitulo()    { return titulo; }
    public String getAutor()     { return autor; }
    public boolean isDisponible(){ return disponible; }
    public void setDisponible(boolean d){ this.disponible = d; }

    @Override
    public String toString() {
        String C = Colores.RESET;
        String estado = disponible
            ? Colores.VERDE + "✔ DISPONIBLE" + C
            : Colores.ROJO  + "✘ PRESTADO"   + C;
        return Colores.CIAN + "[ID: " + id + "]" + C
             + " " + Colores.AMARILLO_BRILLANTE + titulo + C
             + " - Autor: " + Colores.BLANCO + autor + C
             + " | " + estado;
    }
}
