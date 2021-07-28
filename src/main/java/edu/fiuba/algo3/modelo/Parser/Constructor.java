package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.modelo.Batalla.Pais;

import java.util.ArrayList;
import java.util.HashMap;

public class Constructor {
    ConstructorPaisYCarta paisYCarta;
    ConstructorContinente continente;

    public Constructor(){
        paisYCarta = new ConstructorPaisYCarta();
        continente = new ConstructorContinente();
    }

    public void construirPaisesYCartas(HashMap<String, String> cartaPais, HashMap<String, String> fronteras){
        this.paisYCarta.construirPaisesYCartas(cartaPais, fronteras);
    }

    public void construirContinente(HashMap<String, String> continente){
        this.continente.construirContinente(continente, paisYCarta.getPaises());
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

}
