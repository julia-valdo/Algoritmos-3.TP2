package edu.fiuba.algo3.modelo;

public class CanjesMasDeTres implements Canjes {
    private int canjesRealizados;

    public CanjesMasDeTres(){
        this.canjesRealizados = 3;
    }


    @Override
    public Canjes actualizarCantidadDeCanjes() {
        return this;
    }

    @Override
    public int realizarCanje() {
        this.canjesRealizados++;
        return (this.canjesRealizados - 1) * 5;
    }
}
