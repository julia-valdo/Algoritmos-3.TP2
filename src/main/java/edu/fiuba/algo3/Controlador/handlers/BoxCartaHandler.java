package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJugador;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.InvalidClassException;
import java.util.ArrayList;

public class BoxCartaHandler implements HandlerDeCarta{
    private Carta primeraCarta;
    private Jugador jugador;
    private TextoNotificable textoDeError;

    public BoxCartaHandler (Jugador jugador, TextoNotificable textoDeError){
        this.textoDeError = textoDeError;
        this.jugador = jugador;
    }

    @Override
    public void asociarCarta(Carta carta) {
        this.primeraCarta = carta;
    }

    @Override
    public HandlerDeCarta getCopy() {
        return new BoxCartaHandler(this.jugador, this.textoDeError);
    }

    @Override
    public void desarmarHandler() {
        this.jugador = null;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.desarmarTextoDeError();
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            try {
                primeraCarta.getBox().activarse();
                this.jugador.elegirCarta(primeraCarta, new BoxCartaHandlerDos(this.primeraCarta, this.jugador, this.textoDeError));
            } catch (Exception error) {
            }
        } else {
            try{
                this.jugador.canjearCarta(primeraCarta);
                Stage stage = (Stage) (((Node)mouseEvent.getSource()).getScene().getWindow());
                stage.close();
                jugador.mostrarCartas();
            }catch (Exception error) {

            }
        }
    }

    private void desarmarTextoDeError(){
        this.textoDeError.setText("");
    }
}
