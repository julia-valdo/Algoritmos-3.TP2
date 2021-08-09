package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
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
            jugador.habilitarCartas(new BoxCartaHandler(this.jugador,this.textoDeError));
            Stage stage = (Stage) (((Node)mouseEvent.getSource()).getScene().getWindow());
            stage.close();
            jugador.mostrarCartas();
        } catch (Exception exception){
            this.textoDeError.setText(exception.getMessage());
            mostrarError();
        }
    }

    private void desarmarTextoDeError(){
        this.textoDeError.setText("");
    }

    private void mostrarError(){
        VentanaDePapel ventana = new VentanaDePapel(textoDeError);
        ventana.prepararFondo(200,500);

        Scene scena = new Scene(ventana);
        Stage popUpDeCarta = new Stage();


        popUpDeCarta.setScene(scena);
        popUpDeCarta.show();
    }
}
