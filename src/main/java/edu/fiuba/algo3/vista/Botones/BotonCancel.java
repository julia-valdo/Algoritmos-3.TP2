package edu.fiuba.algo3.vista.Botones;

import edu.fiuba.algo3.Controlador.handlers.BotonVolverASeleccionHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonCancel extends Button {

    public BotonCancel(){
        super();
        this.addEventHandler(ActionEvent.ACTION, new BotonVolverASeleccionHandler());
        this.colocarBoton();
        this.colocarTexto();
    }


    private void colocarBoton(){
        this.setTranslateX(940);
        this.setTranslateY(570);
    }

    private void colocarTexto(){
        this.setText("Cancelar");
        this.setStyle("-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000");
    }

}
