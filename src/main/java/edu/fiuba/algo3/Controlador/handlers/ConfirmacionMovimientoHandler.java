package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoPermitidoError;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoDeEjercitoError;
import edu.fiuba.algo3.modelo.Excepciones.NoHayFuerzasRestantesError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

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
        this.prepararGrupoDeError(mouseEvent);
        try{
            this.jugador.moverFichasDeACon(this.paisOrigen, this.paisDestino,1);
        } catch (Exception excepcion){
            this.manejarErrorDeAtaque(excepcion);
        }
        this.paisOrigen.restablecerLimitrofesParaAtaque();
    }
    private void manejarErrorDeAtaque(Exception excepcion){
        if(excepcion.getClass() == MovimientoDeEjercitoError.class){
            this.textoDeError.setText("Ese Movimiento no esta permitido");
        }
        else {
            this.textoDeError.setText("Selecciona un pais de origen nuevamente");
        }
        this.paisOrigen.restablecerLimitrofesParaAtaque();
    }

    private void desarmarTextoDeError(){
        this.textoDeError.setText("");
    }

    private void prepararGrupoDeError(MouseEvent evento) {
        Group grupoDeEscena = (Group) ((Node) evento.getSource()).getScene().getRoot();
        if (this.textoDeError.noEstaAgregadoA(grupoDeEscena)) {
            this.textoDeError.agregarAGrupo(grupoDeEscena);
        }
    }
}
