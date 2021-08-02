package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;

public class FaseColocarEjercitos implements FaseDeRonda {
    private boolean ejercitoFueIncrementado;

    @Override
    public void aplicarAccionesDeFase(Jugador jugador, InventarioDeJuego inventario) {
        jugador.agregarFichas(jugador.cantidadDeEjercitosAColocar(inventario));
        jugador.pedirCarta(inventario);
    }

    @Override
    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion) {
        if(!ejercitoFueIncrementado) this.incrementarEjercito(jugador, inventarioDeJuego);
        try{
            jugador.agregarFichasA(seleccion.getCantidad(), seleccion.getPaisUno());
        } catch (Exception e){
            return false;
        }
        return true;
    }

    private void incrementarEjercito(Jugador jugador, InventarioDeJuego inventarioDeJuego){
        int cantidadFichas = jugador.cantidadDeEjercitosAColocar(inventarioDeJuego);
        jugador.agregarFichas(cantidadFichas);
        ejercitoFueIncrementado = true;
    }


    @Override
    public FaseDeRonda cambiarFase() {
        return new FaseAtacar();
    }

    @Override
    public VentanaMenu prepararMenu() {
        return null;
    }
}
