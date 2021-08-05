package edu.fiuba.algo3.musica;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class MusicaOnHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent){
        AudioClip mediaPlayer = new AudioClip("file:AgeOfEmpiresMainTheme.mp3");
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(7);
    }
}