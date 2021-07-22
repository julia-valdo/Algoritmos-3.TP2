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
        cantidadEjercitos += banco.ejercitosPorContinentesConquistados(paisesOcupados);
        return cantidadEjercitos;
    }


    public void agregarFichasA(int numeroDeFichas, Pais unPais) {
        this.cuartel.agregarFichasA(numeroDeFichas, unPais);
    }


    public void recibirCarta(Carta unaCarta) {
        this.cuartel.recibirCarta(unaCarta);
    }


    public void canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
            this.cuartel.canjearCartas(primeraCarta, segundaCarta, terceraCarta);
    }

    public void canjearCarta(Carta unaCarta) {
        if(this.puedoCanjearLaCarta(unaCarta)){
            this.cuartel.canjearCarta(unaCarta);
        };
    }

    public ArrayList<Pais> getPaisesOcupados() {
        return paisesOcupados;
    }

    private boolean puedoCanjearLaCarta(Carta unaCarta){
        return paisesOcupados.contains(unaCarta.getPais());
    }
}
