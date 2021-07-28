package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.modelo.Parser.Parser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParseoTest {

    @Test
    public void funcionamientoDelParser() {
        Parser parseador = new Parser();

        parseador.parsearArchivo("Teg - Cartas.json");
        parseador.parsearArchivo("Teg - Fronteras.json");

        parseador.construirObjetos();

        assertEquals(50,parseador.getPaises().size());
        assertEquals(50,parseador.getCartas().size());
        assertEquals(6,parseador.getContinentes().size());
    }

    @Test
    public void verificoAlgunObjetoBienConstruido() {
        Parser parseador = new Parser();

        parseador.parsearArchivo("Teg - Cartas.json");
        parseador.parsearArchivo("Teg - Fronteras.json");

        parseador.construirObjetos();

        Continente america = parseador.getContinentes().get("America del Sur");
        HashMap<String, Pais> paises = parseador.getPaises();

        assertTrue(america.pertenece(paises.get("Argentina")));
        assertTrue(america.pertenece(paises.get("Colombia")));
        assertTrue(america.pertenece(paises.get("Peru")));
        assertTrue(america.pertenece(paises.get("Uruguay")));
        assertTrue(america.pertenece(paises.get("Brasil")));
        assertTrue(america.pertenece(paises.get("Chile")));
    }


}
