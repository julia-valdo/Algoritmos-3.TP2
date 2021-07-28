package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private int numeroDeJugador;
    private ArrayList<Pais> paisesOcupados;
    private Inventario inventario;
    public boolean derrotado;

    public Jugador(int numeroDeJugador){
        this.paisesOcupados = new ArrayList<>();
        this.numeroDeJugador = numeroDeJugador;
        this.inventario = new Inventario(this);
        this.derrotado = false;
    }

    public void ocupa(Pais unPais){ this.ocuparCon(unPais, 1); }

    public void ocuparCon(Pais unPais, int cantidadFuerzas){
        Ejercitos nuevaDivision = this.inventario.generarDivision(cantidadFuerzas);
        unPais.recibirTropas(nuevaDivision);
    }

    //AgregarEstadoDerrotado
    public void perdisteA(Pais unPais){
        this.paisesOcupados.remove(unPais);
        if (this.paisesOcupados.isEmpty()) this.derrotado = true;
    }

    public void ocupasteA(Pais unPais){ paisesOcupados.add(unPais); }

    public void agregarFichas(int cantidadFichas){
        this.inventario.agregarEjercitos(cantidadFichas);
    }

    public void atacarPaisDesdeA(Pais unPais, Pais otroPais){
        unPais.atacarA(otroPais);
    }

    public int cantidadDeEjercitosAColocar(InventarioDeJuego inventarioDeJuego){
        int cantidadEjercitos = (paisesOcupados.size()) / 2;
        cantidadEjercitos += inventarioDeJuego.ejercitosPorContinentesConquistados(paisesOcupados);
        return cantidadEjercitos;
    }


    public void agregarFichasA(int numeroDeFichas, Pais unPais) {
        this.inventario.agregarFichasA(numeroDeFichas, unPais);
    }


    public void recibirCarta(Carta unaCarta) {
        this.inventario.recibirCarta(unaCarta);
    }


    public void canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
            this.inventario.canjearCartas(primeraCarta, segundaCarta, terceraCarta);
    }

    public void canjearCarta(Carta unaCarta) {
        if(this.puedoCanjearLaCarta(unaCarta)){
            this.inventario.activarCarta(unaCarta);
        };
    }

    public ArrayList<Pais> getPaisesOcupados() {
        return paisesOcupados;
    }

    private boolean puedoCanjearLaCarta(Carta unaCarta){
        return paisesOcupados.contains(unaCarta.getPais());
    }

    public boolean fueDerrotado(){
        return this.derrotado;
    }

    public void moverFichasDeACon(Pais unPais, Pais otroPais, int cantidad){
        unPais.moverEjercitoA(otroPais, cantidad);
    }
}
