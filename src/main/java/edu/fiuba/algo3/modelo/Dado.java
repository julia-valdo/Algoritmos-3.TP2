package edu.fiuba.algo3.modelo;

import java.util.*;

public class Dado {

    private final int MAXIMASTIRADAS = 3;

    public ArrayList<Integer> tirarDado(int cantidad){

        Random numeroRandom = new Random();
        ArrayList <Integer> resultado = new ArrayList<>();

        if(cantidad >= MAXIMASTIRADAS){
            for(int i = 0; i < MAXIMASTIRADAS; i++){
                resultado.add(numeroRandom.nextInt(6)+1);
            }
        }
        else{
            for(int i = 0; i < cantidad; i++){
                resultado.add(numeroRandom.nextInt(6)+1);
            }
        }
        resultado.sort(Collections.reverseOrder());
        return resultado;
    }
}
