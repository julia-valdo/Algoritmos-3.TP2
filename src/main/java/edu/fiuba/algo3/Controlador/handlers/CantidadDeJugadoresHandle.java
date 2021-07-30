package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.Controlador.Controlador;
import edu.fiuba.algo3.vista.ventanas.VentanaNombrarJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CantidadDeJugadoresHandle implements EventHandler<ActionEvent> {

    private Integer cantidadDeJugadores;

    public CantidadDeJugadoresHandle(Integer cantidadDeJugadores){
        this.cantidadDeJugadores = cantidadDeJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Group grupo = new VentanaNombrarJugadores(this.cantidadDeJugadores);
        Scene scena = new Scene(grupo);
        Controlador.setearJuego(this.cantidadDeJugadores);
        stage.setScene(scena);
        stage.show();
    }
}
