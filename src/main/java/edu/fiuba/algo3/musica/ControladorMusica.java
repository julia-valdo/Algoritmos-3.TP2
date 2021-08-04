package edu.fiuba.algo3.musica;

import javafx.scene.media.Media;
import javafx.scene.media.AudioClip;

public class ControladorMusica{

    public void start(){
        AudioClip mediaPlayer = new AudioClip("file:AgeOfEmpiresMainTheme.mp3");
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(7);
    }

    public void startCambioEscena(){
        AudioClip mediaPlayer = new AudioClip("file:campana_aoe.mp3");
        //mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(7);
    }
}

