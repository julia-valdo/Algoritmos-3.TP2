package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Juego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controlador {

    private static Juego teg;


    public static void setearJuego(int numeroJugadores){
        teg = new Juego(numeroJugadores);
    }

    public static void setearNombres(ArrayList<TextField> nombres){

        for(TextField nombre: nombres){
            teg.setNombreJugador(nombre);

        }
    }

    private static void setearFichas(ArrayList<Ficha> fichas){
            teg.setearFichas(fichas);
    }


    public static void empezarJuego(ArrayList<Ficha> fichas) {
        teg.iniciarJuego();
        setearFichas(fichas);
    }


    public static Scene pedirMenuSiguiente() {
        return teg.prepararMenuSiguiente();
    }

    public static Scene obtenerEscenaObjetivos() {
        return teg.mostrarObjetivos();
    }

    public static void habilitarPaises(Pais pais, HandlerDePais confirmacionAtaqueHandle) {
        teg.habilitarPaisesParaAtaque(pais, confirmacionAtaqueHandle);
    }

    public static void reestablecerPaises(Jugador jugador, HandlerDePais handler){
        teg.reestablecerPaises(jugador, handler);
    }
}
