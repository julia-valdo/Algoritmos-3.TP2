package edu.fiuba.algo3.musica;

import javafx.scene.media.AudioClip;

public class ControladorMusica{

    private static ControladorMusica instanciaMusica;


    private static AudioClip backgroundMusic;
    private static AudioClip effectMusic;
    private static AudioClip victoryMusic;

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

    public static void playBackgroundMusic(){
        backgroundMusic.setCycleCount(AudioClip.INDEFINITE);
        backgroundMusic.play();
        victoryMusic.stop();
    }

    public static void playEffect(){
        effectMusic.play();
    }

    public static void playVictory(){
        backgroundMusic.stop();
        victoryMusic.play();
    }

    public static void soundRestart(){
        victoryMusic.stop();
        if(!backgroundMusic.isPlaying()){
            backgroundMusic.play();
        }
    }

    public static void muteAll(){
        backgroundMusic.setVolume(0);
        backgroundMusic.stop();
        victoryMusic.setVolume(0);
        effectMusic.setVolume(0);
    }

    public static void unmuteAll(){
        backgroundMusic.setVolume(5);
        backgroundMusic.play();
        victoryMusic.setVolume(5);
        effectMusic.setVolume(5);
    }
}

