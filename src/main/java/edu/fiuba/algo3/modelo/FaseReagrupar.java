package edu.fiuba.algo3.modelo;

public class FaseReagrupar implements FaseDeRonda {
    @Override
    public void accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego){
        return;
    }
    @Override
    public FaseDeRonda cambiarFase(){
        return new FaseColocarEjercitos();
    }
}
