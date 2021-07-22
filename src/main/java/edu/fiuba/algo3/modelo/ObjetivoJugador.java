package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoJugador implements Objetivo{
    Objetivo conquistarContinente;
    Objetivo derrotarJugador;
    int paisesAConquistar;

    public ObjetivoJugador(Objetivo conquistar, Objetivo derrotar){
        this.conquistarContinente = conquistar;
        this.derrotarJugador = derrotar;
        this.paisesAConquistar = 30;
    }

    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        boolean objetivoEspecifico = (this.conquistarContinente.objetivoCumplido(paises) && this.derrotarJugador.objetivoCumplido(paises));
        return objetivoEspecifico || (paises.size() == paisesAConquistar);
    }
}
