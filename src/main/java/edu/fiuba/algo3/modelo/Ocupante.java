package edu.fiuba.algo3.modelo;

public interface Ocupante {

    boolean estanBajoElMandoDe(Jugador unJugador);

    boolean debenDesocupar(Pais unPais);

    void ocupacionExitosaDe(Pais unPais);

}
