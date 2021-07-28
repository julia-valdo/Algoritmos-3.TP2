package edu.fiuba.algo3.modelo.FlujoDeJuego;

import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.modelo.Objetivos.SeleccionJugador;

public class FaseAtacar implements FaseDeRonda {
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
}
