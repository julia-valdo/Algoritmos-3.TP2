package edu.fiuba.algo3.modelo;

public class FaseAtacar implements FaseDeRonda{
    @Override
    public void accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego){
        return;
    }
    @Override
    public FaseDeRonda cambiarFase(){
        return new FaseReagrupar();
    }
}
