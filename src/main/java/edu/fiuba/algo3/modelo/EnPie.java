package edu.fiuba.algo3.modelo;

public class EnPie implements EstadoEjercitos{

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
    public EstadoEjercitos disputarDominioDe(Pais unPais, EstadoEjercitos otrasFuerzas) {
        return this;
    }


    @Override
    public void ocupacionExitosaDe(Pais unPais) {
        this.comandante.ocupasteA(unPais);
    }

    @Override
    public EstadoEjercitos evaluarFuerzasRestantes(){
        return numeroDeFuerzas == 0 ? new Derrotados(this.comandante) : this;
    }

}
