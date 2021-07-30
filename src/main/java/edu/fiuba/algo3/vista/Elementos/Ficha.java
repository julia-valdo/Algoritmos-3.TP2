package edu.fiuba.algo3.vista.Elementos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Ficha extends Circle {

    private static ColoresJugadores colores = new ColoresJugadores();
    private Pais pais;
    private Text texto;
    private Button boton;

    public  Ficha(String color){
        super();
        this.setFill(Paint.valueOf(color));
        this.texto = new Text("1");
        texto.setStyle("-fx-font-weight: bold");
        texto.setFill(Paint.valueOf("#ffffff"));
        this.setRadius(12);
    }

    public void setPosicion(int posX, int posY){
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        this.texto.setTranslateX(posX - 6);
        this.texto.setTranslateY(posY + 4);
    }

    public void agregarseA(Group parent){
        parent.getChildren().add(this);
        parent.getChildren().add(texto);
    }

    public void setColor(String nuevoColor){
        this.setFill(Paint.valueOf(nuevoColor));
    }

}
