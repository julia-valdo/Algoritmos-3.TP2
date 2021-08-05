package edu.fiuba.algo3.vista.Botones;

import edu.fiuba.algo3.Controlador.handlers.MostrarObjetivoHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class BotonMostrarObjetivo extends Button {

    public BotonMostrarObjetivo(Text textoDeObjetivo,  String nombreJugador, String color){
        super();
        MostrarObjetivoHandler handler = new MostrarObjetivoHandler(textoDeObjetivo, nombreJugador);
        this.addEventHandler(ActionEvent.ACTION, handler);
        this.setStyle("-fx-background-color: " + color + "; -fx-font-weight: bold;" +
                "-fx-text-fill: #ffffff");
        this.setText("Mostrar objetivo");
    }

}
