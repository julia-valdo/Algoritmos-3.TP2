package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.vista.ventanas.VentanaComoJugar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComoJugarHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageComoJugar = new Stage();
        Scene sceneComoJugar = new Scene(new VentanaComoJugar(),700,600);
        stageComoJugar.setTitle("Como Jugar A.L.T.E.G.O.");
        stageComoJugar.setScene(sceneComoJugar);
        stageComoJugar.show();
    }
}
