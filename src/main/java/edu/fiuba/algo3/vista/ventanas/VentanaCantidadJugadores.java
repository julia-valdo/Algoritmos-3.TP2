package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Botones.BotonDeSeleccion;
import edu.fiuba.algo3.vista.Elementos.BarraMenu;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class VentanaCantidadJugadores extends StackPane {

    public VentanaCantidadJugadores() {
        super();
        this.setFondo();
    }

    public void setFondo() {

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
        info.setStyle("-fx-font-weight: bold");
        info.setTranslateX(905);
        info.setTranslateY(280);
        ArrayList<Node> nodos = new ArrayList<>();
        nodos.add(info);
        for(int i = 2; i < 7; i++){
            nodos.add(new BotonDeSeleccion(i));
        }

        panel.getChildren().addAll(nodos);

    }

}
