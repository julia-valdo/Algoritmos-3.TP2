package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface ParserTipo {
    //Implementar Facad
    void parsearArchivo(String path);

    public HashMap<String, String> getContinentes();

    public HashMap<String, String> getFronteras();

    public HashMap<String, String> getPaisesConSimbolos();
}
