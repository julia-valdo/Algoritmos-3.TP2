package edu.fiuba.algo3.modelo;

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
            otrosEjercitos.retirarse();
            return this;
    }

    private void retirarse() {
        this.comandante.agregarFichas(this.getCantidadEjercitos());
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

    /*
    Se junta con las fichas de la otra division, solamente si tienen el mismo comandante
     */
    public void agregarDivision(Ejercitos nuevaDivision) {
        this.agregarEjercitos(nuevaDivision.getCantidadEjercitos());
    }

    /*
    Hago override del metodo equals
     */
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
}
