package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public interface HandlerDeCarta extends EventHandler<MouseEvent> {
    void asociarCarta(Carta unaCarta);

    HandlerDeCarta getCopy();

    void desarmarHandler();

}
