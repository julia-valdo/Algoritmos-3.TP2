package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.Objetivos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ConstructorObjetivos {
    HashMap<String, ArrayList<Objetivo>> objetivos;

    public ConstructorObjetivos(){
        objetivos = new HashMap<>();
    }

    public void construirObjetivos(HashMap<String, ArrayList<String>> objetivos, HashMap<String, Continente> continentes) {
        Set<String> tipos = objetivos.keySet();
        for(String tipo: tipos){
            ArrayList<String> objetivosDelTipo = objetivos.get(tipo);
            if(tipo.equals("Ocupacion")) this.objetivos.put(tipo, crearObjetivosOcupacion(objetivosDelTipo, continentes));
            else if(tipo.equals("Destruccion")) this.objetivos.put(tipo, crearObjetivosDestruccion(objetivosDelTipo));
            else this.objetivos.put(tipo, crearObjetivosComun(objetivosDelTipo));
        }
    }

    private ArrayList<Objetivo> crearObjetivosOcupacion(ArrayList<String> objetivosDelTipo, HashMap<String, Continente> continentes){
        ArrayList<Objetivo> listaObjetivosOcupacion = new ArrayList<>();
        for(String objetivo: objetivosDelTipo){
            String[] elementos = objetivo.split(",");
            listaObjetivosOcupacion.add(new ObjetivoConquistar(continentes.get(elementos[0]), continentes.get(elementos[1]), Integer.parseInt(elementos[2])));
        }
        return listaObjetivosOcupacion;
    }

    private ArrayList<Objetivo> crearObjetivosDestruccion(ArrayList<String> objetivosDelTipo){
        ArrayList<Objetivo> listaObjetivosDestruccion = new ArrayList<>();
        for(String objetivo: objetivosDelTipo){
            listaObjetivosDestruccion.add(new ObjetivoDerrotar(Integer.parseInt(objetivo)));
        }
        return listaObjetivosDestruccion;
    }

    private ArrayList<Objetivo> crearObjetivosComun(ArrayList<String> objetivosDelTipo){
        ArrayList<Objetivo> listaObjetivosComun = new ArrayList<>();
        for(String objetivo: objetivosDelTipo){
            listaObjetivosComun.add(new ObjetivoGeneral(Integer.parseInt(objetivo)));
        }
        return listaObjetivosComun;
    }

    public HashMap<String, ArrayList<Objetivo>> getObjetivos() {
        return objetivos;
    }
}
