package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.Controlador.Controlador;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.vista.Botones.BotonAvanzarTurno;
import edu.fiuba.algo3.vista.Elementos.BoxCarta;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class VentanaMenuColocacion extends VentanaMenu {
    private Ficha fichaJugador;
    private int x = 1075;
    private int y = 45;


    public VentanaMenuColocacion(Ficha fichaAPlasmar){
        this.fichaJugador =fichaAPlasmar;
        this.setTexto();
        this.agregarBotonAvanze();
        this.colocarFicha();
    }

    private void setTexto(){

        Text fichasRestantes = new TextoNotificable(this.fichaJugador);
        fichasRestantes.setTranslateX(900);
        fichasRestantes.setTranslateY(200);
        this.getChildren().add(fichasRestantes);

        Text fase = new Text("FASE DE COLOCACION");
        fase.setTranslateX(320);
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
        this.fichaJugador.setTranslateX(x);
        this.fichaJugador.setRadius(15);
        this.fichaJugador.setTranslateY(y);
        this.getChildren().add(this.fichaJugador);
    }

}
