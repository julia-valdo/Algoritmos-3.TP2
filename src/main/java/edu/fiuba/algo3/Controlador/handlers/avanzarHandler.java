package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.Controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class avanzarHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scena = Controlador.pedirMenuSiguiente();
        stage.setScene(scena);
        stage.show();

    }
}
