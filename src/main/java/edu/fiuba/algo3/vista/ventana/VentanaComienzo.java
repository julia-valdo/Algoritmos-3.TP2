package edu.fiuba.algo3.vista.ventana;

import edu.fiuba.algo3.vista.handler.BotonComienzoHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaComienzo extends HBox {

    Stage stage;

    public VentanaComienzo(Stage stage, Scene next) {

        super();
        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:tableroTEG.png");
        BackgroundImage fondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0,1.0,true,true,false,false));
        this.setBackground(new Background((fondo)));

        Button botonComienzo = new Button("Comenzar Juego");
        BotonComienzoHandler botonComienzoHandler = new BotonComienzoHandler(stage, next);
        botonComienzo.setOnAction(botonComienzoHandler);

        this.getChildren().addAll(botonComienzo);
    }

}
