package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private int numeroDeJugador;
    private ArrayList<Pais> paisesOcupados;
    private Cuartel cuartel;

    public Jugador(int numeroDeJugador){
        this.paisesOcupados = new ArrayList<>();
        this.numeroDeJugador = numeroDeJugador;
        this.cuartel = new Cuartel(this);
    }

    public void ocupa(Pais unPais){ this.ocuparCon(unPais, 1); }

    public void ocuparCon(Pais unPais, int cantidadFuerzas){
        Ejercitos nuevaDivision = this.cuartel.generarDivision(cantidadFuerzas);
        unPais.recibirTropas(nuevaDivision);
    }

    public void perdisteA(Pais unPais){
        this.paisesOcupados.remove(unPais);
    }

    public void ocupasteA(Pais unPais){ paisesOcupados.add(unPais); }

    public void agregarFichas(int cantidadFichas){
        this.cuartel.agregarEjercitos(cantidadFichas);
    }

    public void atacarPaisDesdeA(Pais unPais, Pais otroPais){
        unPais.atacarA(otroPais);
    }

    public int cantidadDeEjercitosAColocar(Banco banco){
        int cantidadEjercitos = (paisesOcupados.size()) / 2;
        //cantidadEjercitos += banco.ejercitosPorCanjeoDeCartas(cartas);
        cantidadEjercitos += banco.ejercitosPorContinentesConquistados(paisesOcupados);
        return cantidadEjercitos;
    }

    /*
    Agrega fichas a un pais que el jugador esta ocupando, si no lo ocupa eleva excepcion
     */
    public void agregarFichasA(int numeroDeFichas, Pais unPais) {
        this.cuartel.agregarFichasA(numeroDeFichas, unPais);
    }

    /*
    Recibe una carta que se la guarda el jugador
     */
    public void recibirCarta(Carta unaCarta) {
        this.cuartel.recibirCarta(unaCarta);
    }

    /*
    Realiza el canje de las tres cartas pasadas como parametro, siempre que el jugador posea las cartas
     */
    public void canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
            this.cuartel.canjearCartas(primeraCarta, segundaCarta, terceraCarta);
    }

    /*
    Canjea una carta que tiene como pais, si no lo tiene no la canjea
     */
    public void canjearCarta(Carta unaCarta) {
        if(paisesOcupados.contains(unaCarta.getPais())){
            unaCarta.getPais().agregarEjercito(2);
        };
    }
}
