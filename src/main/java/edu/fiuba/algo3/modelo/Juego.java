package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Juego {
    ArrayList<Jugador> jugadores;
    FaseDeRonda fase;
    Parser parser;

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
