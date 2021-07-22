package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

/*
Guarda la informacion del canjeo de cartas del jugador particular
 */
public class Cuartel {
    private ArrayList<Carta> cartas;
    private int fichasDisponibles;
    private Canjes cantidadDeCanjesHechos;
    private Jugador duenoDelCuartel;

    public Cuartel(Jugador dueno){
        cartas = new ArrayList<>();
        fichasDisponibles = 10;
        cantidadDeCanjesHechos = new CanjesCero();
        this.duenoDelCuartel = dueno;
    }

    public void recibirCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public void canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
        if (primeraCarta.esValidoElCanje(segundaCarta, terceraCarta)){
            this.cantidadDeCanjesHechos = this.cantidadDeCanjesHechos.realizarCanjeA(this);
        this.cartas.remove(primeraCarta);this.cartas.remove(primeraCarta);this.cartas.remove(primeraCarta);
        }
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

    public void canjearCarta(Carta unaCarta) {
        unaCarta.canjearse();
    }
}
