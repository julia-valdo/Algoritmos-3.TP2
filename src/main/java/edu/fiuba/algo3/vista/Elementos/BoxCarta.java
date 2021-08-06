package edu.fiuba.algo3.vista.Elementos;

import edu.fiuba.algo3.Controlador.handlers.HandlerDeCarta;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BoxCarta extends Rectangle {
    private Carta carta;
    private Text textoSimbolo;
    private Text textoPais;
    private TextoNotificable textoNotificable;

    public BoxCarta(Carta carta){
        super();
        this.carta = carta;
        this.setHeight(80);
        this.setWidth(90);
        this.textoSimbolo = new Text(carta.getSimbolo());
        this.textoSimbolo.setFill(Paint.valueOf("#ffffff"));
        this.textoSimbolo.setStyle("-fx-font-weight: bold");
        this.textoPais = new Text(carta.getPais().getNombreDelPais());
        this.textoPais.setFill(Paint.valueOf("#ffffff"));
        this.textoPais.setStyle("-fx-font-weight: bold");
        this.setFill(Paint.valueOf("#000000"));
    }

    public void setPosicion(int posX, int posY){
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        this.textoSimbolo.setTranslateX(posX + 15);
        this.textoSimbolo.setTranslateY(posY + 15);
        this.textoPais.setTranslateX(posX + 15);
        this.textoPais.setTranslateY(posY + 35);
    }

    public void agregarseA(Group parent){

        parent.getChildren().add(this);
        parent.getChildren().add(textoSimbolo);
        parent.getChildren().add(textoPais);

    }


    public void agregarNuevoHandler(HandlerDeCarta handler) {
        this.setOnMouseClicked(handler);
        this.textoSimbolo.setOnMouseClicked(handler);
        this.setDisable(false);
        this.textoSimbolo.setDisable(false);
    }


    public void limpiarHandler() {
        if(this.getOnMouseClicked() != null) {
            HandlerDeCarta handler = (HandlerDeCarta) this.getOnMouseClicked();
            handler.desarmarHandler();
        }
        this.desactivarse();
    }

    public void copiarEn(BoxCarta unaCarta, Carta otraCarta) {
        HandlerDeCarta handlerDelOtro = (HandlerDeCarta) unaCarta.getOnMouseClicked();
        HandlerDeCarta miHandlerNuevo = handlerDelOtro.getCopy();
        miHandlerNuevo.asociarCarta(otraCarta);
        this.agregarNuevoHandler(miHandlerNuevo);
    }

    public void activarse(){
        this.setFill(Paint.valueOf("#008000"));
        this.setDisable(true);
        this.textoSimbolo.setDisable(true);
        this.textoPais.setDisable(true);
    }

    private void desactivarse(){
        this.setFill(Paint.valueOf("#000000"));
        this.setDisable(false);
        this.textoSimbolo.setDisable(false);
        this.textoPais.setDisable(false);
    }

}
