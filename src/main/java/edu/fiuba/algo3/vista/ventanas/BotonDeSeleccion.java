package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.handlers.CantidadDeJugadoresHandle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class BotonDeSeleccion extends Button {

    public BotonDeSeleccion(int numeroBoton){
        super();
        this.addEventHandler(ActionEvent.ACTION, new CantidadDeJugadoresHandle(numeroBoton));
        this.posicionar(numeroBoton);
        this.crearTexto(numeroBoton);
    }

    private void crearTexto(Integer numeroBoton) {
        this.setText(numeroBoton.toString());

    }

    private void posicionar(int numeroBoton) {
        this.setTranslateX(730 + 10 * (numeroBoton - 2));
        this.setTranslateY(300);
    }


}
