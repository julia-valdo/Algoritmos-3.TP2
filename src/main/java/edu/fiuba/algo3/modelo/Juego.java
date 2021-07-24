package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Juego {
    ArrayList<Jugador> jugadores;
    FaseDeRonda fase;

    public Juego(){
        ParserJson parser = new ParserJson();
        parser.parsearArchivo("Teg - Cartas.json");
        parser.parsearArchivo("Teg - Fronteras.json");
        this.fase = new FaseColocarEjercitos();
        iniciarJuego();
    }

    public void iniciarJuego(){
        Scanner numeroDeJugadores = new Scanner(System.in);
        System.out.println("Numero de jugadores?: ");
        while(!numeroDeJugadores.hasNextInt()) {
            System.out.println("No es un numero valido.");
            numeroDeJugadores.next();
        }
        int cantidadDeJugadores = numeroDeJugadores.nextInt();

        crearJugadores(cantidadDeJugadores);


    }

    private void crearJugadores(int cantidadDeJugadores){
        for(int i = 0; i < cantidadDeJugadores; i++) this.jugadores.add(new Jugador(i));
    }

}
