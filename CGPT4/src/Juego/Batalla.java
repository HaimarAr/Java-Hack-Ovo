package Juego;

import java.util.Random;

public class Batalla {
    public static Personaje simularBatalla(Personaje personaje1, Personaje personaje2) {
        System.out.println("Comienza la batalla entre " + personaje1.getNombre() + " y " + personaje2.getNombre() + "!");
        Random random = new Random();

        while (personaje1.getPuntosVida() > 0 && personaje2.getPuntosVida() > 0) {
            int golpe1 = random.nextInt(3) * personaje1.getPuntosFuerza();
            int golpe2 = random.nextInt(3) * personaje2.getPuntosFuerza();

            personaje2.recibirGolpe(golpe1);
            personaje1.recibirGolpe(golpe2);

            if (personaje1.getPuntosVida() < 30) {
                personaje1.usarBotiquin();
            }

            if (personaje2.getPuntosVida() < 30) {
                personaje2.usarBotiquin();
            }

            System.out.println("Puntos de vida de " + personaje1.getNombre() + ": " + personaje1.getPuntosVida());
            System.out.println("Puntos de vida de " + personaje2.getNombre() + ": " + personaje2.getPuntosVida());
            System.out.println();
        }

        if (personaje1.getPuntosVida() <= 0 && personaje2.getPuntosVida() <= 0) {
            System.out.println("La batalla terminó en empate.");
            return null;
        } else if (personaje1.getPuntosVida() <= 0) {
            System.out.println(personaje1.getNombre() + " ha perdido la batalla.");
            return personaje2;
        } else {
            System.out.println(personaje2.getNombre() + " ha perdido la batalla.");
            return personaje1;
        }
    }
}