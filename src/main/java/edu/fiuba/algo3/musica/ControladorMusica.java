package edu.fiuba.algo3.musica;

import javafx.scene.media.AudioClip;

public class ControladorMusica{

    public void start(){
        AudioClip mediaPlayer = new AudioClip("file:musiquitapiola.mp3");
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(1.0);
    }

    public void startCambioEscena(){
        AudioClip mediaPlayer = new AudioClip("file:eee.mp3");
        mediaPlayer.play();
        mediaPlayer.setVolume(5);
    }
}

