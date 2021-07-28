package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.Cartas.Canjes;

public class CanjesMasDeTres implements Canjes {
    private final int cantidadFichasPorCanje = 5;
    private final int cantidadFichasMasDeTres = 10;
    private int fichasPorCanje;

    public CanjesMasDeTres(){
        this.fichasPorCanje = cantidadFichasMasDeTres;
    }

    @Override
    public int realizarCanje() {
        return this.fichasPorCanje;
    }

    @Override
    public Canjes obtenerProximoCanje() {
        this.fichasPorCanje += cantidadFichasPorCanje;
        return this;
    }
}
