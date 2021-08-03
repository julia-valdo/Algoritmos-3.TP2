package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class BotonAtacarHandle implements HandlerDePais {
    private Jugador jugador;
    private Pais pais;
    private Pais paisDestino;

    public BotonAtacarHandle(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public void asociarPais(Pais unPais) {
        this.pais = unPais;
    }

    @Override
    public HandlerDePais getCopy() {
        return new BotonAtacarHandle(this.jugador);
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
        this.prepararGrupoDeError(mouseEvent);
        this.pais.habilitarLimitrofes(new ConfirmacionHandle(this.jugador, this.pais));
    }

//    private void desarmarTextoDeError() {
//        this.textoDeError.setText("");
//    }

    private void generarTextoDeError(RuntimeException exception){

        if(NullPointerException.class == exception.getClass()){
//            this.textoDeError.setText("Ese pais no es tuyo: " + this.pais.getNombreDelPais());
            System.out.println("Ese pais no es tuyo: " + this.pais.getNombreDelPais());
        }
        else{
//            this.textoDeError.setText("No tenes mas fichas!");
            System.out.println("No tenes mas fichas!");
        }
    }

    private void prepararGrupoDeError(MouseEvent evento){
        Group grupoDeEscena  = (Group) ((Node) evento.getSource()).getScene().getRoot();
//        if(this.textoDeError.noEstaAgregadoA(grupoDeEscena)){
//            this.textoDeError.agregarAGrupo(grupoDeEscena);
//        }
    }
}
