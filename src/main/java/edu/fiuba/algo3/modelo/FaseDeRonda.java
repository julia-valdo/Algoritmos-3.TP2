package edu.fiuba.algo3.modelo;

public interface FaseDeRonda {

    public boolean accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego, SeleccionJugador seleccion);

    public FaseDeRonda cambiarFase();
}
