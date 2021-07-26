package edu.fiuba.algo3.modelo;

public class FaseReagrupar implements FaseDeRonda {
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
    public FaseDeRonda cambiarFase(){
        return new FaseColocarEjercitos();
    }
}
