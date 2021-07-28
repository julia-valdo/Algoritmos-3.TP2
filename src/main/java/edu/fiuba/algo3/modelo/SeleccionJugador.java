package edu.fiuba.algo3.modelo;

public class SeleccionJugador {
    Pais paisUno;
    Pais paisDos;
    int cantidad;

    public SeleccionJugador (Pais uno, Pais dos, int cantidad){
        paisUno = uno;
        paisDos = dos;
        this.cantidad = cantidad;
    }

    public Pais getPaisUno() {
        return paisUno;
    }

    public Pais getPaisDos() {
        return paisDos;
    }

    public int getCantidad() {
        return cantidad;
    }
}
