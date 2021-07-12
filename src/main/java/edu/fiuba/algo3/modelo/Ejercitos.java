package edu.fiuba.algo3.modelo;

public class Ejercitos {

    Jugador comandante;
    int numeroDeFuerzas;

    public Ejercitos(int fuerzasIniciales, Jugador comandante){
        this.numeroDeFuerzas = fuerzasIniciales;
        this.comandante = comandante;
    }

    public boolean estanBajoElMandoDe(Jugador unJugador){
        return comandante == unJugador;
    }

    public boolean estanDerrotadas(){
        return numeroDeFuerzas == 0;
    }

    public void desocupar(Pais unPais){
        this.comandante.perdisteA(unPais);
    }

}
