package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class VentanaConFichas extends Group {

    public VentanaConFichas(ArrayList<Ficha> fichas){
        super();
        Group principal = new VentanaPrincipal();
        this.getChildren().add(principal);
        this.agregarFichas(fichas);
    }

    private void agregarFichas(ArrayList<Ficha> fichas){

        for(Ficha ficha: fichas){
            ficha.agregarseA(this);
        }
    }

}
