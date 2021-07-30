package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;

public interface Habilitado {

    Habilitado pedirCarta(ManoDeCartas mano, InventarioDeJuego mazo);

    Habilitado ocupePais();
}
