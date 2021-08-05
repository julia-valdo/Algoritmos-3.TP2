package edu.fiuba.algo3.modelo.Parser;

import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.modelo.Objetivos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ConstructorObjetivos {
    HashMap<String, ArrayList<Objetivo>> objetivos;
    HashMap<Integer, Jugador> jugadores;

    public ConstructorObjetivos(HashMap<Integer, Jugador> jugadores){
        objetivos = new HashMap<>();
        this.jugadores = jugadores;
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
            listaObjetivosDestruccion.add(new ObjetivoDerrotar(this.jugadores.get(Integer.parseInt(objetivo))));
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

    public ArrayList<Objetivo> getObjetivos() {
        return this.construirObjetivos();
    }

    private ArrayList<Objetivo> construirObjetivos() {
        ArrayList<Objetivo> objetivosFinales = new ArrayList<>();
        Objetivo objetivoComun = this.objetivos.get("Comun").get(0);
        this.terminarObjetivosOcupacion(objetivosFinales, objetivoComun);
        this.terminarObjetivosDestruccion(objetivosFinales, objetivoComun);

        return objetivosFinales;
    }

    private void terminarObjetivosDestruccion(ArrayList<Objetivo> objetivosFinales, Objetivo objetivoComun) {
        ArrayList<Objetivo> objetivosDeDestruccion = this.objetivos.get("Destruccion");
        this.completarConstruccionDe(objetivosFinales, objetivoComun, objetivosDeDestruccion);
    }

    private void completarConstruccionDe(ArrayList<Objetivo> objetivosFinales, Objetivo objetivoComun,
                                         ArrayList<Objetivo> objetivosDeTipo) {
        for(Objetivo objetivo: objetivosDeTipo){
            objetivosFinales.add(new ObjetivoJugador(objetivoComun, objetivo));
        }
    }

    private void terminarObjetivosOcupacion(ArrayList<Objetivo> objetivosFinales, Objetivo objetivoComun) {
        ArrayList<Objetivo> objetivosDeOcupacion = this.objetivos.get("Ocupacion");
        this.completarConstruccionDe(objetivosFinales, objetivoComun, objetivosDeOcupacion);
    }

}
