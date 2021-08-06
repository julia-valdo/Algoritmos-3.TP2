package edu.fiuba.algo3.modelo.Batalla;

import edu.fiuba.algo3.vista.ventanas.VentanaAyuda;
import edu.fiuba.algo3.vista.ventanas.VentanaDados;
import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

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

        Stage stageAyuda = new Stage();
        Scene sceneAyuda = new Scene(new VentanaDados(resultadoDadoAtacante, resultadoDadoDefensor),300,300);
        stageAyuda.setTitle("Resultados");
        stageAyuda.setScene(sceneAyuda);
        stageAyuda.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished( event -> stageAyuda.close() );
        delay.play();

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
