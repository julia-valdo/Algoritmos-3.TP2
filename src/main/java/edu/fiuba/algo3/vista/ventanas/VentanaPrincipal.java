package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.BarraMenu;
import javafx.scene.Group;
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
        imageMapa.setImage(new Image("file:conurbano.jpg"));
        imageMapa.setFitHeight(600);
        imageMapa.setFitWidth(870);
        mapa.getChildren().add(imageMapa);

        contenedor.setTop(menu);
        contenedor.setCenter(mapa);

        this.getChildren().add(contenedor);

        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:L-Gante.jpg"));
        imagePanel.setFitHeight(600);
        imagePanel.setFitWidth(300);
        mapa.getChildren().add(imagePanel);
    }
}