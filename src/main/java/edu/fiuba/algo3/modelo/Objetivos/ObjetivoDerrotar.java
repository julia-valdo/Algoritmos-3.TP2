package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;

import java.util.ArrayList;

public class ObjetivoDerrotar implements Objetivo {
    Jugador jugador;
    int numeroDeJugador;
    public ObjetivoDerrotar(Jugador jugador){
        this.jugador = jugador;
    }

    public ObjetivoDerrotar(int jugador){
        this.numeroDeJugador = jugador;
    }

    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        return jugador.fueDerrotado();
    }
}
