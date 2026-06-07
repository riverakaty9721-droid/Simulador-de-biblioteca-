package simulador_biblioteca;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class MusicaFondo {

    private String rutaArchivo;
    private Clip   clip;
    private boolean activa = false;

    public MusicaFondo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void iniciar() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println(Colores.AMARILLO
                    + "  ♪ Archivo de música no encontrado: " + rutaArchivo
                    + " (el sistema funciona sin música)" + Colores.RESET);
            return;
        }
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            activa = true;
            System.out.println(Colores.VERDE + "  ♪ Música de fondo activada." + Colores.RESET);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(Colores.AMARILLO
                    + "  ♪ No se pudo cargar la música: " + e.getMessage() + Colores.RESET);
        }
    }

    public void detener() {
        if (clip != null && activa) {
            clip.stop();
            clip.close();
            activa = false;
        }
    }

    public boolean estaActiva() { return activa; }
}