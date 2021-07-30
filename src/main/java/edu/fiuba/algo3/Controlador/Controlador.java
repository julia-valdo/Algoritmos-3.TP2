package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.modelo.JuegoYJugador.Juego;

public class Controlador {

    private static Juego teg;

    public static void setearJuego(int numeroJugadores){
        teg = new Juego(numeroJugadores);
    }

}
