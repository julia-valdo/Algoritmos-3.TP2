package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Carta {
    private final Pais pais;
    private final String simbolo;

    public Carta(Pais pais, String simbolo){
        this.pais = pais;
        this.simbolo = simbolo;
    }

    public String getSimbolo(){
        return simbolo;
    }

    /*
    Devuelve 0 si las tres cartas no son del mismo tipo 4 si lo son
    cambiarlo cuando agregas funcionalidad de cantidad de veces que canjeaste las cartas
     */
    public boolean esValidoElCanje(Carta segundaCarta, Carta terceraCarta) {
        return (this.sonTresIguales(segundaCarta, terceraCarta) || this.sonTresDistintas(segundaCarta, terceraCarta));
    }

    private boolean sonTresIguales(Carta segundaCarta, Carta terceraCarta){
        return (this.simbolo.equals((segundaCarta.simbolo)) && this.simbolo.equals(terceraCarta.simbolo));
    }

    private boolean sonTresDistintas(Carta segundaCarta, Carta terceraCarta){
        return (!this.simbolo.equals((segundaCarta.simbolo)) && !this.simbolo.equals(terceraCarta.simbolo) && !segundaCarta.simbolo.equals(terceraCarta.simbolo));
    }

    public Pais getPais(){
        return pais;
    }

}
