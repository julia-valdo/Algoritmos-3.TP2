package edu.fiuba.algo3.vista.Botones;

import edu.fiuba.algo3.Controlador.handlers.AvanzarHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonEmpezarColocacion extends Button {

    public BotonEmpezarColocacion(){
        super();
        this.addEventHandler(ActionEvent.ACTION, new AvanzarHandler());
        this.setPropiedades();
    }

    private void setPropiedades() {
        this.setTranslateX(940);
        this.setTranslateY(580);
        this.setStyle("-fx-font-weight: bold; -fx-background-color: #ffebcd; -fx-border-color: #000000");
        this.setText("Avanzar");
    }

}
