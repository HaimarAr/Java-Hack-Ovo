package Juego;

public class Pocion implements Elemento {
    private String nombre;

    public Pocion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void usar(Personaje personaje) {
        // Lógica para usar la poción y afectar al personaje
    	 System.out.println(personaje.getNombre() + " ha usado una poción. ¡Puntos de vida aumentados!");
         personaje.setPuntosVida(Math.min(personaje.getPuntosVida() + 10, 100));
    }
}