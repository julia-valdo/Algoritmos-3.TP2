package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.Controlador.handlers.BotonAgregarEjercitoHandle;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;
import edu.fiuba.algo3.vista.ventanas.VentanaMenuColocacion;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class FaseColocarEjercitos implements FaseDeRonda {
    private Jugador jugadorEnTurno;
    private HandlerDePais handlerGeneral;
    private TextoNotificable textoDeError;

    public FaseColocarEjercitos(){
        this.jugadorEnTurno = new Jugador(0);
        this.textoDeError = new TextoNotificable();
        this.textoDeError.setPosicion(900, 550);
        this.handlerGeneral = new BotonAgregarEjercitoHandle(this.jugadorEnTurno, textoDeError);
    }

    @Override
    public void aplicarAccionesDeFase(Jugador jugador, InventarioDeJuego inventario) {
        jugador.pedirCarta(inventario);
        this.jugadorEnTurno = jugador;
        jugador.cantidadDeEjercitosAColocar(inventario);
        this.handlerGeneral.setJugadorEnTurno(jugador);
        jugador.habilitarPaises(this.handlerGeneral);
    }

    @Override
    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion) {
        try{
            jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno());
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public FaseDeRonda cambiarFase() {
        return new FaseAtacar();
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
