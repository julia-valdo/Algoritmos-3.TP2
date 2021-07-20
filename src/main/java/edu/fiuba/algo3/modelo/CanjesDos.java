package edu.fiuba.algo3.modelo;

public class CanjesDos implements Canjes {
    @Override
    public Canjes actualizarCantidadDeCanjes() {
        return new CanjesMasDeTres();
    }

    @Override
    public int realizarCanje() {
        return 10;
    }
}
