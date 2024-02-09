package Juego;


public class Juego {
	    public static void main(String[] args) {
	        Personaje jugador1 = new Personaje("Jugador 1");
	        Personaje jugador2 = new Personaje("Jugador 2");

	        jugador1.agregarElementoMochila(new Pocion("Poción de curación"));
	        jugador1.agregarElementoMochila(new Herramienta("Espada afilada"));

	        jugador2.agregarElementoMochila(new Botiquin());
	        jugador2.agregarElementoMochila(new Herramienta("Martillo contundente"));

	        jugador1.setPuntosFuerza(5);
	        jugador2.setPuntosFuerza(3);

	        Personaje ganador = Batalla.simularBatalla(jugador1, jugador2);

	        if (ganador != null) {
	            System.out.println("El ganador de la batalla es: " + ganador.getNombre());
	        } else {
	            System.out.println("La batalla terminó en empate.");
	        }
	    }
	}