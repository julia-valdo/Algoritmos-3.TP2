package edu.fiuba.algo3.modelo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


//Todos los prints que vean son para checkear que funca nomas

public class ParserJson implements Parser {
    HashMap<String, Pais> paises;
    ArrayList<Carta> cartas;
    HashMap<String, Continente> continentes;

    @SuppressWarnings("unchecked")

    public ParserJson() {

        paises = new HashMap<>();
        cartas = new ArrayList<>();
        continentes = new HashMap<>();

    }

    @Override
    public void parsearArchivo(String path) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);

            JSONArray tegList = (JSONArray) obj;

            if (path.equals("Teg - Cartas.json")) tegList.forEach(carta -> parseCartasObject((JSONObject) carta));
            if (path.equals("Teg - Fronteras.json"))
                tegList.forEach(frontera -> parseFronterasObject((JSONObject) frontera));


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    private void parseCartasObject(JSONObject cartas) {
        JSONObject cartasObject = (JSONObject) cartas;

        String nombrePais = (String) cartasObject.get("Pais");
        String simbolo = (String) cartasObject.get("Simbolo");

        Carta carta = new Carta(nombrePais, simbolo);
        Pais pais = new Pais(nombrePais);
        this.paises.put(nombrePais, pais);
        this.cartas.add(carta);

    }

    private void agregarPaisesLimitrofesASusPaises(String limitrofes, String pais) {

        String[] paisesLimitrofes = limitrofes.split(",");
        for (String paisLimitrofe : paisesLimitrofes) {
            (paises.get(pais)).agregarPaisConectado(paises.get(paisLimitrofe));
        }

    }
    @Override
    public Collection<Pais> getPaises() {
        return paises.values();
    }
    @Override
    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    @Override
    public Collection<Continente> getContinentes() {
        return continentes.values();
    }

    private void parseFronterasObject(JSONObject fronteras) {
        JSONObject fronterasObject = (JSONObject) fronteras;

        String nombrePais = (String) fronterasObject.get("Pais");
        String nombreContinente = (String) fronterasObject.get("Continente");
        String paisesLimitrofes = (String) fronterasObject.get("Limita con");

        if (!continentes.containsKey(nombreContinente)) {
            Continente continente;
            switch (nombreContinente) {
                    case "Africa":
                    case "America del Sur":
                        continente = new Continente(nombreContinente, 3);
                        break;
                    case "America del Norte":
                    case "Europa":
                        continente = new Continente(nombreContinente, 5);
                        break;
                    case "Asia":
                        continente = new Continente(nombreContinente, 7);
                        break;
                    default:
                        continente = new Continente(nombreContinente, 2);
                        break;
                }
                continentes.put(nombreContinente, continente);
            }
        (continentes.get(nombreContinente)).agregarPais(paises.get(nombrePais));
        agregarPaisesLimitrofesASusPaises(paisesLimitrofes, nombrePais);

    }
}



