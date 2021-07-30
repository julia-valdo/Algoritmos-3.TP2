package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.modelo.Objetivos.Objetivo;

import java.util.ArrayList;
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
        objetos.construirPaisesYCartas(parser.getPaisesConSimbolos(), parser.getFronteras(), parser.getCoordenadas());
        objetos.construirContinente(parser.getContinentes());
        objetos.contruirObjetivos(parser.getObjetivos());
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

    public HashMap<String, ArrayList<Objetivo>> getObjetivos(){
        return objetos.getObjetivos();
    }
}
