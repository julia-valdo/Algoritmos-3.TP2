package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.Controlador.Controlador;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoPermitidoError;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoDeEjercitoError;
import edu.fiuba.algo3.modelo.Excepciones.NoHayFuerzasRestantesError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class ConfirmacionMovimientoHandler implements HandlerDePais{
    private Jugador jugador;
    private  Pais paisOrigen;
    private Pais paisDestino;
    private TextoNotificable textoDeError;

    public ConfirmacionMovimientoHandler(Jugador jugador, Pais pais, TextoNotificable textoDeError){
        this.jugador = jugador;
        this.paisOrigen = pais;
        this.textoDeError = textoDeError;
    }

    @Override
    public void asociarPais(Pais unPais) {
        this.paisDestino = unPais;
    }

    @Override
    public HandlerDePais getCopy() {
        return new ConfirmacionMovimientoHandler(this.jugador, this.paisOrigen, this.textoDeError);
    }

    @Override
    public void desarmarHandler() {
        this.jugador = null;
    }

    @Override
    public void setJugadorEnTurno(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.desarmarTextoDeError();
        try{
            this.jugador.moverFichasDeACon(this.paisOrigen, this.paisDestino,1);
            Controlador.reestablecerPaises(this.jugador, new BotonMoverHandle(this.jugador, this.textoDeError));
        } catch (Exception excepcion){
            if(excepcion.getClass() == MovimientoDeEjercitoError.class){
                this.textoDeError.setText(excepcion.getMessage());
                Controlador.reestablecerPaises(this.jugador, new BotonMoverHandle(this.jugador, this.textoDeError));
            }
            else {
                this.textoDeError.setText("Elige un pais tuyo");
            }
            this.mostrarError();
        }
    }

    private void desarmarTextoDeError(){
        this.textoDeError.setText("");
    }


    private void mostrarError(){
        VentanaDePapel ventana = new VentanaDePapel(textoDeError);
        ventana.prepararFondo(200,500);

        Scene scena = new Scene(ventana);
        Stage popUpDeCarta = new Stage();


        popUpDeCarta.setScene(scena);
        popUpDeCarta.show();
    }
}
