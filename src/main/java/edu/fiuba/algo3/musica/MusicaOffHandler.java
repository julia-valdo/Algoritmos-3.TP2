package edu.fiuba.algo3.musica;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class MusicaOffHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        AudioClip musicaFondo = new AudioClip("file:AgeOfEmpiresMainTheme.mp3");
        AudioClip musicaEfecto = new AudioClip("file:campana_aoe.mp3");
        AudioClip musicaVictoria = new AudioClip("file:AgeofEmpires2VictoryMusic.mp3");
        musicaFondo.stop();
        musicaEfecto.stop();
        musicaVictoria.stop();
    }
}