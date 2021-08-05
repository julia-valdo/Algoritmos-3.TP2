package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import javafx.util.Pair;

import java.util.*;

public class ConstructorPaisYCarta {
    ArrayList<Carta> mazoDeCartas;
    HashMap<String, Pais> paises;

    public ConstructorPaisYCarta(){
        this.mazoDeCartas = new ArrayList<>();
        this.paises = new HashMap<>();
    }

    public void construirPaisesYCartas(HashMap<String, String> cartaPaisHash, HashMap<String, String> fronteras,
                                       HashMap<String, Pair<Integer, Integer>> cordenadas){


        cartaPaisHash.forEach((key, value) -> paises.put(key, new Pais(key)));

        Collection<String> paisesValues = cartaPaisHash.keySet();

        for (String pais : paisesValues){
            String stringFrontera = fronteras.get(pais);
            String[] paisesFrontera = stringFrontera.split(",");
            Pais paisActual = this.paises.get(pais);
            for(String front : paisesFrontera){
                paisActual.agregarPaisConectado(this.paises.get(front));
            }
            paisActual.setCordenadas(cordenadas.get(paisActual.getNombreDelPais()));
        }


        cartaPaisHash.forEach((key, value) -> mazoDeCartas.add(new Carta(paises.get(key), value)));


    }

    public HashMap<String, Pais> getPaises(){
        return this.paises;
    }

    public ArrayList<Carta> getCartas(){
        return this.mazoDeCartas;
    }
}
