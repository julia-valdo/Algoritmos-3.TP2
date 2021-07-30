package edu.fiuba.algo3.vista.Elementos;

import javafx.scene.control.TextField;
import javafx.scene.layout.Background;

public class CampoDeNombre extends TextField {

    public CampoDeNombre(Integer numeroDeJugador){
        super();
        this.setNombreDeCampo(numeroDeJugador);
        this.setPosicion(numeroDeJugador);
        this.setPropiedades();
    }

    private void setNombreDeCampo(Integer numeroDeJugador){
        this.setText("Jugador " + numeroDeJugador.toString());
    }

    private void setPosicion(Integer numeroDeJugador){

            this.setTranslateX(900);
            this.setTranslateY(100 + (numeroDeJugador - 1) * 40);
    }

    private void setPropiedades(){
        this.setHeight(20);
        this.setStyle("-fx-font-weight: bold; -fx-background-color: #ffebcd; -fx-border-color: #000000");
    }

}
