package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;

public class FaseSegundaColocacion implements FaseDeRonda {
    @Override
    public void aplicarAccionesDeFase(Jugador jugador, InventarioDeJuego inventario) {
        jugador.agregarFichas(3);
    }

    @Override
    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion) {
        jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno());

        return true;
    }

    @Override
    public FaseDeRonda cambiarFase() {
        return new FaseAtacar();
    }
}
