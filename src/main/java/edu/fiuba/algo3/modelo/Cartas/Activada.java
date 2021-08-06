package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.Batalla.Pais;

public class Activada implements EstadoDeActivacion {
    @Override
    public EstadoDeActivacion activarseEn(Pais unPais) {
        return this;
    }

    @Override
    public boolean estaActivada() {
        return true;
    }
}
