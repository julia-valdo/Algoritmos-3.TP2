package edu.fiuba.algo3.modelo;

public class Derrotados implements EstadoEjercitos{

    private Jugador comandante;

    public Derrotados(Jugador comandante){
        this.comandante = comandante;
    }

    public Derrotados(){
        this.comandante = new Jugador();
    }

    @Override
    public boolean estanBajoElMandoDe(Jugador unJugador) {
        return this.comandante == unJugador;
    }

    @Override
    public EstadoEjercitos disputarDominioDe(Pais unPais, EstadoEjercitos otrasFuerzas) {
        this.comandante.perdisteA(unPais);
        otrasFuerzas.ocupacionExitosaDe(unPais);
        return otrasFuerzas;
    }


    @Override
    public void ocupacionExitosaDe(Pais unPais) {

    }

    @Override
    public EstadoEjercitos evaluarFuerzasRestantes() {
        return this;
    }
}
