package edu.fiuba.algo3.modelo;

public class CanjesCero implements Canjes{


    @Override
    public Canjes realizarCanjeA(Cuartel unCuartel) {
        this.sumarFichasPorCanje(unCuartel);
        return new CanjesUno();
    }


    private void sumarFichasPorCanje(Cuartel unCuatel) {
        unCuatel.agregarEjercitos(4);
    }

}
