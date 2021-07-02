package edu.fiuba.algo3.PrimeraIteracion;

import java.util.ArrayList;

public class Dado {
    ArrayList<Integer> tiradas;
    int cantidadTiradas;

    public Dado(int cantidadTiradas){
        tiradas = new ArrayList<>();
        this.cantidadTiradas = cantidadTiradas;
    }

    public void tiradasGanadoras(){
        for (int i = 0; i < cantidadTiradas; i++){
            tiradas.add(6);
        }
    }

    public void tiradasPerdedoras(){
        for (int i = 0; i < cantidadTiradas; i++){
            tiradas.add(1);
        }
    }

    public int cantidadPerdidas(Dado otroDado){
        ArrayList<Integer> otraTirada = otroDado.getTiradas();
        int cantidadTiradasContraria = otroDado.getCantidadTiradas();
        int cantidad = 0;
        for(int i = 0; i < cantidadTiradas && i < cantidadTiradasContraria; i++){
            if(this.tiradas.get(i) < otraTirada.get(i)) cantidad++;
        }

        return cantidad;
    }

    private int getCantidadTiradas() {
        return cantidadTiradas;
    }

    private ArrayList<Integer> getTiradas() {
        return this.tiradas;
    }
}
