package edu.fiuba.algo3.musica;

import javafx.scene.media.Media;
import javafx.scene.media.AudioClip;

public class ControladorMusica{

    public void start(){
        Media musica = new Media("01 Age of Empires II Main Theme.mp3");
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(7);
    }
}

