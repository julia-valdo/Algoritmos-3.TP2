package edu.fiuba.algo3.vista.Elementos;

import javafx.scene.control.TextField;

public class CampoDeNombre extends TextField {

    private Integer numeroJugador;
    private static ColoresJugadores colores = new ColoresJugadores();

    public CampoDeNombre(Integer numeroDeJugador){
        super();
        this.numeroJugador = numeroDeJugador;
        this.setNombreDeCampo(numeroDeJugador);
        this.setPosicion(numeroDeJugador);
        this.setPropiedades(numeroJugador);
    }

    private void setNombreDeCampo(Integer numeroDeJugador){
        this.setText("Jugador " + numeroDeJugador.toString());
    }

    private void setPosicion(Integer numeroDeJugador){

            this.setTranslateX(900);
            this.setTranslateY(100 + (numeroDeJugador - 1) * 40);
    }

    private void setPropiedades(Integer numeroJugador){
        this.setHeight(20);
        String colorDeJugador = colores.getColor(numeroJugador);
        this.setStyle("-fx-font-weight: bold; -fx-background-color: " +
                colorDeJugador + "; -fx-border-color: #000000;" +
                "-fx-text-fill: #ffffff");
    }

    public int getNumero() {
        return this.numeroJugador;
    }
}
