package edu.fiuba.algo3.vista.Botones;

import edu.fiuba.algo3.Controlador.handlers.BotonComienzoHandler;
import javafx.scene.control.Button;

public class BotonComienzo extends Button {


    public BotonComienzo(){
        super("Comenzar Juego");
        BotonComienzoHandler botonComienzoHandler = new BotonComienzoHandler();
        this.setOnAction(botonComienzoHandler);
        this.setEstilo();
        this.setPosicion();
    }


    private void setEstilo(){
        this.setStyle("-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000");
    }

    private void setPosicion(){
        this.setTranslateX(912);
        this.setTranslateY(300);
    }
}
