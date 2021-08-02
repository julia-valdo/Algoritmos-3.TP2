package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Botones.BotonAvanzarTurno;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class VentanaMenuAtacar extends VentanaMenu{

    private Ficha fichaJugador;

    public VentanaMenuAtacar(Ficha fichaAPlasmar){
        this.fichaJugador =fichaAPlasmar;
        this.agregarBotonAvanze();
        this.colocarFicha();
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
