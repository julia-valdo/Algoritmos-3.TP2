package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.Controlador.Controlador;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoPermitidoError;
import edu.fiuba.algo3.modelo.Excepciones.NoHayFuerzasRestantesError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConfirmacionAtaqueHandle implements HandlerDePais{
    private Jugador jugador;
    private  Pais paisOrigen;
    private Pais paisDestino;
    private TextoNotificable textoDeError;


    public ConfirmacionAtaqueHandle(Jugador jugador, Pais pais, TextoNotificable textoDeError){
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
        return new ConfirmacionAtaqueHandle(this.jugador, this.paisOrigen, this.textoDeError);
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
            this.jugador.atacarPaisDesdeAVisual(this.paisOrigen, this.paisDestino);
            this.evaluarVictoriaDelJugador(mouseEvent);
            Controlador.reestablecerPaises(this.jugador, new BotonAtacarHandle(this.jugador, this.textoDeError));
        } catch (Exception excepcion){
            if(excepcion.getClass() == NullPointerException.class){
                this.textoDeError.setText("Elige un pais tuyo");
            }
            else {
                this.textoDeError.setText(excepcion.getMessage());
                Controlador.reestablecerPaises(this.jugador, new BotonAtacarHandle(this.jugador, this.textoDeError));
            }
            this.mostrarError();
        }
    }

    private void evaluarVictoriaDelJugador(MouseEvent evento) {
       try {
           this.jugador.evaluarVictoria(evento);
       }catch(Exception ignored){
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
