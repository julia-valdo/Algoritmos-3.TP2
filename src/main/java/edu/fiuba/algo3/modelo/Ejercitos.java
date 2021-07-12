package edu.fiuba.algo3.modelo;

public interface Ejercitos {

    boolean estanBajoElMandoDe(Jugador unJugador);

    Ejercitos disputarDominioDe(Pais unPais, Ejercitos otrasFuerzas);

    void ocupacionExitosaDe(Pais unPais);

    Ejercitos evaluarFuerzasRestantes();

}
