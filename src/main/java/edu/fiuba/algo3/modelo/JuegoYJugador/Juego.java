package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.FlujoDeJuego.FaseColocarEjercitos;
import edu.fiuba.algo3.modelo.FlujoDeJuego.FaseDeRonda;
import edu.fiuba.algo3.modelo.FlujoDeJuego.PrimeraColocacion;
import edu.fiuba.algo3.modelo.Parser.Parser;

import java.util.*;

public class Juego {
    private Integer turnoActual;
    private HashMap<Integer, Jugador> turnoJugadores;
    private FaseDeRonda fase;
    private Parser parser;

    public Juego(int cantidadDeJugadores){
        parser = new Parser();
        this.turnoActual = 1;
        this.turnoJugadores = new HashMap<>();
        this.fase = new PrimeraColocacion();
        this.crearJugadores(cantidadDeJugadores);
    }

    public void iniciarJuego(){
        parser.parsearArchivo("Teg - Cartas.json");
        parser.parsearArchivo("Teg - Fronteras.json");
        parser.parsearArchivo("Teg - Objetivos.json");
        parser.construirObjetos();
        this.repartirPaises();
    }

    private void crearJugadores(int cantidadDeJugadores){
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for(int i = 0; i < cantidadDeJugadores; i++) jugadores.add(new Jugador(i));
        this.establecerTurnos(jugadores);
    }

    private void establecerTurnos(ArrayList<Jugador> jugadores) {
        int counter = 1;
        Collections.shuffle(jugadores);
        for (Jugador jugador : jugadores) {
            this.turnoJugadores.put(counter, jugador);
            counter += 1;
        }
    }

    public ArrayList<Integer> obtenerOrder() {
        ArrayList<Integer> numerosDeJugadores = new ArrayList<>();
        Collection<Jugador> jugadores = this.turnoJugadores.values();
        for(Jugador jugador : jugadores){
            numerosDeJugadores.add(jugador.getNumeroJugador());
        }

        return numerosDeJugadores;

    }

    public Jugador obtenerSiguiente() {
        Jugador siguiente =  this.turnoJugadores.get(this.turnoActual);
        this.fase.aplicarAccionesDeFase(siguiente);
        this.avanzarTurno();
        return siguiente;
    }

    public void seleccionDeJugador(Jugador jugador, SeleccionJugador seleccion){
        this.fase.accionJugador(jugador, new InventarioDeJuego(new ArrayList<>(), new ArrayList<>()), seleccion);
    }

    private void avanzarTurno() {
        if(this.turnoActual == this.turnoJugadores.size()){
            this.turnoActual = 1;
        }
        else {
            this.turnoActual++;
        }
    }


    private void repartirPaises(){
        List<Pais> paises = new ArrayList<>(this.parser.getPaises().values());
        Collections.shuffle(paises);
        for(Pais pais: paises){
         Jugador actual = this.obtenerSiguiente();
         actual.agregarFichas(1);
         actual.ocupa(pais);
        }
    }
}
