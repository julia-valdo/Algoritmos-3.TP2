package edu.fiuba.algo3.modelo.Batalla;

public interface EstadoEjercitos {


    EstadoEjercitos evaluarFuerzasRestantes();

    int getCantidadFuerzas();

    EstadoEjercitos agregarFuerzas(int numeroDeFuerzas);

    EstadoEjercitos restarFuerzas(int numeroFuerzas);

    boolean estanDerrotados();

}
