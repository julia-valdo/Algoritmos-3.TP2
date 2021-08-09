package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.Controlador.handlers.BotonMoverHandle;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;
import edu.fiuba.algo3.vista.ventanas.VentanaMenuReagrupar;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class FaseReagrupar implements FaseDeRonda {
    private TextoNotificable textoDeError;
    private Jugador jugadorEnTurno;
    private HandlerDePais handlerGeneral;

    public FaseReagrupar(Jugador jugador){
        this.jugadorEnTurno = jugador;
        this.textoDeError = this.prepararTextoDeError();
        this.handlerGeneral = new BotonMoverHandle(this.jugadorEnTurno, this.textoDeError);
    }

    private TextoNotificable prepararTextoDeError() {
        TextoNotificable textoDeError = new TextoNotificable();
        textoDeError.setPosicion(870, 550);
        return textoDeError;
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
            jugador.moverFichasDeACon(seleccion.getPaisUno(), seleccion.getPaisDos(), seleccion.getCantidad());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Override
    public FaseDeRonda cambiarFase(Jugador siguiente){
        return new FaseColocarEjercitos(siguiente);
    }

    @Override
    public VentanaMenu prepararMenu() {
        VentanaMenu menuAPreparar = new VentanaMenuReagrupar(this.jugadorEnTurno.getFicha());
        Text nombreDelJugador = this.jugadorEnTurno.prepararNombre();
        this.agregarBotonObjetivo(menuAPreparar);
        menuAPreparar.getChildren().add(nombreDelJugador);

        return menuAPreparar;
    }

    private void agregarBotonObjetivo(VentanaMenu menu){
        Node botonObjetivo = this.jugadorEnTurno.prepararObjetivo();
        botonObjetivo.setTranslateX(905);
        botonObjetivo.setTranslateY(70);
        menu.getChildren().add(botonObjetivo);
    }

    @Override
    public boolean puedoPasar() {
        return true;
    }


}
