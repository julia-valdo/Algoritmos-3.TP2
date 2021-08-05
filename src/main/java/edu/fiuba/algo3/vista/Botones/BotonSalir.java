package edu.fiuba.algo3.vista.Botones;

import edu.fiuba.algo3.Controlador.handlers.CerrarHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonSalir extends Button {

    public  BotonSalir(){
        super();
        this.addEventHandler(ActionEvent.ACTION, new CerrarHandler());
        this.prepararEstilo();
    }

    private void prepararEstilo() {
        this.setText("Cerrar");
        this.setStyle("-fx-font-weight: bold; -fx-background-color: #ffebcd; -fx-border-color: #000000");
    }

    public void setPosicion(int posX, int posY){
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }


}
