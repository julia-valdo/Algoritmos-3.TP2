package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Batalla {

    public void atacar(Ejercitos ejercitoAtacante, Ejercitos ejercitoDefensor){

        Dado dadoAtacante = new Dado();
        Dado dadoDefensor = new Dado();

        ArrayList<Integer> resultadoDadoAtacante;
        ArrayList<Integer> resultadoDadoDefensor;
        ArrayList<Integer> resultadoBatalla;

        resultadoDadoAtacante = dadoAtacante.tirarDado(ejercitoAtacante.getCantidadEjercitos() - 1);
        resultadoDadoDefensor = dadoDefensor.tirarDado(ejercitoDefensor.getCantidadEjercitos());

        resultadoBatalla = this.compararResultado(resultadoDadoAtacante, resultadoDadoDefensor);

        ejercitoAtacante.restarEjercitos(resultadoBatalla.get(0));
        ejercitoDefensor.restarEjercitos(resultadoBatalla.get(1));
    }




    private ArrayList<Integer> compararResultado(ArrayList<Integer> resultadoDadoAtacante, ArrayList<Integer> resultadoDadoDefensor){
    //Mandar perdidaAtack/def para atrib.
        ArrayList<Integer> resultado = new ArrayList<>();
        int perdidaAtacante = 0;
        int perdidaDefensor = 0;

        int cantidadDeDados = Math.min(resultadoDadoAtacante.size(), resultadoDadoDefensor.size());

        for(int i = 0; i < cantidadDeDados; i++ ){
            if( resultadoDadoAtacante.get(i) <= resultadoDadoDefensor.get(i) ){
                perdidaAtacante++;
            }else{
                perdidaDefensor++;
            }
        }

        resultado.add(perdidaAtacante);
        resultado.add(perdidaDefensor);
        return resultado;
    }


}
