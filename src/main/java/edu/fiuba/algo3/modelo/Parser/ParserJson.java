package edu.fiuba.algo3.modelo.Parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.Parser.ParserTipo;
import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


//Todos los prints que vean son para checkear que funca nomas

public class ParserJson implements ParserTipo {
    HashMap<String, String> paises;
    HashMap<String, String> continentes;
    HashMap<String, String> fronteras;
    HashMap<String, Pair<Integer, Integer>> cordenadas;
    HashMap<String, ArrayList<String>> objetivos;

    @SuppressWarnings("unchecked")

    public ParserJson() {
        paises = new HashMap<>();
        continentes = new HashMap<>();
        fronteras = new HashMap<>();
        objetivos = new HashMap<>();
    }

    @Override
    public void parsearArchivo(String path) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);

            JSONArray tegList = (JSONArray) obj;

            if (path.equals("Teg - Cartas.json")) tegList.forEach(carta -> parseCartasObject((JSONObject) carta));
            if (path.equals("Teg - Fronteras.json")) tegList.forEach(frontera -> parseFronterasObject((JSONObject) frontera));
            if (path.equals("Teg - Objetivos.json")) tegList.forEach(objetivo -> parseObjetivosObject((JSONObject) objetivo));


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseObjetivosObject(JSONObject objetivo) {
        JSONObject cartasObject = (JSONObject) objetivo;

        String tipo = (String) cartasObject.get("TipoDeObjetivo");
        if(!this.objetivos.containsKey(tipo)){
            this.objetivos.put(tipo, new ArrayList<String>());
        }
        if(tipo.equals("Ocupacion")){
            String principal = (String) cartasObject.get("ContinentePrincipal");
            String secundario = (String) cartasObject.get("ContinenteSecundario");
            String cantidad = (String) cartasObject.get("CantidadPaises");
            String completo = principal + "," + secundario + "," + cantidad;
            this.objetivos.get(tipo).add(completo);
        }
        if(tipo.equals("Destruccion")){
            String jugador = (String) cartasObject.get("DestruirJugador");
            this.objetivos.get(tipo).add(jugador);
        }
        if(tipo.equals("Comun")){
            String cantidad = (String) cartasObject.get("Ocupar");
            this.objetivos.get(tipo).add(cantidad);
        }
    }

    private void parseCartasObject(JSONObject cartas) {
        JSONObject cartasObject = (JSONObject) cartas;

        String nombrePais = (String) cartasObject.get("Pais");
        String simbolo = (String) cartasObject.get("Simbolo");

        this.paises.put(nombrePais, simbolo);
    }

    private void parseFronterasObject(JSONObject fronteras) {
        JSONObject fronterasObject = (JSONObject) fronteras;

        String nombrePais = (String) fronterasObject.get("Pais");
        Integer cordX = (Integer) fronterasObject.get("posX");
        Integer cordY = (Integer) fronterasObject.get("posY");
        String nombreContinente = (String) fronterasObject.get("Continente");
        String paisesLimitrofes = (String) fronterasObject.get("Limita con");

        this.fronteras.put(nombrePais, paisesLimitrofes);
        this.cordenadas.put(nombrePais, new Pair<>(cordX, cordY));

        if (!continentes.containsKey(nombreContinente)){
            continentes.put(nombreContinente, nombrePais);
        } else {
            String paisesContinente = continentes.get(nombreContinente) + "," + nombrePais; //"Argentina,Chile,Brazil"
            continentes.put(nombreContinente, paisesContinente);
        }
    }

    @Override
    public HashMap<String, String> getPaisesConSimbolos() {
        return paises;
    }
    @Override
    public HashMap<String, String> getFronteras() {
        return fronteras;
    }
    @Override
    public HashMap<String, String> getContinentes() {
        return continentes;
    }
    @Override
    public HashMap<String, ArrayList<String>> getObjetivos(){ return objetivos; }

    @Override
    public HashMap<String, Pair<Integer, Integer>> getCordenadas() {
        return cordenadas;
    }
}



