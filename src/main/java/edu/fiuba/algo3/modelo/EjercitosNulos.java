package edu.fiuba.algo3.modelo;

public class EjercitosNulos implements Ocupante{

    @Override
    public boolean estanBajoElMandoDe(Jugador unJugador) {
        return false;
    }

    @Override
    public boolean debenDesocupar(Pais unPais){
        return true;
    }

    @Override
    public void ocupacionExitosaDe(Pais unPais) {

    }
}
