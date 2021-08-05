package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.vista.ventanas.VentanaAyuda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AyudaHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageAyuda = new Stage();
        Scene sceneAyuda = new Scene(new VentanaAyuda(),900,600);
        stageAyuda.setTitle("Ayuda A.L.T.E.G.O.");
        stageAyuda.setScene(sceneAyuda);
        stageAyuda.show();
    }
}
