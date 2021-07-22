package edu.fiuba.algo3.modelo;

public class CanjesMasDeTres implements Canjes {
    private int canjesRealizados;

    public CanjesMasDeTres(){
        this.canjesRealizados = 3;
    }

    @Override
    public Canjes realizarCanjeA(Cuartel unCuartel) {
        this.actualizarNumeroDeCanjes();
        this.sumarFichasPorCanje(unCuartel);
        return this;
    }

    private void sumarFichasPorCanje(Cuartel unCuartel){
        int cantidadDeFichasPorCanje = (this.canjesRealizados - 1) * 5;
        unCuartel.agregarEjercitos(cantidadDeFichasPorCanje);
    }

    private void actualizarNumeroDeCanjes(){
        this.canjesRealizados++;
    }
}
