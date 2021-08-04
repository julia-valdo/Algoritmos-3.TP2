package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.input.MouseEvent;

public class EsePaisNoEsTuyoHandler implements HandlerDePais{

    TextoNotificable textoDeError;

    public EsePaisNoEsTuyoHandler(TextoNotificable textoDeError){
        this.textoDeError = textoDeError;
    }

    @Override
    public void asociarPais(Pais unPais) {
        //No hace nada
    }

    @Override
    public HandlerDePais getCopy() {
        return new EsePaisNoEsTuyoHandler(this.textoDeError);
    }

    @Override
    public void desarmarHandler() {
        //no hace nada
    }

    @Override
    public void setJugadorEnTurno(Jugador jugador) {
        //no hace nada
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.setTexto();
    }


    private void setTexto(){
        this.textoDeError.setText("Ese pais no es tuyo");
    }

}

