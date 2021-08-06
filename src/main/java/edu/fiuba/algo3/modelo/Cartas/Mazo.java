package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.Controlador.handlers.HandlerDeCarta;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Excepciones.NoQuedanCartasError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;

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
        this.sePuedeRepartirCarta();
        unJugador.recibirCarta(this.retirarPrimera());
    }

    private void sePuedeRepartirCarta() {
        if(!this.tengoCartasRestantes()){
            throw new NoQuedanCartasError();
        }
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

    public boolean quedanCartas() {
        return !this.cartas.isEmpty();
    }

    public void repartirCarta(ManoDeCartas manoDeCartas) {
        this.sePuedeRepartirCarta();
        manoDeCartas.recibirCarta(this.retirarPrimera());
    }

    public void agregarHandler(Carta carta, HandlerDeCarta confirmacion){
        for(Carta actual: this.cartas){
            if(!actual.equals(carta)) actual.agregarHandler(confirmacion);
        }
    }

    public void limpiarCartas() {
        for(Carta carta: this.cartas){
            carta.limpiarHandler();
        }
    }
}
