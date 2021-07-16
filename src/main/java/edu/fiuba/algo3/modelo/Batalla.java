package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Batalla {

    private int perdidaAtacante;
    private int perdidaDefensor;
    ArrayList<Integer> resultadoDadoAtacante;
    ArrayList<Integer> resultadoDadoDefensor;

    public Batalla(){
        this.perdidaAtacante = 0;
        this.perdidaDefensor = 0;
    }

    public void atacar(Ejercitos ejercitoAtacante, Ejercitos ejercitoDefensor){

        this.tirarDadoAtacante(ejercitoAtacante.getCantidadEjercitos());
        this.tirarDadoDefensor(ejercitoDefensor.getCantidadEjercitos());

        this.compararResultado(resultadoDadoAtacante, resultadoDadoDefensor);

        ejercitoAtacante.restarEjercitos(this.perdidaAtacante);
        ejercitoDefensor.restarEjercitos(this.perdidaDefensor);
    }


    private void compararResultado(ArrayList<Integer> resultadoDadoAtacante, ArrayList<Integer> resultadoDadoDefensor) {

        int cantidadDeDados = Math.min(resultadoDadoAtacante.size(), resultadoDadoDefensor.size());
        for (int i = 0; i < cantidadDeDados; i++) {
            if (resultadoDadoAtacante.get(i) <= resultadoDadoDefensor.get(i)) {
                perdidaAtacante++;
            } else {
                perdidaDefensor++;
            }
        }
    }

    private ArrayList<Integer> tirarDado(int cantidadDeTiros){
        Dado dadoATirar = new Dado();

        return dadoATirar.tirarDado(cantidadDeTiros);
    }

    private void tirarDadoAtacante(int numeroFichasAtacante){
        resultadoDadoAtacante = this.tirarDado(numeroFichasAtacante - 1);
    }

    private void tirarDadoDefensor(int numeroFichasDefensor){
        resultadoDadoDefensor = this.tirarDado(numeroFichasDefensor);
    }
}
