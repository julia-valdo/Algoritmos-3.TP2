package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoConquistar implements Objetivo{
    Continente primario;
    Continente secundario;
    int cantidadAConquistarSecundario;

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
}
