package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.vista.ventanas.VentanaCreditos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreditosHandler  implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageCreditos = new Stage();
        Scene sceneCreditos = new Scene(new VentanaCreditos(),450,450);
        stageCreditos.setTitle("Creditos A.L.T.E.G.O.");
        stageCreditos.setScene(sceneCreditos);
        stageCreditos.show();
    }
}
