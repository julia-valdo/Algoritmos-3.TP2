package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BoxCartaHandlerTres implements HandlerDeCarta{
    private Carta primeraCarta;
    private Carta segundaCarta;
    private Carta terceraCarta;
    private Jugador jugador;
    private TextoNotificable textoDeError;

    public BoxCartaHandlerTres (Carta primeraCarta, Carta segundaCarta , Jugador jugador,TextoNotificable textoDeError){
        this.primeraCarta = primeraCarta;
        this.segundaCarta = segundaCarta;
        this.textoDeError = textoDeError;
        this.jugador = jugador;
    }

    @Override
    public void asociarCarta(Carta carta) {
        this.terceraCarta = carta;
    }

    @Override
    public HandlerDeCarta getCopy() {
        return new BoxCartaHandlerTres(this.primeraCarta, this.segundaCarta, this.jugador ,this.textoDeError);
    }

    @Override
    public void desarmarHandler() {
        this.jugador = null;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.desarmarTextoDeError();
        this.terceraCarta.getBox().activarse();
        try{
            jugador.canjearCartas(primeraCarta, segundaCarta, terceraCarta);
            Stage stage = (Stage) (((Node)mouseEvent.getSource()).getScene().getWindow());
            stage.close();
            jugador.mostrarCartas();
        } catch (Exception exception){
            manejarErrorDeAtaque(exception);
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
