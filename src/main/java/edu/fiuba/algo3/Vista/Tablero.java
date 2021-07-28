package edu.fiuba.algo3.Vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tablero extends Application {
    private final Image bgImage = new Image("file:tableroTEG.png");
    private final StackPane container = new StackPane();
    private final Scene scene = new Scene(container, Color.BLANCHEDALMOND);
    private final Text label  = new Text("TEG");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        // Asigna un titulo y dimensiones al "stage"
//        primaryStage.setTitle("Prueba imagen de fondo");
//        primaryStage.setMinHeight(800);
//        primaryStage.setMinWidth(1000);
//
//        // Añado imagen de fondo a la ventana
//        ImageView imageView = new ImageView();
//        imageView.setImage(bgImage);
//        imageView.setFitHeight(800);
//        imageView.setFitWidth(1000);
//        container.getChildren().add(imageView);
//
//        // Añado algo de texto a la ventana (la imagen estará primero)
//        label.setFill(Color.RED);
//        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 38));
//        container.setAlignment(Pos.CENTER);
//        container.getChildren().add(label);
//
//
//        // Mostrar ventana
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//
        Stage ventana = new Stage();
        BorderPane border = new BorderPane();
        HBox hbox = new HBox();
        border.setCenter(hbox);
        ImageView imageView = new ImageView();
        imageView.setImage(new Image("file:tableroTEG.png"));
        imageView.setFitHeight(600);
        hbox.getChildren().add(imageView);
        container.getChildren().add(hbox);         // Add stack to HBox in top region

        HBox hboxDos = new HBox();
        border.setRight(hboxDos);
        ImageView imageViewDos = new ImageView();
        imageViewDos.setImage(new Image("file:papel.jpg"));
        imageViewDos.setFitHeight(600);
        imageViewDos.setFitWidth(250);
        hbox.getChildren().add(imageViewDos);
        container.getChildren().add(hboxDos);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


} // class