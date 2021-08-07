package edu.fiuba.algo3.musica;

import javafx.scene.media.AudioClip;

public class ControladorMusica{

    private static ControladorMusica instanciaMusica;

    private boolean isMuted = false;

    private AudioClip backgroundMusic;
    private AudioClip effectMusic;
    private AudioClip victoryMusic;

    public ControladorMusica(){
        backgroundMusic = new AudioClip("file:AgeOfEmpiresMainTheme.mp3");
        effectMusic = new AudioClip("file:campana_aoe.mp3");
        victoryMusic = new AudioClip("file:AgeofEmpires2VictoryMusic.mp3");
        backgroundMusic.setVolume(5);
        effectMusic.setVolume(5);
        victoryMusic.setVolume(5);
    }

    public static ControladorMusica getInstance(){
        if(instanciaMusica == null){
            instanciaMusica = new ControladorMusica();
        }
        return instanciaMusica;
    }

    public void playBackgroundMusic(){
        backgroundMusic.setCycleCount(AudioClip.INDEFINITE);
        backgroundMusic.play();
    }

    public void playEffect(){
        if(!this.isMuted){
            effectMusic.play();
        }
    }

    public void playVictory(){
        if(!this.isMuted){
            victoryMusic.play();
        }
    }

    public void muteAll(){
        this.isMuted = true;
        this.backgroundMusic.stop();
        this.victoryMusic.stop();
    }

    public void unmuteAll(){
        this.isMuted = false;
        this.playBackgroundMusic();
    }
}

