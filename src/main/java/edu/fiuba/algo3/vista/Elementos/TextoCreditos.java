package edu.fiuba.algo3.vista.Elementos;

import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class TextoCreditos  extends Text {

    public TextoCreditos(){
        super("\nHecho Por:\n\n" +
                "Leonel Fernandez\n" +
                "Axel Higa\n" +
                "Francisco Pereira\n" +
                "Julia Valdovinos\n" +
                "Lucia Valdovinos\n\n" +
                "Para la materia Algoritmos y Programacion 3 catedra Suarez,\n"+
                "de la Facultad de Ingenieria de la Universidad de Buenos Aires.\n");

        super.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 15));
        super.setTextAlignment(TextAlignment.JUSTIFY);
        super.setFill(Color.BLACK);
    }
}
