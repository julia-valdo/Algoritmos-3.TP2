package edu.fiuba.algo3.vista.Elementos;

import javafx.scene.Group;
import javafx.scene.text.Text;

public class TextoNotificable extends Text {

    Group agregadoAGrupo;

    public TextoNotificable(Ficha fichaEscuchada){
        fichaEscuchada.notificame(this);
        this.setText("Fichas restantes: " + fichaEscuchada.getCantidad().getText());
        this.setStyle();
    }

    public TextoNotificable(){
        this.setStyle();
    }

    public void setPosicion(int posX, int posY){
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

    private void setStyle(){
        this.setStyle("-fx-font-weight: bold");
    }

    public void notificar(Text texto) {
        this.setText("Fichas restantes: " + texto.getText());
    }


    public void agregarAGrupo(Group grupo){
        this.agregadoAGrupo = grupo;
        grupo.getChildren().add(this);
    }

    public boolean noEstaAgregadoA(Group grupoDeEscena) {
        return !(grupoDeEscena == this.agregadoAGrupo);
    }
}
