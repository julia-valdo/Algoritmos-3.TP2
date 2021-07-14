package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

// ojo con los numeros magicos
// ojo cantidad distinta de dados
// ordenar los vectores de mayor a menor

public class Batalla {

    public void atacar(Ejercitos ejercitoAtacante, Ejercitos ejercitoDefensor){

        Dado dadoAtacante = new Dado();
        Dado dadoDefensor = new Dado();

        ArrayList<Integer> resultadoDadoAtacante = new ArrayList<>();
        ArrayList<Integer> resultadoDadoDefensor = new ArrayList<>();
        ArrayList<Integer> resultadoBatalla = new ArrayList<>();

        resultadoDadoAtacante = dadoAtacante.tirarDado(ejercitoAtacante.getCantidadEjercitos());
        resultadoDadoDefensor = dadoDefensor.tirarDado(ejercitoDefensor.getCantidadEjercitos());

        resultadoBatalla = this.compararResultado(resultadoDadoAtacante, resultadoDadoDefensor);

        ejercitoAtacante.restarEjercitos(resultadoBatalla.get(0));
        ejercitoDefensor.restarEjercitos(resultadoBatalla.get(1));
    }

    private ArrayList<Integer> compararResultado(ArrayList<Integer> resultadoDadoAtacante, ArrayList<Integer> resultadoDadoDefensor){

        ArrayList<Integer> resultado = new ArrayList<>();
        int perdidaAtacante = 0;
        int perdidaDefensor = 0;

        for(int i = 0; i < 3; i++ ){
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
