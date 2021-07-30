package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Objetivos.Objetivo;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Constructor {
    ConstructorPaisYCarta paisYCarta;
    ConstructorContinente continente;
    ConstructorObjetivos objetivos;

    public Constructor(){
        paisYCarta = new ConstructorPaisYCarta();
        continente = new ConstructorContinente();
        objetivos = new ConstructorObjetivos();
    }

    public void construirPaisesYCartas(HashMap<String, String> cartaPais, HashMap<String, String> fronteras, HashMap<String,
            Pair<Integer, Integer>> cordenadas){
        this.paisYCarta.construirPaisesYCartas(cartaPais, fronteras, cordenadas);
    }

    public void construirContinente(HashMap<String, String> continente){
        this.continente.construirContinente(continente, paisYCarta.getPaises());
    }

    public void contruirObjetivos(HashMap<String, ArrayList<String>> objetivos) {
        this.objetivos.construirObjetivos(objetivos, continente.getContinente());
    }

    public HashMap<String, Pais> getPaises(){
        return paisYCarta.getPaises();
    }

    public ArrayList<Carta> getCartas(){
        return paisYCarta.getCartas();
    }

    public HashMap<String, Continente> getContinente(){
        return continente.getContinente();
    }

    public HashMap<String, ArrayList<Objetivo>> getObjetivos(){
        return objetivos.getObjetivos();
    }

}
