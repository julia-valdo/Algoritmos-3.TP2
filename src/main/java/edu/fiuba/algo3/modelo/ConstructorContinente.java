package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class ConstructorContinente {
    HashMap<String, Continente> continentes;
    int sieteFichas, cincoFichas, tresFichas, dosFichas;

    public ConstructorContinente() {
        continentes = new HashMap<>();
        sieteFichas = 7;
        cincoFichas = 5;
        tresFichas = 3;
        dosFichas = 2;
    }

    public void construirContinente(HashMap<String, String>continente, HashMap<String, Pais> paises){
        continente.forEach((key, value) -> continentes.put(key, crearContinente(key)));

        Collection<String> continenteKeys = continente.keySet();

        for (String cont : continenteKeys){
            String paisesContinente = continente.get(cont);
            String[] paisesDelContinente = paisesContinente.split(",");

            for(String paisCont : paisesDelContinente){
                Pais paisActual = paises.get(paisCont);
                Continente continenteActual = continentes.get(cont);
                continenteActual.agregarPais(paisActual);
            }
        }
    }

    private Continente crearContinente(String nombre){
        Continente continente;
        switch(nombre){
            case "Asia":
                continente = new Continente(nombre, sieteFichas);
                break;
            case "Europa":
            case "America del Norte":
                continente = new Continente(nombre, cincoFichas);
                break;
            case "America del Sur":
            case "Africa":
                continente = new Continente(nombre, tresFichas);
                break;
            default:
                continente = new Continente(nombre, dosFichas);
                break;
        }
        return continente;
    }


    public HashMap<String, Continente> getContinente(){
        return continentes;
    }

}
