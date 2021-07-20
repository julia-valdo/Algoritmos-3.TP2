package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Carta {
    private String pais;
    private String simbolo;

    public Carta(String pais, String simbolo){
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

        return this.simbolo.equals((segundaCarta.simbolo)) && this.simbolo.equals(terceraCarta.simbolo);
    }
    /*
    Verifica que el pais asociado este entre los paises del parametro
     */
    public Pais ObtenerPaisAsociado(ArrayList<Pais> paises){
            return paises.stream().filter(pais -> pais.es(this.pais)).findFirst().orElse(null);
    }


}
