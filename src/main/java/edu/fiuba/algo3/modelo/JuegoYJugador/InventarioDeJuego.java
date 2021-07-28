package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Cartas.Mazo;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.modelo.Objetivos.Continente;

import java.util.ArrayList;

public class InventarioDeJuego {
    Mazo mazoDeCartas;
    ArrayList<Continente> continentes;

    public InventarioDeJuego(ArrayList<Carta> mazoDeCartas, ArrayList<Continente> continentes){
        this.mazoDeCartas = new Mazo(mazoDeCartas);
        this.continentes = continentes;
    }

    public int ejercitosPorContinentesConquistados(ArrayList<Pais>paisesOcupados){
        int ejercitosTotal = 0;
        for(Continente continente : continentes){
            if(continente.fueConquistado(paisesOcupados)) {
                ejercitosTotal += continente.getCantidadDeFichasPorContinente();
            }
        }
        return ejercitosTotal;
    }


    public void repartirCarta(Jugador jugador1) {
        this.mazoDeCartas.repartirCarta(jugador1);
    }
}
