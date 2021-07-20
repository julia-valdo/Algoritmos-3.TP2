package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Banco {
    ArrayList<Carta> mazoDeCartas;
    ArrayList<Continente> continentes;

    public Banco (ArrayList<Carta> mazoDeCartas, ArrayList<Continente> continentes){
        this.mazoDeCartas = mazoDeCartas;
        this.continentes = continentes;
    }

//    public int ejercitosPorCanjeoDeCartas(ArrayList<Carta>cartas){
//      Pensar en algun futuro proximo
//    }

    public int ejercitosPorContinentesConquistados(ArrayList<Pais>paisesOcupados){
        int ejercitosTotal = 0;
        for(Continente continente : continentes){
            if(continente.fueConquistado(paisesOcupados)) {
                ejercitosTotal += continente.getCantidadDeFichasPorContinente();
            }
        }
        return ejercitosTotal;
    }

    private boolean puedoCanjear(ArrayList<Carta> cartas){
        int globos = 0;
        int cañon = 0;
        int barco = 0;

        for(Carta carta : cartas){
            if(carta.getSimbolo().equals("Globo")) globos += 1;
            else if (carta.getSimbolo().equals("Cañon")) cañon += 1;
            else barco += 1;
        }
        return false;
    }
}
