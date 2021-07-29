package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.handlers.BotonComienzoHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaComienzo extends StackPane {

    private Stage stage;

    public VentanaComienzo(Stage stage, Scene next) {

        super();
        this.stage = stage;
        this.prepararImagen();
        this.prepararBotonInicio(stage, next);

    }


    private void prepararImagen(){

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(25));
        ImageView imageMapa = new ImageView();
        imageMapa.setImage(new Image("file:tableroTEG.png"));
        imageMapa.setFitHeight(600);
        this.getChildren().addAll(imageMapa);

    }

    private void prepararBotonInicio(Stage stage, Scene proxima){
        Button botonComienzo = new Button("Comenzar Juego");
        BotonComienzoHandler botonComienzoHandler = new BotonComienzoHandler(stage, proxima);
        botonComienzo.setOnAction(botonComienzoHandler);
        this.getChildren().addAll(botonComienzo);
    }

}
