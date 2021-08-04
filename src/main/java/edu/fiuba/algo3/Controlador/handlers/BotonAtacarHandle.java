package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class BotonAtacarHandle implements HandlerDePais {
    private Jugador jugador;
    private Pais pais;
    private TextoNotificable textoDeError;

    public BotonAtacarHandle(Jugador jugador, TextoNotificable textoDeError){
        this.jugador = jugador;
        this.textoDeError = textoDeError;
    }

    @Override
    public void asociarPais(Pais unPais) {
        this.pais = unPais;
    }

    @Override
    public HandlerDePais getCopy() {
        return new BotonAtacarHandle(this.jugador, this.textoDeError);
    }

    @Override
    public void desarmarHandler() {
        this.jugador = null;
    }

    @Override
    public void setJugadorEnTurno(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.desarmarTextoDeError();
        this.pais.habilitarLimitrofes(new ConfirmacionAtaqueHandle(this.jugador, this.pais, this.textoDeError));
    }

    private void desarmarTextoDeError(){
        this.textoDeError.setText("");
    }

}
