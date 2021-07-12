package edu.fiuba.algo3.modelo;

public class Pais {

    Ejercitos fuerzasOcupantes;

    public Pais(){
        this.fuerzasOcupantes = new Derrotados();
    }

    /*
    Para cambiar cuando se implementen los ejercitos
     */
    public void recibirTropas(Ejercitos otrosEjercitos){
            this.fuerzasOcupantes = this.fuerzasOcupantes.evaluarFuerzasRestantes();
            this.fuerzasOcupantes = this.fuerzasOcupantes.disputarDominioDe(this, otrosEjercitos);
    }

    public boolean estaOcupadoPor(Jugador unJugador){
        return this.fuerzasOcupantes.estanBajoElMandoDe(unJugador);
    }


}
