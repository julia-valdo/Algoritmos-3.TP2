package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.Controlador.handlers.BotonAgregarEjercitoHandle;
import edu.fiuba.algo3.Controlador.handlers.EsePaisNoEsTuyoHandler;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;
import edu.fiuba.algo3.vista.ventanas.VentanaMenuColocacion;
import javafx.scene.text.Text;

public class FasePrimeraColocacion implements FaseDeRonda{
    private final int fichasAAgregar = 5;
    private Jugador jugadorEnTurno;
    private HandlerDePais handlerGeneral;
    private TextoNotificable textoDeError;

    public FasePrimeraColocacion(TextoNotificable textoDeError){
        this.jugadorEnTurno = new Jugador(0);
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
        jugador.habilitarPaises(this.handlerGeneral);
    }

    @Override
    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion) {

        jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno());

        return true;
    }

    @Override
    public FaseDeRonda cambiarFase() {
        return new FaseSegundaColocacion(this.textoDeError);
    }

    @Override
    public VentanaMenu prepararMenu() {
        VentanaMenu menuAPreparar = new VentanaMenuColocacion(this.jugadorEnTurno.getFicha());
        Text nombreDelJugador = this.jugadorEnTurno.prepararNombre();
        menuAPreparar.getChildren().add(nombreDelJugador);

        return menuAPreparar;

    }
}
