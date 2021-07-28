package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Objetivos.Objetivo;

import java.util.ArrayList;

public class ObjetivoJugador implements Objetivo {
    private final int cantidadAConquistar = 30;
    Objetivo conquistarContinente;
    Objetivo derrotarJugador;

    public ObjetivoJugador(Objetivo conquistar, Objetivo derrotar){
        this.conquistarContinente = conquistar;
        this.derrotarJugador = derrotar;
    }

    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        boolean objetivoEspecifico = (this.conquistarContinente.objetivoCumplido(paises) && this.derrotarJugador.objetivoCumplido(paises));
        return objetivoEspecifico || (paises.size() == cantidadAConquistar);
    }
}
