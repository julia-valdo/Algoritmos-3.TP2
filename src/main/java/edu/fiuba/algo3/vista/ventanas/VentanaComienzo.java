package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.handlers.BotonComienzoHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaComienzo extends VBox {

    Stage stage;

    public VentanaComienzo(Stage stage, Scene next) {

        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(25));

        Button botonComienzo = new Button("Comenzar Juego");
        BotonComienzoHandler botonComienzoHandler = new BotonComienzoHandler(stage, next);
        botonComienzo.setOnAction(botonComienzoHandler);

        this.getChildren().addAll(botonComienzo);
    }

}
