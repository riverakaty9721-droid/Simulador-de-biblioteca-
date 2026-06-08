package simulador_biblioteca;

public class Docente extends Usuario {
    
    public Docente(int id, String nombre) {
        // Llama al constructor del Padre (Usuario)
        // Le pasamos el id, el nombre, y le fijamos un límite distinto: 5 libros
        super(id, nombre, 5); 
    }
}