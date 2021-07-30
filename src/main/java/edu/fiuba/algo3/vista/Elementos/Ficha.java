package edu.fiuba.algo3.vista.Elementos;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ficha extends Circle {

    public  Ficha(String color){
        super();
        this.setFill(Paint.valueOf(color));
        this.setRadius(10);
    }

    public void setPosicion(int posX, int posY){
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

}
