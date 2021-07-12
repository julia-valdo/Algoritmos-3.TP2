package edu.fiuba.algo3.modelo;

public class Pais {

    Ocupante fuerzasOcupantes;

    public Pais(){
        this.fuerzasOcupantes = new EjercitosNulos();
    }

    /*
    Para cambiar cuando se implementen los ejercitos
     */
    public void recibirTropas(Ocupante otrosEjercitos){
            if(this.fuerzasOcupantes.debenDesocupar(this)) {
                this.cambiarDeOcupante(otrosEjercitos);
            }
    }

    public boolean estaOcupadoPor(Jugador unJugador){
        return this.fuerzasOcupantes.estanBajoElMandoDe(unJugador);
    }

    private void cambiarDeOcupante(Ocupante otrosEjercitos){
        this.fuerzasOcupantes = otrosEjercitos;
        otrosEjercitos.ocupacionExitosaDe(this);
    }

}
