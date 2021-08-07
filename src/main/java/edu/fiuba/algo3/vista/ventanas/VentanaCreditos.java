package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.TextoCreditos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VentanaCreditos  extends StackPane {

    public VentanaCreditos() {
        ImageView imagen = new ImageView("file:papel.jpg");
        imagen.setFitHeight(500);
        imagen.setFitWidth(500);
        imagen.fitHeightProperty();
        imagen.fitWidthProperty();
        this.getChildren().add(imagen);

        VBox contenedor = new VBox();
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);

        Text titulo = new Text("Creditos");
        titulo.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18));
        titulo.setStyle("-fx-font-weight: bold");
        titulo.setUnderline(true);
        titulo.setFill(Color.BLACK);

        contenedor.getChildren().add(titulo);
        contenedor.getChildren().add(new TextoCreditos());

        super.getChildren().add(contenedor);
    }
}
