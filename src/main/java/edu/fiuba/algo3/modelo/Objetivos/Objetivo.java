package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.util.ArrayList;

public interface Objetivo {
    public  boolean objetivoCumplido(ArrayList<Pais> paises);
    Text prepararVista();
    public void setJugadorAuxiliar(Jugador actual, Jugador auxiliar);
}
