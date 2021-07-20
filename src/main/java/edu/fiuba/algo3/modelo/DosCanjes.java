package edu.fiuba.algo3.modelo;

public class DosCanjes implements Canjes {
    @Override
    public Canjes actualizarCantidadDeCanjes() {
        return new MasDeTresCanjes();
    }

    @Override
    public int realizarCanje() {
        return 10;
    }
}
