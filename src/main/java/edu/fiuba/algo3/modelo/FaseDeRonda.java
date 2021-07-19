package edu.fiuba.algo3.modelo;

public interface FaseDeRonda {

    public void accionJugador(Jugador jugador, Banco banco);

    public FaseDeRonda cambiarFase();
}
