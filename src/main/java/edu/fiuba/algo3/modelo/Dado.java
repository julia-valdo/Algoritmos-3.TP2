package edu.fiuba.algo3.modelo;

import java.util.*;

public class Dado {

    private final int maximasTiradas = 3;
    private final int cantidadNumerosDado = 6;

    public ArrayList<Integer> tirarDado(int cantidad){

        Random numeroRandom = new Random();
        ArrayList <Integer> resultado = new ArrayList<>();

        if(cantidad >= maximasTiradas){
            for(int i = 0; i < maximasTiradas; i++){
                resultado.add(numeroRandom.nextInt(cantidadNumerosDado)+1);
            }
        }
        else{
            for(int i = 0; i < cantidad; i++){
                resultado.add(numeroRandom.nextInt(cantidadNumerosDado)+1);
            }
        }
        resultado.sort(Collections.reverseOrder());
        return resultado;
    }
}
