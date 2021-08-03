package edu.fiuba.algo3.Controlador.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class AyudaHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setHeaderText("A.L.T.E.G.O.");
        String mensaje = "https://yetem.com/wp-content/uploads/2017/06/TEG.pdf";
        alert.setContentText(mensaje);
        alert.show();
    }
}
