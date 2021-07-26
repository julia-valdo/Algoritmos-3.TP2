package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mazo {

    private ArrayList<Carta> cartas;

    public Mazo(ArrayList<Carta> cartas){
        this.asociarmeLasCartas(cartas);
        this.cartas = cartas;
    }

    private void asociarmeLasCartas(ArrayList<Carta> cartas) {
        for(Carta carta: cartas){
            carta.asociarAlMazo(this);
        }
    }

    public void repartirCarta(Jugador unJugador){
        if(!this.tengoCartasRestantes()){
            throw new NoQuedanCartasError();
        }
        unJugador.recibirCarta(this.retirarPrimera());
    }

    private boolean tengoCartasRestantes(){
        return !this.cartas.isEmpty();
    }

    private Carta retirarPrimera(){
        return this.cartas.remove(0);
    }

    public void vuelveAlMazo(Carta carta) {
        this.cartas.add(carta);
    }
}
