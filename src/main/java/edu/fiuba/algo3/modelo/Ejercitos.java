package edu.fiuba.algo3.modelo;

public class Ejercitos {

    Jugador comandante;
    EstadoEjercitos condicionActual;

    public Ejercitos(Jugador unComandante){
        this.comandante = unComandante;
        this.condicionActual = new Derrotados();
    }

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

    public void restarEjercitos(int cantidad) {

        this.condicionActual = this.condicionActual.restarFuerzas(cantidad);
    }

    public boolean fueDerrotado(){
        this.condicionActual = this.condicionActual.evaluarFuerzasRestantes();
        return this.condicionActual.estanDerrotados();
    }

    public boolean sonAliadosDe(Ejercitos ejercitos) {

        return this.comandante == ejercitos.comandante;
    }

    public boolean estanBajoElMandoDe(Jugador unJugador) {
        return this.comandante == unJugador;
    }

    public Ejercitos disputarDominioDe(Pais pais, Ejercitos otrosEjercitos) {
            if(this.fueDerrotado()) {
                this.comandante.perdisteA(pais);
                otrosEjercitos.comandante.ocupasteA(pais);
                return otrosEjercitos;
            }
            return this;

    }
}
