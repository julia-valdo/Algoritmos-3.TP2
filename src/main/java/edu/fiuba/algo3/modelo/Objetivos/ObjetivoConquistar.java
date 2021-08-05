package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.modelo.Objetivos.Objetivo;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ObjetivoConquistar implements Objetivo {
    Continente primario;
    Continente secundario;
    Integer cantidadAConquistarSecundario;

    public ObjetivoConquistar (Continente primario, Continente secundario, int cantidadAConquistarSecundario){
        this.primario = primario;
        this.secundario = secundario;
        this.cantidadAConquistarSecundario = cantidadAConquistarSecundario;
    }

    private int contadorDePaisesSecundarios(ArrayList<Pais> paises){
        int contador = 0;
        for(Pais pais : paises){
            if(secundario.pertenece(pais)) contador += 1;
        }
        return contador;
    }

    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        int cantidadPaisesSecundarios = this.contadorDePaisesSecundarios(paises);
        return primario.fueConquistado(paises) && (cantidadPaisesSecundarios >= this.cantidadAConquistarSecundario);
    }

    @Override
    public Text prepararVista() {
        Text textoDeObjetivo = new Text();
        this.prepararTextoDelObjetivo(textoDeObjetivo);

        return textoDeObjetivo;
    }

    @Override
    public void setJugadorAuxiliar(Jugador actual, Jugador auxiliar) {

    }


    private void prepararTextoDelObjetivo(Text textoDeObjetivo){
        textoDeObjetivo.setText("Conquistar: " + primario.getNombre() + "\n"
        + this.cantidadAConquistarSecundario.toString() + " paises de: " + secundario.getNombre());
    }
}
