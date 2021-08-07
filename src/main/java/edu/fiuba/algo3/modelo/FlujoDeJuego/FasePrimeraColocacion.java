package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.Controlador.Controlador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.Controlador.handlers.BotonAgregarEjercitoHandle;
import edu.fiuba.algo3.Controlador.handlers.EsePaisNoEsTuyoHandler;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;
import edu.fiuba.algo3.vista.ventanas.VentanaMenuColocacion;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class FasePrimeraColocacion implements FaseDeRonda{
    private final int fichasAAgregar = 5;
    private Jugador jugadorEnTurno;
    private HandlerDePais handlerGeneral;
    private TextoNotificable textoDeError;

    public FasePrimeraColocacion(Jugador jugador, TextoNotificable textoDeError){
        this.jugadorEnTurno = jugador;
        this.textoDeError = textoDeError;
        this.textoDeError.setPosicion(900, 550);
        this.handlerGeneral = new BotonAgregarEjercitoHandle(this.jugadorEnTurno, textoDeError);
    }

    @Override
    public void aplicarAccionesDeFase(Jugador jugador, InventarioDeJuego inventario) {

        inventario.setHandlerError(new EsePaisNoEsTuyoHandler(this.textoDeError));
        this.jugadorEnTurno = jugador;
        jugador.agregarFichas(this.fichasAAgregar);
        this.handlerGeneral.setJugadorEnTurno(jugador);
        inventario.habilitarPaises(null, this.handlerGeneral);
    }


    @Override
    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion) {

        jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno());

        return true;
    }

    @Override
    public FaseDeRonda cambiarFase(Jugador siguiente) {
        return new FaseSegundaColocacion(siguiente, this.textoDeError);
    }

    @Override
    public VentanaMenu prepararMenu() {
        VentanaMenu menuAPreparar = new VentanaMenuColocacion(this.jugadorEnTurno.getFicha());
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
}
