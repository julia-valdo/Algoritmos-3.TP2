package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.Cartas.Canjes;
import edu.fiuba.algo3.modelo.Cartas.CanjesMasDeTres;

public class CanjesMenosDeTres implements Canjes {
    private final int cantidadFichasMenosDeTres = 4;
    private final int cantidadFichasPorCanje = 3;
    private final int cantidadMaximaFichas = 10;
    private int fichasPorCanje;

    public CanjesMenosDeTres(){
        fichasPorCanje = cantidadFichasMenosDeTres;
    }

    @Override
    public int realizarCanje() {
        return this.fichasPorCanje;
    }

    @Override
    public Canjes obtenerProximoCanje() {
        fichasPorCanje += cantidadFichasPorCanje;
        if(fichasPorCanje >= cantidadMaximaFichas ){
            return new CanjesMasDeTres();
        }
        return this;
    }
}
