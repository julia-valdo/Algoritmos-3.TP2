package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.TextoAyuda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class VentanaDados extends StackPane {

    public VentanaDados(ArrayList<Integer> resultadoDadoAtacante, ArrayList<Integer> resultadoDadoDefensor){

        ImageView imagen = new ImageView("file:papel.jpg");
        imagen.setFitHeight(600);
        imagen.setFitWidth(800);
        imagen.fitHeightProperty();
        imagen.fitWidthProperty();
        this.getChildren().add(imagen);

        VBox contenedor = new VBox();
        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);

        Text atacante = new Text("Atacante:");
        atacante.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18));
        atacante.setStyle("-fx-font-weight: bold");
        atacante.setFill(Color.BLACK);

        Text defensor = new Text("Defensor:");
        defensor.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 18));
        defensor.setStyle("-fx-font-weight: bold");
        defensor.setFill(Color.BLACK);

        VBox resultados = new VBox();
        resultados.setPadding(new Insets(20));
        resultados.setAlignment(Pos.CENTER_LEFT);

        Text resultadoAtacante = new Text(resultadoDadoAtacante.toString());
        Text resultadoDefensor = new Text(resultadoDadoDefensor.toString());
        resultados.getChildren().addAll(resultadoAtacante,resultadoDefensor);

        contenedor.getChildren().addAll(atacante, resultadoAtacante, defensor, resultadoDefensor);

        super.getChildren().add(contenedor);
    }
}
