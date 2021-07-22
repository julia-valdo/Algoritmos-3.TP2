package edu.fiuba.algo3.modelo;

public class CanjesUno implements Canjes {
    @Override
    public Canjes realizarCanjeA(Cuartel unCuartel) {
        this.sumarFichasPorCanje(unCuartel);
        return new CanjesDos();
    }

    private void sumarFichasPorCanje(Cuartel unCuartel){
        unCuartel.agregarEjercitos(7);
    }
}
