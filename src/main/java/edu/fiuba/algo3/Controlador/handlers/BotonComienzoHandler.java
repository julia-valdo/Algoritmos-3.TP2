package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.vista.ventanas.VentanaCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BotonComienzoHandler implements EventHandler<ActionEvent> {


    private Scene nextScene;

    public BotonComienzoHandler () {
        StackPane seleccion = new VentanaCantidadJugadores();


        this.nextScene = new Scene(seleccion);
    }

    @Override
    public void handle (ActionEvent actionEvent){
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(nextScene);
        stage.setFullScreenExitHint("");
    }
}
