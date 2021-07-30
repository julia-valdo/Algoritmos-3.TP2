package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.vista.ventanas.VentanaConFichas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComenzarJuegoHandler implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scena = new Scene(new VentanaConFichas());
        stage.setScene(scena);
        stage.show();
    }
}
