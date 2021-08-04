package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.Controlador.handlers.BotonAgregarEjercitoHandle;
import edu.fiuba.algo3.Controlador.handlers.BotonAtacarHandle;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;
import edu.fiuba.algo3.vista.ventanas.VentanaMenuAtacar;
import javafx.scene.text.Text;

public class FaseAtacar implements FaseDeRonda {
    private Jugador jugadorEnTurno;
    private HandlerDePais handlerGeneral;

    public FaseAtacar(){
        this.jugadorEnTurno = new Jugador(0);
        this.handlerGeneral = new BotonAtacarHandle(this.jugadorEnTurno);
    }

    @Override
    public void aplicarAccionesDeFase(Jugador jugador, InventarioDeJuego inventario) {
        this.jugadorEnTurno = jugador;
        this.handlerGeneral.setJugadorEnTurno(jugador);
        jugador.habilitarPaises(this.handlerGeneral);
    }

    @Override
    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion){
        try{
            jugador.atacarPaisDesdeA(seleccion.getPaisUno(), seleccion.getPaisDos());
        } catch (Exception e){
            return false;
        }
        return true;
    }
    @Override
    public FaseDeRonda cambiarFase(){
        return new FaseReagrupar();
    }

    @Override
    public VentanaMenu prepararMenu() {
        VentanaMenu menuAPreparar = new VentanaMenuAtacar(this.jugadorEnTurno.getFicha());
        Text nombreDelJugador = this.jugadorEnTurno.prepararNombre();
        menuAPreparar.getChildren().add(nombreDelJugador);

        return menuAPreparar;
    }
}