package edu.fiuba.algo3.modelo;

import java.util.*;

public class Dado {

    public ArrayList<Integer> tirarDado(int cantidad){

        Random numeroRandom = new Random();
        ArrayList <Integer> resultado = new ArrayList<>();

        if(cantidad > 3){
            for(int i = 0; i < 3; i++){
                resultado.add(numeroRandom.nextInt(6)+1);
            }
        }
        else{
            for(int i = 0; i < cantidad; i++){
                resultado.add(numeroRandom.nextInt(6)+1);
            }
        }

        Collections.sort(resultado);
        return resultado;
    }
}
