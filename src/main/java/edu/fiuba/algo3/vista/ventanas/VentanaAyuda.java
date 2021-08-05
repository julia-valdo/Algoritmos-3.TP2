package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.TextoAyuda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VentanaAyuda extends StackPane {

    public VentanaAyuda() {
        Image imagen = new Image("file:papel.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        VBox contenedor = new VBox(70);
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);

        Text titulo = new Text("Ayuda sobre el juego");
        titulo.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        titulo.setStyle("-fx-font-weight: bold");
        titulo.setUnderline(true);
        titulo.setFill(Color.BLACK);

        contenedor.getChildren().add(titulo);
        contenedor.getChildren().add(new TextoAyuda());

        super.getChildren().add(contenedor);
    }
}
