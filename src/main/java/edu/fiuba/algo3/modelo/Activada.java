package edu.fiuba.algo3.modelo;

public class Activada implements EstadoDeActivacion{
    @Override
    public EstadoDeActivacion activarseEn(Pais unPais) {
        return this;
    }
}
