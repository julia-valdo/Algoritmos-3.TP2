package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Botones.BotonAvanzarTurno;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class VentanaMenuColocacion extends VentanaMenu{

    private Ficha fichaJugador;

    public VentanaMenuColocacion(Ficha fichaAPlasmar){
        this.fichaJugador =fichaAPlasmar;
        this.setTexto();
        this.agregarBotonAvanze();
        this.colocarFicha();
    }
    private void setTexto(){
        Text fichasRestantes = new TextoNotificable(this.fichaJugador);

        fichasRestantes.setTranslateX(900);
        fichasRestantes.setTranslateY(280);
        this.getChildren().add(fichasRestantes);
    }

    private void agregarBotonAvanze(){
        Button avanze = new BotonAvanzarTurno();

        this.getChildren().add(avanze);
    }
    private void colocarFicha(){
        this.fichaJugador.setTranslateX(1075);
        this.fichaJugador.setRadius(15);
        this.fichaJugador.setTranslateY(45);
        this.getChildren().add(this.fichaJugador);
    }

}
