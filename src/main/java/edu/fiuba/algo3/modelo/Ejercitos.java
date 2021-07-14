package edu.fiuba.algo3.modelo;

public class Ejercitos {

    private Jugador comandante;
    private EstadoEjercitos condicionActual;

    public Ejercitos(){
        this.comandante = new Jugador();
        this.condicionActual = new Derrotados();
    }

    public Ejercitos(int numeroFuerzas, Jugador comandante){
        this.comandante = comandante;
        this.condicionActual = new EnPie(numeroFuerzas);
    }

    public int getCantidadEjercitos() {
        return this.condicionActual.getCantidadFuerzas();
    }

    public void agregarEjercitos(int cantidad) {
        this.condicionActual = this.condicionActual.agregarFuerzas(cantidad);
    }

    public Ejercitos generarDivision(int cantidad){ return this.confirmarNuevaDivisionDe(cantidad); }

    public void restarEjercitos(int cantidad) { this.condicionActual = this.condicionActual.restarFuerzas(cantidad); }

    public boolean fueDerrotado(){
        this.condicionActual = this.condicionActual.evaluarFuerzasRestantes();
        return this.condicionActual.estanDerrotados();
    }

    public boolean sonAliadosDe(Ejercitos ejercitos) { return this.estanBajoElMandoDe(ejercitos.comandante); }

    public boolean estanBajoElMandoDe(Jugador unJugador) {
        return this.comandante == unJugador;
    }

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

}
