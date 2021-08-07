package edu.fiuba.algo3.vista.Elementos;

import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class TextoComoJugar extends Text {

    public TextoComoJugar(){
        super("\nPara colocar una ficha, cliquea en el pais en el que desees colocarla,\n" +
                "solo podras colocar una ficha en un pais de tu mismo color.\n\n" +
                "Para utilizar una carta, primero tendras que activarla haciendo click derecho\n" +
                "para luego poder canjearla haciendo click izquierdo.\n\n" +
                "Solo podras atacar paises limitrofes al seleccionado.\n\n" +
                "Solo podras reagrupar ejercitos entre paises limitrofes.\n\n" +
                "Para mas detalles, ver la pestaña Ayuda.\n");

        super.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 15));
        super.setTextAlignment(TextAlignment.JUSTIFY);
        super.setFill(Color.BLACK);
    }
}
