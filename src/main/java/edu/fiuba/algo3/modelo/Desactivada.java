package edu.fiuba.algo3.modelo;

public class Desactivada implements EstadoDeActivacion{

    @Override
    public EstadoDeActivacion activarseEn(Pais unPais) {
        unPais.agregarEjercito(2);
        return new Activada();
    }

}
