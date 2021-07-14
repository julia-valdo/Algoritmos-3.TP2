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
        return new EnPie(numeroDeFuerzas);
    }

    @Override
    public EstadoEjercitos restarFuerzas(int numeroFuerzas) {
        throw new NoHayFuerzasRestantes();
    }

    @Override
    public boolean estanDerrotados() {
        return true;
    }

    @Override
    public boolean hayFuerzasParaUnaDivisionDe(int numeroFuerzas) {
        return false;
    }
}
