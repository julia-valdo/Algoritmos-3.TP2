package edu.fiuba.algo3.vista.Elementos;

import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class TextoAyuda extends Text {
    public TextoAyuda(){
        super("\nEl juego propone un conflicto bélico que tiene lugar sobre un mapa-tablero dividido\n" +
                "en 50 países. Para empezar se reparten los 50 países entre los jugadores, quienes\n" +
                "ocupan sus dominios con fichas (ejércitos).\n\n" +
                "Cada jugador tiene un OBJETIVO SECRETO a cumplir, que se le asigna por azar y\n" +
                "que el resto de los jugadores desconoce. Para cumplir con su objetivo (ocupar\n" +
                "cierta cantidad de países o destruir otros bandos) el jugador deberá ampliar\n" +
                "sus dominios y reordenar sus fuerzas, lo que exigirá emprender ataques y\n" +
                "defenderse de ataques adversarios; agrupar y desplazar ejércitos; concertar\n" +
                "pactos con otros contendientes.\n\n" +
                "La conquista de nuevos territorios le permitirá aumentar el número de ejércitos\n" +
                "a su disposición, otorgándole mayores chances para triunfar en los combates.\n\n" +
                "Si el jugador posee una tarjeta de país aún no activada de un país que controla\n" +
                "puede activarla, lo cual le brinda dos ejércitos adicionales en dicho país.\n" +
                "Estas tarjetas pueden activarse una sola vez, a menos que sean devueltas a\n" +
                "través de un canje.\n" +
                "Asimismo, si un jugador posee tres tarjetas de país con el mismo símbolo o tres\n" +
                "símbolos distintos puede solicitar un canje según:\n\n" +
                "1° canje:              4 ejercitos\n" +
                "2° canje:              7 ejercitos\n" +
                "3° canje:              10 ejercitos\n" +
                "4° canje:              15 ejercitos\n" +
                "n-esimo° canje:  (n-1) * 5 ejercitos\n\n" +
                "Luego del canje las tarjetas vuelven a estar desactivadas.\n");

        super.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 15));
        super.setTextAlignment(TextAlignment.JUSTIFY);
        super.setFill(Color.BLACK);
    }
}