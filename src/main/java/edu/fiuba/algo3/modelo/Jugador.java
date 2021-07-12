package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

    private Ejercitos reservas;
    private ArrayList<Pais> paisesOcupados;

    public Jugador(int numeroDeFuerzas){
        this.reservas = new Ejercitos(numeroDeFuerzas, this);
        this.paisesOcupados = new ArrayList<>();
    }

    public void ocupa(Pais unPais){
            unPais.recibirTropas(reservas);
            if(unPais.estaOcupadoPor(this)) {
                paisesOcupados.add(unPais);
            }
    }

    public void atacarA(Pais unPais){
            paisesOcupados.get(0).atacarA(unPais);
    }

    public boolean tieneFuerzasEn(Pais unPais){
        return paisesOcupados.contains(unPais);
    }

    public void perdisteA(Pais unPais){
        this.paisesOcupados.remove(unPais);
    }

}
