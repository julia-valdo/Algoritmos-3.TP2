package edu.fiuba.algo3.modelo;

public class CanjesCero implements Canjes{
    @Override
    public Canjes actualizarCantidadDeCanjes() {
        return new CanjesUno();
    }

    @Override
    public int realizarCanje() {
        return 4;
    }
}
