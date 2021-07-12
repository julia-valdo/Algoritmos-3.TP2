package edu.fiuba.algo3.modelo;

public class EnPie implements Ejercitos{

    Jugador comandante;
    int numeroDeFuerzas;

    public EnPie(int fuerzasIniciales, Jugador comandante){
        this.numeroDeFuerzas = fuerzasIniciales;
        this.comandante = comandante;
    }

    @Override
    public boolean estanBajoElMandoDe(Jugador unJugador){
        return comandante == unJugador;
    }

    @Override
    public Ejercitos disputarDominioDe(Pais unPais, Ejercitos otrasFuerzas) {
        return this;
    }


    @Override
    public void ocupacionExitosaDe(Pais unPais) {
        this.comandante.ocupasteA(unPais);
    }

    @Override
    public Ejercitos evaluarFuerzasRestantes(){
        return numeroDeFuerzas == 0 ? new Derrotados(this.comandante) : this;
    }

}
