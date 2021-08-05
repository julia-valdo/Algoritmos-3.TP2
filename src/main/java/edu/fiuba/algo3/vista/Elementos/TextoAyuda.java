package edu.fiuba.algo3.vista.Elementos;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextoAyuda extends Text {
    public TextoAyuda(){
        super("El juego consiste en...");
        super.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        super.setFill(Color.BLACK);
    }
}