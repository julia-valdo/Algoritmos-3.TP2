package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.Controlador.handlers.BotonComienzoHandler;
import edu.fiuba.algo3.vista.Botones.BotonComienzo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class VentanaComienzo extends StackPane {


    public VentanaComienzo() {

        super();
        this.prepararImagen();


    }


    private void prepararImagen(){

        Group panel = new VentanaPrincipal();
        Button comienzo = this.prepararBotonInicio();
        panel.getChildren().add(comienzo);
        this.getChildren().add(panel);

    }

    private Button prepararBotonInicio(){
        Button botonComienzo = new BotonComienzo();
        this.getChildren().addAll(botonComienzo);

        return botonComienzo;
    }

}
