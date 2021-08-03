package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.BarraMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class VentanaPrincipal extends Group {

    BarraMenu menu = new BarraMenu();

    public VentanaPrincipal() {
        super();
        this.setFondo();
    }

    public void setFondo() {

        BorderPane contenedor = new BorderPane();

        HBox mapa = new HBox();
        ImageView imageMapa = new ImageView();
        imageMapa.setImage(new Image("file:tableroTEG.png"));
        imageMapa.setFitHeight(600);
        mapa.getChildren().add(imageMapa);

        contenedor.setTop(menu);
        contenedor.setCenter(mapa);

        this.getChildren().add(contenedor);

        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:papel.jpg"));
        imagePanel.setFitHeight(600);
        imagePanel.setFitWidth(250);
        mapa.getChildren().add(imagePanel);
    }
}