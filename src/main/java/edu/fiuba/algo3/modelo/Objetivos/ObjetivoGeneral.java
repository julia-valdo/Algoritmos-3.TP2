package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ObjetivoGeneral implements Objetivo{
    int cantidadDePaisesAConquistar;

    public ObjetivoGeneral(int cantidad){
        cantidadDePaisesAConquistar = cantidad;
    }

    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        return paises.size() >= cantidadDePaisesAConquistar;
    }

    @Override
    public Text prepararVista() {
        Text texto = new Text();
        this.prepararTextoDeObjetivo(texto);
        return texto;
    }

    @Override
    public void setJugadorAuxiliar(Jugador actual, Jugador auxiliar) {

    }

    private void prepararTextoDeObjetivo(Text texto) {
        texto.setText("Conquistar 30 paises.");
    }
}
