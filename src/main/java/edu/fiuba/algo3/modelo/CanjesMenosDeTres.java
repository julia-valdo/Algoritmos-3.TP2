package edu.fiuba.algo3.modelo;

public class CanjesMenosDeTres implements Canjes{

    private int fichasPorCanje;

    public CanjesMenosDeTres(){
        fichasPorCanje = 4;
    }

    @Override
    public int realizarCanje() {
        return this.fichasPorCanje;
    }

    @Override
    public Canjes obtenerProximoCanje() {
        fichasPorCanje += 3;
        if(fichasPorCanje >= 10 ){
            return new CanjesMasDeTres();
        }
        return this;
    }
}
