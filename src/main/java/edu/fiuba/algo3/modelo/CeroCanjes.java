package edu.fiuba.algo3.modelo;

public class CeroCanjes implements Canjes{
    @Override
    public Canjes actualizarCantidadDeCanjes() {
        return new UnCanje();
    }

    @Override
    public int realizarCanje() {
        return 4;
    }
}
