package edu.fiuba.algo3.vista.ventana;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VentanaPrincipal extends BorderPane {

    public VentanaPrincipal(Stage stage) {
        this.setFondo(stage);
    }

    public void setFondo(Stage stage) {

        HBox mapa = new HBox();
        this.setCenter(mapa);
        ImageView imageMapa = new ImageView();
        imageMapa.setImage(new Image("file:tableroTEG.png"));
        imageMapa.setFitHeight(600);
        mapa.getChildren().add(imageMapa);

        HBox panel = new HBox();
        this.setRight(panel);
        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:papel.jpg"));
        imagePanel.setFitHeight(600);
        imagePanel.setFitWidth(250);
        mapa.getChildren().add(imagePanel);
    }



}
