package edu.fiuba.algo3.vista.Botones;

import edu.fiuba.algo3.Controlador.handlers.avanzarHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonAvanzarTurno extends Button {

    public BotonAvanzarTurno(){
        this.addEventHandler(ActionEvent.ACTION, new avanzarHandler());
        this.colocarBoton();
        this.colocarTexto();
    }

    private void colocarBoton(){
        this.setTranslateX(920);
        this.setTranslateY(570);
    }

    private void colocarTexto(){
        this.setText("Pasar turno");
        this.setStyle("-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000");
    }

}
