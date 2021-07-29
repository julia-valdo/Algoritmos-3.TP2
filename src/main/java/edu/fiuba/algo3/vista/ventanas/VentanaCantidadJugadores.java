package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.handlers.BotonAceptarHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaCantidadJugadores extends StackPane {

    Stage stage;

    public VentanaCantidadJugadores(Stage stage, Scene next) {
        super();
        this.stage = stage;
        this.setFondo(stage, next);
    }

    public void setFondo(Stage stage, Scene next) {
        BorderPane border = new BorderPane();
        HBox mapa = new HBox();
        border.setCenter(mapa);
        ImageView imageMapa = new ImageView();
        imageMapa.setImage(new Image("file:tableroTEG.png"));
        imageMapa.setFitHeight(600);
        mapa.getChildren().add(imageMapa);
        this.getChildren().add(mapa);

        HBox panel = new HBox();
        border.setRight(panel);
        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:papel.jpg"));
        imagePanel.setFitHeight(600);
        imagePanel.setFitWidth(250);
        mapa.getChildren().add(imagePanel);
        this.getChildren().add(panel);

        Label info = new Label();
        info.setText("Cantidad de jugadores:");
        info.setTranslateX(785);
        info.setTranslateY(250);

        Label respuesta = new Label();

        TextField campoDeTexto = new TextField();
        campoDeTexto.setTranslateX(925);
        campoDeTexto.setTranslateY(300);

        Button boton = new Button("Aceptar");
        boton.setTranslateX(700);
        boton.setTranslateY(350);
        BotonAceptarHandler botonAceptarHandler = new BotonAceptarHandler(campoDeTexto, respuesta, stage, next);
        boton.setOnAction(botonAceptarHandler);

        panel.getChildren().add(campoDeTexto);
        panel.getChildren().add(info);
        panel.getChildren().add(boton);
    }

}
