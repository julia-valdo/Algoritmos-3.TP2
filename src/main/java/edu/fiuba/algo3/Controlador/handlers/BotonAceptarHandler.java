package edu.fiuba.algo3.Controlador.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonAceptarHandler implements EventHandler<ActionEvent> {

    TextField texto;
    Label respuesta;
    Stage stage;
    Scene nextScene;

    public BotonAceptarHandler(TextField campoDeTexto, Label etiqueta, Stage stage, Scene nextScene) {
        this.texto = campoDeTexto;
        this.respuesta = etiqueta;
        this.stage = stage;
        this.nextScene = nextScene;
    }

    @Override
    public void handle (ActionEvent actionEvent){
        // chequear que me pasen un numero entero > 1 y < 7

        stage.setScene(nextScene);
        stage.setFullScreenExitHint("");
    }

}
