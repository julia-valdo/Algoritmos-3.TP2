package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.Controlador.handlers.BotonAgregarEjercitoHandle;
import edu.fiuba.algo3.Controlador.handlers.BoxCartaHandler;
import edu.fiuba.algo3.Controlador.handlers.HandlerDeCarta;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Excepciones.ColocacionEjercitoError;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;
import edu.fiuba.algo3.vista.ventanas.VentanaMenuColocacion;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FaseColocarEjercitos implements FaseDeRonda {
    private Jugador jugadorEnTurno;
    private HandlerDePais handlerGeneral;
    private HandlerDeCarta handlerCarta;
    private TextoNotificable textoDeError;

    public FaseColocarEjercitos(Jugador jugador){
        this.jugadorEnTurno = jugador;
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
        this.handlerCarta = new BoxCartaHandler(this.jugadorEnTurno,textoDeError);
        inventario.habilitarPaises(null, this.handlerGeneral);
        jugador.habilitarCartas(this.handlerCarta);
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
    public FaseDeRonda cambiarFase(Jugador siguiente) {
        return new FaseAtacar(siguiente);
    }

    @Override
    public VentanaMenu prepararMenu() {
        VentanaMenu menuAPreparar = new VentanaMenuColocacion(this.jugadorEnTurno.getFicha());
        Button boton = this.jugadorEnTurno.botonMostrarCarta();
        boton.setTranslateX(920);
        boton.setTranslateY(550);
        menuAPreparar.getChildren().add(boton);
        Text nombreDelJugador = this.jugadorEnTurno.prepararNombre();
        this.agregarBotonObjetivo(menuAPreparar);
        menuAPreparar.getChildren().add(nombreDelJugador);

        return menuAPreparar;

    }

    @Override
    public boolean puedoPasar() {
        if(!this.jugadorEnTurno.quedanFichas()) return true;
        else throw new ColocacionEjercitoError("Aun quedan fichas por colocar");
    }

    private void agregarBotonObjetivo(VentanaMenu menu){
        Node botonObjetivo = this.jugadorEnTurno.prepararObjetivo();
        botonObjetivo.setTranslateX(905);
        botonObjetivo.setTranslateY(70);
        menu.getChildren().add(botonObjetivo);
    }
}
