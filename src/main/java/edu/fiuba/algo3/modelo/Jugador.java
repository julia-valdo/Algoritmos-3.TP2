package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

    private EstadoEjercitos reservas;
    private ArrayList<Pais> paisesOcupados;

    public Jugador(int numeroDeFuerzas){
        this.reservas = new EnPie(numeroDeFuerzas, this);
        this.paisesOcupados = new ArrayList<>();
    }

    public Jugador(){
        this.reservas = new Derrotados(this);
        this.paisesOcupados = new ArrayList<>();
    }

    /*
    Este metodo hay que cambiarlo cuando se implementen bien los ejercitos
     */
    public void ocupa(Pais unPais){
            unPais.recibirTropas(reservas);
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
