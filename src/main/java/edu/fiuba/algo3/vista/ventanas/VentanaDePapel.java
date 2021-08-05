package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Botones.BotonSalir;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class VentanaDePapel extends Group {

<<<<<<< HEAD

=======
>>>>>>> 871af294e0156747208af71c3d67fb8d86fe84ed
    public VentanaDePapel(Text textoAMostrar){
        this.prepararFondo();
        this.prepararTexto(textoAMostrar);
        this.prepararBotonSalir();
    }

    private void prepararTexto(Text textoAMostrar) {
        textoAMostrar.setTranslateX(60);
        textoAMostrar.setTranslateY(100);
        this.getChildren().add(textoAMostrar);
    }

    private void prepararFondo() {
        ImageView imagePanel = new ImageView();
        imagePanel.setImage(new Image("file:papel.jpg"));
        imagePanel.setFitHeight(200);
        imagePanel.setFitWidth(310);
        this.getChildren().add(imagePanel);
    }

    private void prepararBotonSalir(){
        Button botonSalir = new BotonSalir();
        botonSalir.setTranslateY(170);
        botonSalir.setTranslateX(105);
        this.getChildren().add(botonSalir);
    }
<<<<<<< HEAD

=======
>>>>>>> 871af294e0156747208af71c3d67fb8d86fe84ed
}
