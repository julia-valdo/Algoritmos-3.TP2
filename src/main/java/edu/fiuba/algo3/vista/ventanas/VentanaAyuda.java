package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.TextoAyuda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VentanaAyuda extends StackPane {

    public VentanaAyuda() {
        ImageView imagen = new ImageView("file:papel.jpg");
        imagen.setFitHeight(600);
        imagen.setFitWidth(800);
        imagen.fitHeightProperty();
        imagen.fitWidthProperty();
        this.getChildren().add(imagen);

        VBox contenedor = new VBox();
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);

        Text titulo = new Text("Ayuda sobre el juego");
        titulo.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18));
        titulo.setStyle("-fx-font-weight: bold");
        titulo.setUnderline(true);
        titulo.setFill(Color.BLACK);

        contenedor.getChildren().add(titulo);
        contenedor.getChildren().add(new TextoAyuda());

        super.getChildren().add(contenedor);
    }
}
