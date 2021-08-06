package edu.fiuba.algo3.vista.Botones;

import edu.fiuba.algo3.Controlador.handlers.MostrarCartasHandler;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJugador;
import javafx.event.ActionEvent;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class BotonMostrarCartas extends Button{
    public BotonMostrarCartas(InventarioDeJugador inventario){
        super();
        MostrarCartasHandler handler = new MostrarCartasHandler(inventario);
        this.addEventHandler(ActionEvent.ACTION, handler);
        this.setStyle("-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000");
        this.setText("Mostrar Cartas");
    }
}
