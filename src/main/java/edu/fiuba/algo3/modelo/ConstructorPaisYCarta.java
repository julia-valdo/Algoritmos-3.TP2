package edu.fiuba.algo3.modelo;

import java.util.*;

public class ConstructorPaisYCarta {
    ArrayList<Carta> mazoDeCartas;
    HashMap<String, Pais> paises;

    public ConstructorPaisYCarta(){
        this.mazoDeCartas = new ArrayList<>();
        this.paises = new HashMap<>();
    }

    public void construirPaisesYCartas(HashMap<String, String> cartaPaisHash, HashMap<String, String> fronteras){


        cartaPaisHash.forEach((key, value) -> paises.put(key, new Pais(key)));

        Collection<String> paisesValues = cartaPaisHash.keySet();

        for (String pais : paisesValues){
            String stringFrontera = fronteras.get(pais);
            String[] paisesFrontera = stringFrontera.split(",");

            for(String front : paisesFrontera){
                this.paises.get(pais).agregarPaisConectado(this.paises.get(front));
            }
        }


        cartaPaisHash.forEach((key, value) -> mazoDeCartas.add(new Carta(paises.get(value), key)));


    }

    public HashMap<String, Pais> getPaises(){
        return this.paises;
    }

    public ArrayList<Carta> getCartas(){
        return this.mazoDeCartas;
    }
}
