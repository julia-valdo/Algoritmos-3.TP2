package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.modelo.JuegoYJugador.Juego;
import edu.fiuba.algo3.vista.Elementos.Ficha;

import java.util.ArrayList;

public class Controlador {

    private static Juego teg;

    public static void setearJuego(int numeroJugadores){
        teg = new Juego(numeroJugadores);

    }

    public static void setearNombres(ArrayList<String> nombres){
        int numero = 1;
        for(String nombre: nombres){
            teg.setNombreJugadorNumero(numero, nombre);
            numero++;
        }
    }

    private static void setearFichas(ArrayList<Ficha> fichas){
            teg.setearFichas(fichas);
    }


    public static void empezarJuego(ArrayList<Ficha> fichas) {
        teg.iniciarJuego();
        setearFichas(fichas);
    }
}
