package edu.fiuba.algo3.modelo;

public class Derrotados implements EstadoEjercitos{

    public Derrotados(){
    }
    @Override
    public EstadoEjercitos evaluarFuerzasRestantes() {
        return this;
    }

    @Override
    public int getCantidadFuerzas() {
        return 0;
    }

    @Override
    public EstadoEjercitos agregarFuerzas(int numeroDeFuerzas) {
        throw new EjercitosDerrotadosError();
    }
    @Override
    public EstadoEjercitos restarFuerzas(int numeroFuerzas) {
        throw new NoHayFuerzasRestantesError();
    }

    @Override
    public boolean estanDerrotados() {
        return true;
    }

    @Override
    public boolean equals(Object otro){
        return otro.getClass() == Derrotados.class;
    }

}
