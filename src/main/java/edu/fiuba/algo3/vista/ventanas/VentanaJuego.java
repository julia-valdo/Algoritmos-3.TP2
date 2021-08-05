package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.scene.Group;

import java.util.ArrayList;

public class VentanaJuego extends Group {

    public VentanaJuego(ArrayList<Ficha> fichas, VentanaMenu menuActual){
        this.prepararMenu();
        this.agregarElementos(fichas, menuActual);
    }

    private void agregarElementos(ArrayList<Ficha> fichas, VentanaMenu menuActual){
        this.agregarFichas(fichas);
        this.getChildren().add(menuActual);
    }

    private void prepararMenu(){
        VentanaPrincipal principal = new VentanaPrincipal();
        this.getChildren().add(principal);
    }

    private void agregarFichas(ArrayList<Ficha> fichas){
        for(Ficha ficha: fichas){
            ficha.agregarseA(this);
        }
    }
}
