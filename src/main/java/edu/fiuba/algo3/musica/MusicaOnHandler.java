package edu.fiuba.algo3.musica;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MusicaOnHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent){
        ControladorMusica.unmuteAll();
    }
}