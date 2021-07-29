package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;

public class NoEstaHabilitado implements Habilitado{
    @Override
    public Habilitado pedirCarta(ManoDeCartas mano, InventarioDeJuego inventario) {
        return this;
    }

    @Override
    public Habilitado ocupePais() {
        return new EstaHabilitado();
    }
}
