package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;

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
}
