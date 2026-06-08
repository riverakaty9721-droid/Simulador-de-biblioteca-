package simulador_biblioteca;

public class Estudiante extends Usuario {
    
    public Estudiante(int id, String nombre) {
        // Llama al constructor del Padre (Usuario)
        // Le pasamos el id, el nombre, y le fijamos el límite máximo de 3 libros
        super(id, nombre, 3); 
    }
}