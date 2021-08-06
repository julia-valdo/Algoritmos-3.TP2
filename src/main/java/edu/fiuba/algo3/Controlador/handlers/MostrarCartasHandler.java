
package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJugador;
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MostrarCartasHandler implements EventHandler<ActionEvent> {
    Text texto;
    InventarioDeJugador inventario;

    public MostrarCartasHandler(InventarioDeJugador inventario) {
        this.inventario = inventario;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.inventario.mostrarCartas();
    }
}