package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Botones.BotonCancel;
import edu.fiuba.algo3.vista.Botones.BotonComenzar;
import edu.fiuba.algo3.vista.Elementos.CampoDeNombre;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class VentanaNombrarJugadores extends Group {

    public VentanaNombrarJugadores(Integer numeroDeJugadores){
        super();
        this.agregarFondo();
        this.agregarBotonCancel();
        this.agregarCampos(numeroDeJugadores);
    }

    private void agregarFondo(){
        Group stack = new VentanaPrincipal();

        this.getChildren().add(stack);
    }

    private void agregarBotonCancel(){
        Button cancel = new BotonCancel();
        this.getChildren().addAll(cancel);
    }

    private void agregarCampos(Integer numeroDeJugadores){
        ArrayList<TextField> textos = new ArrayList<>();
        for(int i = 1; i <= numeroDeJugadores; i++){
            textos.add(new CampoDeNombre(i));
        }
        Button comenzar = new BotonComenzar(textos);
        this.getChildren().add(comenzar);
        this.getChildren().addAll(textos);
    }

}
