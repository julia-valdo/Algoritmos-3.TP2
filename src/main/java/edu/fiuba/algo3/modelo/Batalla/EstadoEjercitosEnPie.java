package edu.fiuba.algo3.modelo.Batalla;

import edu.fiuba.algo3.modelo.Excepciones.NoHayFuerzasRestantesError;

public class EstadoEjercitosEnPie implements EstadoEjercitos {

    private int numeroDeFuerzas;

    public EstadoEjercitosEnPie(int fuerzasIniciales){
        this.numeroDeFuerzas = fuerzasIniciales;

    }

    public EstadoEjercitos evaluarFuerzasRestantes(){
        return numeroDeFuerzas <= 0 ? new EstadoEjercitosDerrotados(): this;
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
            throw new NoHayFuerzasRestantesError();
        }
        this.numeroDeFuerzas -= numeroFuerzas;

        return this.evaluarFuerzasRestantes();
    }

    @Override
    public boolean estanDerrotados() {
        return false;
    }

    @Override
    public boolean equals(Object otro){
        if(otro == this) return true;
        else if (otro == null || otro.getClass() != EstadoEjercitosEnPie.class) return false;
        EstadoEjercitosEnPie otroEnPie = (EstadoEjercitosEnPie) otro;

        return otroEnPie.numeroDeFuerzas == this.numeroDeFuerzas;
    }

}
