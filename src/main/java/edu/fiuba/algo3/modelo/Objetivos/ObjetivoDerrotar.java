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

    @Override
    public void setJugadorAuxiliar(Jugador actual, Jugador auxiliar) {
        if(this.jugador == null || this.jugador.equals(actual)) this.jugador = auxiliar;
    }

    private void prepararTextoDeObjetivo(Text textoDeObjetivo) {
        textoDeObjetivo.setText("Derrotar al jugador: " + this.jugador.getNombreJugador());
    }


    private boolean verificarCumplimiento(){
        return this.jugador.fueDerrotado();
    }
}
