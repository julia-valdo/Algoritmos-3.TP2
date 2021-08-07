package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.Controlador.Controlador;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Excepciones.ColocacionEjercitoError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.concurrent.ExecutionException;

public class BotonAgregarEjercitoHandle implements HandlerDePais {

    private Jugador jugador;
    private Pais pais;
    private TextoNotificable textoDeError;

    public BotonAgregarEjercitoHandle(Jugador jugador, TextoNotificable errorAReportar){
        this.textoDeError = errorAReportar;
        this.jugador = jugador;
    }

    @Override
    public void asociarPais(Pais unPais) {
        this.pais = unPais;
    }

    @Override
    public HandlerDePais getCopy() {
        return new BotonAgregarEjercitoHandle(this.jugador, this.textoDeError);
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
        try {
            this.jugador.agregarFichasA(1, this.pais);
            Controlador.habilitarPaisesParaColocacion(new BotonAgregarEjercitoHandle(this.jugador, this.textoDeError));
        }catch (Exception exception){
            this.generarTextoDeError(exception);
            this.mostrarError();
        }
    }

    private void desarmarTextoDeError() {
        this.textoDeError.setText("");
    }

    private void generarTextoDeError(Exception exception){

        if(ColocacionEjercitoError.class == exception.getClass()){
            this.textoDeError.setText("Ese pais no es tuyo: " + this.pais.getNombreDelPais());
        }
        else{
            this.textoDeError.setText("No tenes mas fichas!");
        }
    }

    private void mostrarError(){
        VentanaDePapel ventana = new VentanaDePapel(textoDeError);
        ventana.prepararFondo(200,300);

        Scene scena = new Scene(ventana);
        Stage popUpDeCarta = new Stage();


        popUpDeCarta.setScene(scena);
        popUpDeCarta.show();
    }

}
