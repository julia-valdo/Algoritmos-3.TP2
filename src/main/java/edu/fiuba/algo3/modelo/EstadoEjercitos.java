package edu.fiuba.algo3.modelo;

public interface EstadoEjercitos {


    boolean estanBajoElMandoDe(Jugador unJugador);


    EstadoEjercitos disputarDominioDe(Pais unPais, EstadoEjercitos otrasFuerzas);

    void ocupacionExitosaDe(Pais unPais);

    EstadoEjercitos evaluarFuerzasRestantes();

}
