package edu.fiuba.algo3.modelo;

public class EnPie implements EstadoEjercitos{

    private int numeroDeFuerzas;

    public EnPie(int fuerzasIniciales){
        this.numeroDeFuerzas = fuerzasIniciales;

    }

    public EstadoEjercitos evaluarFuerzasRestantes(){
        return numeroDeFuerzas <= 0 ? new Derrotados() : this;
    }

    @Override
    public int getCantidadFuerzas() {
        return this.numeroDeFuerzas;
    }

    @Override
    public EstadoEjercitos agregarFuerzas(int numeroDeFuerzas) {
        this.numeroDeFuerzas += numeroDeFuerzas;
        return this;
    }

    @Override
    public EstadoEjercitos restarFuerzas(int numeroFuerzas) {
        if(this.numeroDeFuerzas < numeroFuerzas){
            throw new NoHayFuerzasRestantes();
        }
        this.numeroDeFuerzas -= numeroFuerzas;

        return this.evaluarFuerzasRestantes();
    }

    @Override
    public boolean estanDerrotados() {
        return false;
    }

    @Override
    public boolean hayFuerzasParaUnaDivisionDe(int numeroFuerzas) {
        return this.numeroDeFuerzas >= numeroFuerzas;
    }

}
