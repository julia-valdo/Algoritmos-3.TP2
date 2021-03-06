package edu.fiuba.algo3.modelo.Parser;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface ParserTipo {
    //Implementar Facad
    void parsearArchivo(String path);

    public HashMap<String, String> getContinentes();

    public HashMap<String, String> getFronteras();

    public HashMap<String, String> getPaisesConSimbolos();

    public HashMap<String, ArrayList<String>> getObjetivos();

    HashMap<String, Pair<Integer, Integer>> getCoordenadas();
}
