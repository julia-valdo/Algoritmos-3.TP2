package edu.fiuba.algo3.vista.ventanas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaPrincipal extends StackPane {

    Stage stage;

    public VentanaPrincipal(Stage stage) {
        super();
        this.stage = stage;
        this.setFondo(stage);
    }

    public void setFondo(Stage stage) {

        HBox mapa = new HBox();
        ImageView imageMapa = new ImageView();
        imageMapa.setImage(new Image("file:tableroTEG.png"));
        imageMapa.setFitHeight(600);
        mapa.getChildren().add(imageMapa);
        this.getChildren().add(mapa);

        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:papel.jpg"));
        imagePanel.setFitHeight(600);
        imagePanel.setFitWidth(250);
        mapa.getChildren().add(imagePanel);


    }

}