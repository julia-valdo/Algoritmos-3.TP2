package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Botones.BotonAvanzarTurno;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VentanaMenuReagrupar extends VentanaMenu{
    private Ficha fichaJugador;

    public VentanaMenuReagrupar(Ficha fichaAPlasmar){
        this.fichaJugador = fichaAPlasmar;
        this.setTexto();
        this.agregarBotonAvanze();
        this.colocarFicha();
    }

    private void setTexto(){
        Text fase = new Text("FASE DE REAGRUPACION");
        fase.setTranslateX(300);
        fase.setTranslateY(100);
        fase.setFont(Font.font("times new roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        fase.setFill(Color.BLACK);
        this.getChildren().add(fase);
   }

    private void agregarBotonAvanze(){
        Button avanze = new BotonAvanzarTurno();

        this.getChildren().add(avanze);
    }
    private void colocarFicha() {
        this.fichaJugador.setTranslateX(1075);
        this.fichaJugador.setRadius(15);
        this.fichaJugador.setTranslateY(45);
        this.getChildren().add(this.fichaJugador);
    }
}
