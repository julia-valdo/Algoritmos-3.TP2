package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoDerrotar implements Objetivo{
    Jugador jugador;

    public ObjetivoDerrotar(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        return jugador.fueDerrotado();
    }
}
