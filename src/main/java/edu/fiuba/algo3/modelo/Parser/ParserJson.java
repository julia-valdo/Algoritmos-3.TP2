package edu.fiuba.algo3.modelo.Parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.Parser.ParserTipo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


//Todos los prints que vean son para checkear que funca nomas

public class ParserJson implements ParserTipo {
    HashMap<String, String> paises;
    HashMap<String, String> continentes;
    HashMap<String, String> fronteras;

    @SuppressWarnings("unchecked")

    public ParserJson() {
        paises = new HashMap<>();
        continentes = new HashMap<>();
        fronteras = new HashMap<>();
    }

    @Override
    public void parsearArchivo(String path) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);

            JSONArray tegList = (JSONArray) obj;

            if (path.equals("Teg - Cartas.json")) tegList.forEach(carta -> parseCartasObject((JSONObject) carta));
            if (path.equals("Teg - Fronteras.json")) tegList.forEach(frontera -> parseFronterasObject((JSONObject) frontera));


        } catch (IOException | ParseException e) {
            e.printStackTrace();
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
        String nombreContinente = (String) fronterasObject.get("Continente");
        String paisesLimitrofes = (String) fronterasObject.get("Limita con");

        this.fronteras.put(nombrePais, paisesLimitrofes);

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


}



