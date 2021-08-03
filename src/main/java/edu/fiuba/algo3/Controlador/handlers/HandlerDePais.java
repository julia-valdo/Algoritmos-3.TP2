package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface HandlerDePais extends EventHandler<MouseEvent> {

    /*comentario para el commit*/
    void asociarPais(Pais unPais);

    HandlerDePais getCopy();

    void desarmarHandler();


    void setJugadorEnTurno(Jugador jugador);
}
