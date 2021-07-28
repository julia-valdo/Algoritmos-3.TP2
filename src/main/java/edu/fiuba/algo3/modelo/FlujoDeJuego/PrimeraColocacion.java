package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;

public class PrimeraColocacion implements FaseDeRonda{
    private final int fichasAAgregar = 5;

    @Override
    public void aplicarAccionesDeFase(Jugador jugador) {
            jugador.agregarFichas(this.fichasAAgregar);
    }

    @Override
    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion) {

        jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno());

        return true;
    }

    @Override
    public FaseDeRonda cambiarFase() {
        return null;
    }
}
