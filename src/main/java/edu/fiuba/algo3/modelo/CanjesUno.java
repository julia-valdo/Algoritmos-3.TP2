package edu.fiuba.algo3.modelo;

public class CanjesUno implements Canjes {
    @Override
    public Canjes actualizarCantidadDeCanjes() {
        return new CanjesDos();
    }

    @Override
    public int realizarCanje() {
        return 7;
    }
}
