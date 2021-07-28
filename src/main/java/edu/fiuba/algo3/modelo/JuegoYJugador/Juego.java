package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.modelo.FlujoDeJuego.FaseColocarEjercitos;
import edu.fiuba.algo3.modelo.FlujoDeJuego.FaseDeRonda;
import edu.fiuba.algo3.modelo.Parser.Parser;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private FaseDeRonda fase;
    private Parser parser;

    public Juego(){
        parser = new Parser();
        this.fase = new FaseColocarEjercitos();
    }

    public void iniciarJuego(){
        parser.parsearArchivo("Teg - Cartas.json");
        parser.parsearArchivo("Teg - Fronteras.json");
        parser.parsearArchivo("Teg - Objetivos.json");
        parser.construirObjetos();
    }

    private void crearJugadores(int cantidadDeJugadores){
        for(int i = 0; i < cantidadDeJugadores; i++) this.jugadores.add(new Jugador(i));
    }

}
