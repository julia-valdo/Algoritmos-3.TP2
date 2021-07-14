package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

    private Ejercitos reservas;
    private ArrayList<Pais> paisesOcupados;

    public Jugador(){
        this.reservas = new Ejercitos(10,this);
        this.paisesOcupados = new ArrayList<>();
    }

    public void ocupa(Pais unPais){ this.ocuparCon(unPais, 1); }

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
