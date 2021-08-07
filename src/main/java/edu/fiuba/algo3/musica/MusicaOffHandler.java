package edu.fiuba.algo3.musica;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MusicaOffHandler implements EventHandler<ActionEvent> {

    private final ControladorMusica musica = ControladorMusica.getInstance();

    @Override
    public void handle(ActionEvent actionEvent) {
        musica.muteAll();
    }
}