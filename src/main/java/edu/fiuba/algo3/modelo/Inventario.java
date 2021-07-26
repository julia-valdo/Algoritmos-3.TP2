package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

/*
Guarda la informacion del canjeo de cartas del jugador particular
 */
public class Inventario {
    private ManoDeCartas mano;
    private int fichasDisponibles;
    private Jugador duenoDelCuartel;

    public Inventario(Jugador dueno){
        this.fichasDisponibles = 0;
        this.mano = new ManoDeCartas();
        this.duenoDelCuartel = dueno;
    }

    public void recibirCarta(Carta unaCarta) {
        this.mano.recibirCarta(unaCarta);
    }

    public void canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
        this.fichasDisponibles += this.mano.canjearCartas(primeraCarta, segundaCarta, terceraCarta);
    }

    public Ejercitos generarDivision(int cantidadFuerzas) {
        if(cantidadFuerzas > fichasDisponibles){
            throw new NoHayFuerzasRestantesError();
        }
        this.fichasDisponibles -= cantidadFuerzas;
        return new Ejercitos(cantidadFuerzas, duenoDelCuartel);
    }

    public void agregarEjercitos(int cantidadFichas) {
        this.fichasDisponibles += cantidadFichas;
    }

    public void agregarFichasA(int numeroDeFichas, Pais unPais) {
        if(numeroDeFichas > fichasDisponibles){
            throw new NoHayFuerzasRestantesError();
        }
        this.fichasDisponibles -= numeroDeFichas;
        unPais.agregarEjercito(numeroDeFichas);
    }

    public void activarCarta(Carta unaCarta) {
        this.mano.activarCarta(unaCarta);
    }
}
