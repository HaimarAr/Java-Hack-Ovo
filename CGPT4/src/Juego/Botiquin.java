package Juego;

public class Botiquin implements Elemento {
    @Override
    public void usar(Personaje personaje) {
        // Lógica específica para usar el botiquín y afectar al personaje
    	  System.out.println(personaje.getNombre() + " ha usado un botiquín. ¡Recuperación de vida!");
          personaje.setPuntosVida(Math.min(personaje.getPuntosVida() + 20, 100));
    }
}