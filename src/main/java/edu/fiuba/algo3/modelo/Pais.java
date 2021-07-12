package edu.fiuba.algo3.modelo;

public class Pais {

    Ejercitos fuerzasOcupantes;

    public Pais(){

        Jugador ocupanteNulo = new Jugador(0);
        this.fuerzasOcupantes = new Ejercitos(0, ocupanteNulo);
        ocupanteNulo.ocupa(this);
    }

    public void atacarA(Pais otroPais){
        this.enviarTropasA(otroPais);
    }

    public void recibirTropas(Ejercitos otrosEjercitos){

            if(this.fueronDerrotadasMisFuerzas()) {
                this.fuerzasOcupantes.desocupar(this);
                this.fuerzasOcupantes = otrosEjercitos;
            }
    }

    public boolean estaOcupadoPor(Jugador unJugador){

        return this.fuerzasOcupantes.estanBajoElMandoDe(unJugador);
    }

    private void enviarTropasA(Pais otroPais){
        otroPais.recibirTropas(this.fuerzasOcupantes);
    }

    private boolean fueronDerrotadasMisFuerzas(){
        return this.fuerzasOcupantes.estanDerrotadas();
    }


}
