package edu.fiuba.algo3.vista.ventanas;

import javafx.scene.Group;

public class VentanaMostrarObjetivos extends Group {


    public VentanaMostrarObjetivos(VentanaMenu menuObjetivos){
        super();
        this.agregarMenu();
        this.getChildren().add(menuObjetivos);
    }

    private void agregarMenu() {
        VentanaPrincipal menu = new VentanaPrincipal();
        this.getChildren().add(menu);
    }

}
