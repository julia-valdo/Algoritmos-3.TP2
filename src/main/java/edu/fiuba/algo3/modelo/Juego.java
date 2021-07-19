package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Juego {
    ArrayList<Jugador> jugadores;
    Parser parser;
    FaseDeRonda fase;

    public Juego(){
        ParserJson parser = new ParserJson();
        parser.parsearArchivo("Teg - Cartas.json");
        parser.parsearArchivo("Teg - Fronteras.json");
        this.parser = parser;
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
        repartirPaises();


    }

    private void crearJugadores(int cantidadDeJugadores){
        for(int i = 0; i < cantidadDeJugadores; i++) this.jugadores.add(new Jugador(i));
    }

    private void repartirPaises(){
        ArrayList<Pais> paises = new ArrayList<>(parser.getPaises());
        Collections.shuffle(paises);
        while(!paises.isEmpty()){
            for(Jugador jugador : jugadores){
                jugador.ocupa(paises.remove(0));
            }
        }
    }
}
