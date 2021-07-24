package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Parser {
    ParserTipo parser;
    Constructor objetos;

    public Parser(){
        objetos = new Constructor();
        parser = null;
    }

    public void parsearArchivo(String path) {
        if (parser == null){
            if(path.contains("json")) parser = new ParserJson();
        }
        if (parser != null) {
            parser.parsearArchivo(path);
        }
    }

    public void construirObjetos(){
        objetos.construirPaisesYCartas(parser.getPaisesConSimbolos(), parser.getFronteras());
        objetos.construirContinente(parser.getContinentes());

    }

    public HashMap<String, Pais> getPaises(){
        return objetos.getPaises();
    }

    public ArrayList<Carta> getCartas(){
        return objetos.getCartas();
    }

    public HashMap<String, Continente> getContinentes(){
        return objetos.getContinente();
    }
}
