package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.modelo.Objetivos.Objetivo;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ObjetivoJugador implements Objetivo {
    Objetivo general;
    Objetivo secreto;

    public ObjetivoJugador(Objetivo general, Objetivo secreto){
        this.general = general;
        this.secreto = secreto;
    }

    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        return general.objetivoCumplido(paises) || secreto.objetivoCumplido(paises);
    }

    @Override
    public Text prepararVista() {
        Text textoObjetivo = new Text();
        this.prepararTextoDeObjetivo(textoObjetivo);
        return textoObjetivo;
    }

    @Override
    public void setJugadorAuxiliar(Jugador actual, Jugador auxiliar) {
        secreto.setJugadorAuxiliar(actual, auxiliar);
    }

    private void prepararTextoDeObjetivo(Text textoObjetivo) {
        String textoDeObjetivo = ((Text) this.general.prepararVista()).getText() + "\n";
        textoDeObjetivo += ((Text) this.secreto.prepararVista()).getText();
        textoObjetivo.setText(textoDeObjetivo);
        textoObjetivo.setStyle("-fx-font-weight: bold; -fx-font: 16 arial");
    }
}
