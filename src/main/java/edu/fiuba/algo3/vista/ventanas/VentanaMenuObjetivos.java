package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Botones.BotonEmpezarColocacion;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class VentanaMenuObjetivos extends  VentanaMenu{

    public VentanaMenuObjetivos(ArrayList<Node> nodosDeJugadores) {
        super();
        this.acomodarNodos(nodosDeJugadores);
        this.getChildren().addAll(nodosDeJugadores);
        this.ponerBotonAvance();
    }

    private void ponerBotonAvance() {
        Button botonAvance = new BotonEmpezarColocacion();
        this.getChildren().add(botonAvance);
    }

    private void acomodarNodos(ArrayList<Node> nodosDeJugadores) {
        int posY = 200;
        for(Node nodo: nodosDeJugadores){
            nodo.setTranslateX(910);
            nodo.setTranslateY(posY);
            posY += 40;
        }
    }
}
