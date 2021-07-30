package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;

public class EstaHabilitado implements Habilitado{
    @Override
    public Habilitado pedirCarta(ManoDeCartas mano, InventarioDeJuego inventario) {
        inventario.repartirCarta(mano);

        return new NoEstaHabilitado();
    }

    @Override
    public Habilitado ocupePais() {
        return this;
    }
}
