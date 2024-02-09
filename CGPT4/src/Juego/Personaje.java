package Juego;

import java.util.Arrays;
import java.util.Objects;

public class Personaje {
    private String nombre;
    private int puntosVida;
    private int puntosConseguidos;
    private Elemento[] mochila;
    private int numElementosMochila;
    private int puntosFuerza;

    public Personaje(String nombre) {
        this.puntosVida = 100;
        this.puntosConseguidos = 0;
        this.mochila = new Elemento[10];
        this.numElementosMochila = 0;
        this.puntosFuerza = 1;
        this.nombre = nombre;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getPuntosConseguidos() {
        return puntosConseguidos;
    }

    public int getNumElementosMochila() {
        return numElementosMochila;
    }

    public int getPuntosFuerza() {
        return puntosFuerza;
    }

    public Elemento[] getMochila() {
        return mochila;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setPuntosConseguidos(int puntosConseguidos) {
        this.puntosConseguidos = puntosConseguidos;
    }

    public void setPuntosFuerza(int puntosFuerza) {
        if (puntosFuerza >= 1 && puntosFuerza <= 10) {
            this.puntosFuerza = puntosFuerza;
        } else {
            System.out.println("Los puntos de fuerza deben estar entre 1 y 10.");
        }
    }

    public void setMochila(Elemento[] mochila) {
        this.mochila = mochila;
    }

    public void setNumElementosMochila(int numElementosMochila) {
        this.numElementosMochila = numElementosMochila;
    }

    // Otros métodos
    public int agregarElementoMochila(Elemento elemento) {
        if (numElementosMochila < 10) {
            mochila[numElementosMochila++] = elemento;
            System.out.println("Se ha agregado un elemento a la mochila de " + nombre);
        } else {
            System.out.println("YA NO PUEDES CONSEGUIR MÁS ELEMENTOS PUES TU MOCHILA ESTÁ COMPLETA");
        }
        return numElementosMochila;
    }

    public int recibirGolpe(int puntosGolpe) {
        System.out.println(nombre + " ha recibido un golpe de " + puntosGolpe + " puntos.");
        puntosVida = Math.max(puntosVida - puntosGolpe, 0);
        System.out.println("Puntos de vida restantes de " + nombre + ": " + puntosVida);
        return puntosVida;
    }

    public int usarBotiquin() {
        for (int i = 0; i < numElementosMochila; i++) {
            if (mochila[i] instanceof Botiquin) {
                mochila[i] = null;
                System.out.println(nombre + " ha usado un botiquín.");
                setPuntosVida(Math.min(getPuntosVida() + 20, 100));
                return getPuntosVida();
            }
        }
        System.out.println("LO SIENTO, PERO NO TIENES NINGUNA POCIÓN DE BOTIQUÍN");
        return getPuntosVida();
    }

    // Métodos equals, hashCode y toString
    // ...
}
