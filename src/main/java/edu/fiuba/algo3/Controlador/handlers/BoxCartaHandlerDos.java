package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class BoxCartaHandlerDos implements HandlerDeCarta{
    private Carta primeraCarta;
    private Carta segundaCarta;
    private Jugador jugador;
    private TextoNotificable textoDeError;

    public BoxCartaHandlerDos (Carta primeraCarta, Jugador jugador , TextoNotificable textoDeError){
        this.primeraCarta = primeraCarta;
        this.jugador = jugador;
        this.textoDeError = textoDeError;
    }

    @Override
    public void asociarCarta(Carta carta) {
        this.segundaCarta = carta;
    }

    @Override
    public HandlerDeCarta getCopy() {
        return new BoxCartaHandlerDos(this.primeraCarta, this.jugador ,this.textoDeError);
    }

    @Override
    public void desarmarHandler() {
        this.jugador = null;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.desarmarTextoDeError();
        this.segundaCarta.getBox().activarse();
        try {
            this.jugador.elegirCarta(this.primeraCarta,this.segundaCarta, new BoxCartaHandlerTres(this.primeraCarta, this.segundaCarta, this.jugador, this.textoDeError));
        }catch(Exception error){

        }
    }

    private void desarmarTextoDeError(){
        this.textoDeError.setText("");
    }

    private void manejarErrorDeAtaque(Exception excepcion){
        this.textoDeError.setText("Carta Ya Activada");

    }

    private void prepararGrupoDeError(MouseEvent evento) {
        Group grupoDeEscena = (Group) ((Node) evento.getSource()).getScene().getRoot();
        if (this.textoDeError.noEstaAgregadoA(grupoDeEscena)) {
            this.textoDeError.agregarAGrupo(grupoDeEscena);
        }
    }

}
