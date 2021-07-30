package edu.fiuba.algo3.vista.Botones;

import edu.fiuba.algo3.Controlador.handlers.BotonComenzarJuegoHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonComenzar extends Button {

    public BotonComenzar(){
        super();
        this.colocarBoton();
        this.colocarTexto();
        this.addEventHandler(ActionEvent.ACTION, new BotonComenzarJuegoHandler());

    }

    private void colocarTexto() {
        this.setText("Comenzar juego");
        this.setStyle("-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000");
    }

    private void colocarBoton() {
        this.setTranslateX(915);
        this.setTranslateY(530);
    }
}
