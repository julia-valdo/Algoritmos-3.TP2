package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import javafx.scene.input.MouseEvent;

public class ConfirmacionHandle implements HandlerDePais{
    private Jugador jugador;
    private  Pais paisOrigen;
    private Pais paisDestino;

    public ConfirmacionHandle(Jugador jugador, Pais pais){
        this.jugador = jugador;
        this.paisOrigen = pais;
    }

    @Override
    public void asociarPais(Pais unPais) {
        this.paisDestino = unPais;
    }

    @Override
    public HandlerDePais getCopy() {
        return new ConfirmacionHandle(this.jugador, this.paisOrigen);
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
        try{
            if(this.paisDestino != null) this.jugador.atacarPaisDesdeA(this.paisOrigen, this.paisDestino);
            else System.out.println("No es limitrofe");
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
