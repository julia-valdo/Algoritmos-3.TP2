package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;

public interface FaseDeRonda {

    void aplicarAccionesDeFase(Jugador jugador);

    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion);

    public FaseDeRonda cambiarFase();
}
