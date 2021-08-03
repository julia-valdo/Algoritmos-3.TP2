package edu.fiuba.algo3.vista.Elementos;

import edu.fiuba.algo3.Controlador.handlers.AyudaHandler;
import edu.fiuba.algo3.Controlador.handlers.SalirHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;

public class BarraMenu extends MenuBar {

    public BarraMenu() {
        Menu menuAyuda = new Menu("Ayuda");
        Menu menuMusica = new Menu("Musica");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAyudaJuego = new MenuItem("Ayuda");

        opcionSalir.setOnAction(new SalirHandler());
        opcionAyudaJuego.setOnAction(new AyudaHandler());

        menuAyuda.getItems().addAll(opcionSalir, opcionAyudaJuego);

        this.getMenus().addAll(menuMusica, menuAyuda);
    }

}
