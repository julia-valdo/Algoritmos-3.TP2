package edu.fiuba.algo3.vista.Elementos;

import edu.fiuba.algo3.Controlador.handlers.AyudaHandler;
import edu.fiuba.algo3.Controlador.handlers.ComoJugarHandler;
import edu.fiuba.algo3.Controlador.handlers.SalirHandler;
import edu.fiuba.algo3.musica.MusicaOffHandler;
import edu.fiuba.algo3.musica.MusicaOnHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BarraMenu extends MenuBar {

    public BarraMenu() {
        Menu menuAyuda = new Menu("Ayuda");
        Menu menuOpciones = new Menu("Opciones");
        Menu menuMusica = new Menu("Musica");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAyudaJuego = new MenuItem("Reglas");
        MenuItem opcionOffMusica = new MenuItem("Off");
        MenuItem opcionOnMusica = new MenuItem("On");
        MenuItem opcionComoJugar = new MenuItem("Como Jugar");

        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:papel.jpg"));
        imagePanel.setFitHeight(30);
        imagePanel.setFitWidth(1108);

        opcionSalir.setOnAction(new SalirHandler());
        opcionSalir.setStyle("-fx-font-weight: bold");
        menuOpciones.getItems().add(opcionSalir);

        opcionAyudaJuego.setOnAction(new AyudaHandler());
        opcionAyudaJuego.setStyle("-fx-font-weight: bold");
        opcionComoJugar.setOnAction(new ComoJugarHandler());
        opcionComoJugar.setStyle("-fx-font-weight: bold");
        menuAyuda.getItems().add(opcionAyudaJuego);
        menuAyuda.getItems().add(opcionComoJugar);

        opcionOffMusica.setOnAction(new MusicaOffHandler());
        opcionOffMusica.setStyle("-fx-font-weight: bold");
        opcionOnMusica.setOnAction(new MusicaOnHandler());
        opcionOnMusica.setStyle("-fx-font-weight: bold");
        menuMusica.getItems().addAll(opcionOnMusica, opcionOffMusica);

        this.setStyle("-fx-font-weight: bold");

        this.getMenus().addAll(menuOpciones, menuMusica, menuAyuda);
        this.getChildren().add(imagePanel);
    }
}

