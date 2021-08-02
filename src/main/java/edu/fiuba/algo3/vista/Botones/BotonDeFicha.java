package edu.fiuba.algo3.vista.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonDeFicha extends Button {

    public BotonDeFicha(EventHandler<ActionEvent> handler){
        super();
        this.setHeight(20);
        this.setWidth(20);
        //this.setStyle("-fx-background-color: transparent");
        this.addEventHandler(ActionEvent.ACTION, handler);
    }


}
