package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.Controlador.SeleccionJugador;

public class FaseColocarEjercitos implements FaseDeRonda {
    private boolean ejercitoFueIncrementado;

    public FaseColocarEjercitos(){
        ejercitoFueIncrementado = false;
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
}
