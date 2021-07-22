package edu.fiuba.algo3.modelo;

public class CanjesDos implements Canjes {


    @Override
    public Canjes realizarCanjeA(Cuartel unCuartel) {
        this.sumarFichasPorCanje(unCuartel);
        return new CanjesMasDeTres();
    }

    private void sumarFichasPorCanje(Cuartel unCuartel){
        unCuartel.agregarEjercitos(10);
    }
}
