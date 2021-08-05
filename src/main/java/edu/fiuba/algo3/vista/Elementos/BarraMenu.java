package edu.fiuba.algo3.vista.Elementos;

import edu.fiuba.algo3.Controlador.handlers.AyudaHandler;
import edu.fiuba.algo3.Controlador.handlers.SalirHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BarraMenu extends MenuBar {

    public BarraMenu() {
        Menu menuAyuda = new Menu("Ayuda");
        Menu menuMusica = new Menu("Musica");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAyudaJuego = new MenuItem("Ayuda");
        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:papel.jpg"));
        imagePanel.setFitHeight(30);
        imagePanel.setFitWidth(1108);

        opcionSalir.setOnAction(new SalirHandler());
        opcionSalir.setStyle("-fx-font-weight: bold");
        opcionAyudaJuego.setOnAction(new AyudaHandler());
        opcionAyudaJuego.setStyle("-fx-font-weight: bold");

        menuAyuda.getItems().addAll(opcionSalir, opcionAyudaJuego);

        this.setStyle("-fx-font-weight: bold");

        this.getMenus().addAll(menuMusica, menuAyuda);
        this.getChildren().add(imagePanel);
    }
}
