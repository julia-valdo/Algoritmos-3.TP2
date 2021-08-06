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

        BorderPane contenedor = new BorderPane();
        contenedor.setTop(new BarraMenu());

        HBox mapa = new HBox();
        ImageView imageMapa = new ImageView();
        imageMapa.setImage(new Image("file:conurbano.jpg"));
        imageMapa.setFitHeight(600);
        imageMapa.setFitWidth(870);
        mapa.getChildren().add(imageMapa);
        this.getChildren().add(mapa);

        contenedor.setCenter(mapa);
        this.getChildren().add(contenedor);

        HBox panel = new HBox();
        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:L-Gante.jpg"));
        imagePanel.setFitHeight(600);
        imagePanel.setFitWidth(300);
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
