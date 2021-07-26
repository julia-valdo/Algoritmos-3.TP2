package edu.fiuba.algo3.modelo;

public interface FaseDeRonda {

    public void accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego);

    public FaseDeRonda cambiarFase();
}
