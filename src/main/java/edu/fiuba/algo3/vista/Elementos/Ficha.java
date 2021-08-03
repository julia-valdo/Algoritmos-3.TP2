package edu.fiuba.algo3.vista.Elementos;

import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Botones.BotonDeFicha;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Ficha extends Circle {

    private Text texto;
    private TextoNotificable textoNotificable;

    public  Ficha(String color){
        super();
        this.setFill(Paint.valueOf(color));
        this.texto = new Text("10");
        this.texto.setFill(Paint.valueOf("#ffffff"));
        this.texto.setStyle("-fx-font-weight: bold");
        this.setRadius(12);
    }

    public void setPosicion(int posX, int posY){
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        this.texto.setTranslateX(posX - 6);
        this.texto.setTranslateY(posY + 4);
    }

    public void agregarseA(Group parent){

        parent.getChildren().add(this);
        parent.getChildren().add(texto);

    }

    public void setColor(String nuevoColor){
        this.setFill(Paint.valueOf(nuevoColor));
    }

    public void agregarNuevoHandler(HandlerDePais handler) {
        this.setOnMouseClicked(handler);
        this.texto.setOnMouseClicked(handler);
        this.setDisable(false);
        this.texto.setDisable(false);
    }

    public void notificar(String color, Integer fichasDisponibles) {
        this.setFill(Paint.valueOf(color));
        this.texto.setText(fichasDisponibles.toString());
        if(textoNotificable != null){
            textoNotificable.notificar(this.texto);
        }
    }

    public Text getCantidad() {
        return this.texto;
    }

    public void notificame(TextoNotificable textoNotificable) {
        this.textoNotificable = textoNotificable;
    }

    public void limpiarHandler() {
        if(this.getOnMouseClicked() != null) {
            HandlerDePais handler = (HandlerDePais) this.getOnMouseClicked();
            handler.desarmarHandler();
        }
    }

    public void copiarEn(Ficha unaFicha, Pais pais) {
        HandlerDePais handlerDelOtro = (HandlerDePais) unaFicha.getOnMouseClicked();
        HandlerDePais miHandlerNuevo = handlerDelOtro.getCopy();
        miHandlerNuevo.asociarPais(pais);
        this.agregarNuevoHandler(miHandlerNuevo);
    }
}
