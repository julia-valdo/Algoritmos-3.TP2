package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private int numeroDeJugador;
    private Ejercitos reservas;
    private ArrayList<Pais> paisesOcupados;
    private ArrayList<Carta>cartas;

    public Jugador(int numeroDeJugador){
        this.reservas = new Ejercitos(10,this);
        this.paisesOcupados = new ArrayList<>();
        this.numeroDeJugador = numeroDeJugador;
    }

    public void ocupa(Pais unPais){ this.ocuparCon(unPais, 1); }

    public void ocuparCon(Pais unPais, int cantidadFuerzas){
        Ejercitos nuevaDivision = this.reservas.generarDivision(cantidadFuerzas);
        unPais.recibirTropas(nuevaDivision);
    }

    public void perdisteA(Pais unPais){
        this.paisesOcupados.remove(unPais);
    }

    public void ocupasteA(Pais unPais){ paisesOcupados.add(unPais); }

    public void agregarFichas(int cantidadFichas){
        this.reservas.agregarEjercitos(cantidadFichas);
    }

    public void atacarPaisDesdeA(Pais unPais, Pais otroPais){
        unPais.atacarA(otroPais);
    }

    public int cantidadDeEjercitosAColocar(Banco banco){
        int cantidadEjercitos = (paisesOcupados.size()) / 2;
        cantidadEjercitos += banco.ejercitosPorCanjeoDeCartas(cartas);
        cantidadEjercitos += banco.ejercitosPorContinentesConquistados(paisesOcupados);
        return cantidadEjercitos;
    }

}
