package edu.fiuba.algo3.modelo.Batalla;

import edu.fiuba.algo3.modelo.Excepciones.MovimientoDeEjercitoError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.Ficha;

public class Ejercitos {

    private Jugador comandante;
    protected EstadoEjercitos condicionActual;

    public Ejercitos(){
        this.comandante = new Jugador(0);
        this.condicionActual = new EstadoEjercitosDerrotados();
    }

    public Ejercitos(int numeroFuerzas, Jugador comandante){
        this.comandante = comandante;
        this.condicionActual = new EstadoEjercitosEnPie(numeroFuerzas);
    }

    public int getCantidadEjercitos() {
        return this.condicionActual.getCantidadFuerzas();
    }

    public void agregarEjercitos(int cantidad) {
        this.condicionActual.agregarFuerzas(cantidad);
    }

    public Ejercitos generarDivision(int cantidad){ return this.confirmarNuevaDivisionDe(cantidad); }

    public void restarEjercitos(int cantidad) { this.condicionActual = this.condicionActual.restarFuerzas(cantidad); }

    public boolean sonAliadosDe(Ejercitos ejercitos) { return this.comandante == ejercitos.comandante; }

    public Ejercitos disputarDominioDe(Pais pais, Ejercitos otrosEjercitos) {
            if(this.fueDerrotado()) {
                this.comandante.perdisteA(pais);
                otrosEjercitos.comandante.ocupasteA(pais);
                return otrosEjercitos.generarDivision(1);
            }
            return this;
    }

    private Ejercitos confirmarNuevaDivisionDe(int numeroFuerzas){
        this.restarEjercitos(numeroFuerzas);
        return new Ejercitos(numeroFuerzas, this.comandante);
    }

    protected void avisarOcupacionExitosa(Pais unPais){
        this.comandante.ocupasteA(unPais);
    }

    private boolean fueDerrotado(){
        return this.condicionActual.estanDerrotados();
    }

    public boolean equals(Object otroObjeto){
        if(this == otroObjeto) return true;
        else if(otroObjeto == null || otroObjeto.getClass() != Ejercitos.class) return false;
        Ejercitos otroEjercito = (Ejercitos) otroObjeto;

        return otroEjercito.comandante == this.comandante && otroEjercito.condicionActual.equals(this.condicionActual);
    }


    public void moverEjercitoACon(Ejercitos otroEjercito, int cantidad){
        if(this.condicionActual.getCantidadFuerzas() <= cantidad){
            throw new MovimientoDeEjercitoError("No hay fuerzas suficientes para realizar el movimiento");
        }
        this.restarEjercitos(cantidad);
        otroEjercito.agregarEjercitos(cantidad);
    }

    public String getColor() {
        return this.comandante.getColor();
    }
}
