package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;

public interface FaseDeRonda {

    void aplicarAccionesDeFase(Jugador jugador, InventarioDeJuego inventario);

    boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion);

    FaseDeRonda cambiarFase(Jugador siguiente);

    VentanaMenu prepararMenu();

    public boolean puedoPasar();

}
