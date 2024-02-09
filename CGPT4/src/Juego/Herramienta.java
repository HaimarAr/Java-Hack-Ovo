package Juego;

public class Herramienta implements Elemento {
    private String nombre;

    public Herramienta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void usar(Personaje personaje) {
        // Lógica para usar la herramienta y afectar al personaje
    }
}
