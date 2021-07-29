package edu.fiuba.algo3.vista.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComienzoHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene nextScene;

    public BotonComienzoHandler (Stage stage, Scene nextScene) {
        this.stage = stage;
        this.nextScene = nextScene;
    }

    @Override
    public void handle (ActionEvent actionEvent){
        stage.setScene(nextScene);
        stage.setFullScreenExitHint("");
    }
}
