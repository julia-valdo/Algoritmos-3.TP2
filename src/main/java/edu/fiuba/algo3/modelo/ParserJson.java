package edu.fiuba.algo3.modelo;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


//Todos los prints que vean son para checkear que funca nomas

public class ParserJson {
    @SuppressWarnings("unchecked")

    public static void obtenerParse(String path) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);

            JSONArray tegList = (JSONArray) obj;
            System.out.println(tegList);

            if (path.equals("Teg - Cartas.json")) tegList.forEach(carta -> parseCartasObject((JSONObject) carta));
            if (path.equals("Teg - Fronteras.json")) tegList.forEach(frontera -> parseFronterasObject((JSONObject) frontera));



        } catch (IOException | ParseException e ) {
            e.printStackTrace();
        }
    }

    //        public static void main(String[] args) {
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader("Teg - Cartas.json")) {
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray tegList = (JSONArray) obj;
//            System.out.println(tegList);
//
//             tegList.forEach(carta -> parseCartasObject((JSONObject) carta));
//            //if (path.equals("Teg - Fronteras.json")) tegList.forEach(frontera -> parseFronterasObject((JSONObject) frontera));
//
//
//
//        } catch (IOException | ParseException e ) {
//            e.printStackTrace();
//        }
//    }



    private static void parseCartasObject(JSONObject cartas) {
        JSONObject cartasObject = (JSONObject) cartas;

        String pais = (String) cartasObject.get("Pais");
        System.out.println(pais);

        String simbolo = (String) cartasObject.get("Simbolo");
        System.out.println(simbolo);

    }

    private static void parseFronterasObject(JSONObject fronteras) {
        JSONObject fronterasObject = (JSONObject) fronteras;

        String pais = (String) fronterasObject.get("Pais");
        System.out.println(pais);

        String continente = (String) fronterasObject.get("Continente");
        System.out.println(continente);

        String limite = (String) fronterasObject.get("Limita con");
        System.out.println(limite);

    }




}



