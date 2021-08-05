package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ObjetivoDerrotar implements Objetivo {
    Jugador jugador;

    public ObjetivoDerrotar(Jugador jugador){
        this.jugador = jugador;
    }


    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        return this.verificarCumplimiento();
    }

    @Override
    public Text prepararVista() {
        Text textoDeObjetivo = new Text();
        this.prepararTextoDeObjetivo(textoDeObjetivo);
        return textoDeObjetivo;
    }

    private void prepararTextoDeObjetivo(Text textoDeObjetivo) {
        if(this.jugador == null){
            textoDeObjetivo.setText("Cumplir objetivo general");
        }
        else textoDeObjetivo.setText("Derrotar al jugador: " + this.jugador.getNombreJugador());
    }


    private boolean verificarCumplimiento(){
        if(jugador != null){
            return this.jugador.fueDerrotado();
        }
        return false;
    }
}
