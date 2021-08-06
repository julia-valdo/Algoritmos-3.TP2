package edu.fiuba.algo3.musica;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class MusicaOffHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        AudioClip mediaPlayer = new AudioClip("file:musiquitapiola.mp3");
        mediaPlayer.stop();
    }
}