package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

    private Ejercitos reservas;
    private ArrayList<Pais> paisesOcupados;

    public Jugador(){
        this.reservas = new Ejercitos(10,this);
        this.paisesOcupados = new ArrayList<>();
    }

    /*
    Este metodo hay que cambiarlo cuando se implementen bien los ejercitos
     */
    public void ocupa(Pais unPais){
            Ejercitos nuevaDivision = this.reservas.generarDivision(1);
            unPais.recibirTropas(nuevaDivision);
    }

    public void ocuparCon(Pais unPais, int cantidadFuerzas){
        Ejercitos nuevaDivision = this.reservas.generarDivision(cantidadFuerzas);
        unPais.recibirTropas(nuevaDivision);
    }

    public boolean tieneFuerzasEn(Pais unPais){
        return unPais.estaOcupadoPor(this);
    }

    public void perdisteA(Pais unPais){
        this.paisesOcupados.remove(unPais);
    }

    public void ocupasteA(Pais unPais){
        paisesOcupados.add(unPais);
    }



}
