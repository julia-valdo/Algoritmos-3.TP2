package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Cartas.ManoDeCartas;
import edu.fiuba.algo3.modelo.Cartas.Mazo;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.vista.Elementos.Ficha;

import java.util.ArrayList;
import java.util.List;

public class InventarioDeJuego {
    Mazo mazoDeCartas;
    ArrayList<Continente> continentes;
    private List<Pais> paises;

    public InventarioDeJuego(ArrayList<Carta> mazoDeCartas, ArrayList<Continente> continentes){
        this.mazoDeCartas = new Mazo(mazoDeCartas);
        this.continentes = continentes;
    }

    public int ejercitosPorContinentesConquistados(ArrayList<Pais>paisesOcupados){
        int ejercitosTotal = 0;
        for(Continente continente : continentes){
            if(continente.fueConquistado(paisesOcupados)) {
                ejercitosTotal += continente.getCantidadDeFichasPorContinente();
            }
        }
        return ejercitosTotal;
    }


    public void repartirCarta(Jugador jugador1) {
        this.mazoDeCartas.repartirCarta(jugador1);
    }

    public boolean quedanCartas() {

        return this.mazoDeCartas.quedanCartas();
    }

    public void repartirCarta(ManoDeCartas mano) {
        this.mazoDeCartas.repartirCarta(mano);
    }

    public void setPaises(ArrayList<Pais> paises) {
        this.paises = paises;
    }

    public void agregarFichaA(Ficha ficha, int i) {
        paises.get(i).setFicha(ficha);
    }

    public int cantidadDePaises() {
        return this.paises.size();
    }

    public void setHandlerError(HandlerDePais handler) {
        for(Pais pais: this.paises){
            pais.agregarHandler(handler);
        }
    }
}
