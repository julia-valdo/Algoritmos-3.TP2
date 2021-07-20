package edu.fiuba.algo3.modelo;

public class UnCanje implements Canjes {
    @Override
    public Canjes actualizarCantidadDeCanjes() {
        return new DosCanjes();
    }

    @Override
    public int realizarCanje() {
        return 7;
    }
}
