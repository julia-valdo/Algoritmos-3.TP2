package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.Batalla.Pais;

public class Desactivada implements EstadoDeActivacion {

    private final int cantidadDeEjercitos = 2;
    @Override
    public EstadoDeActivacion activarseEn(Pais unPais) {
        unPais.agregarEjercito(cantidadDeEjercitos);
        return new Activada();
    }

}
