package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ColocacionTest {

    @Test
    public void dosJugadoresColocanEjercitos() {

        Jugador jugadorUno = new Jugador(1);
        Jugador jugadorDos = new Jugador(2);
        Pais china = new Pais("china");
        Pais argentina = new Pais("argentina");

        jugadorUno.ocuparCon(china, 2);
        jugadorDos.ocuparCon(argentina, 3);

        assertEquals(china.getCantidadDeEjercitos(), 2);
        assertEquals(argentina.getCantidadDeEjercitos(), 3);
    }

    @Test
    public void tresJugadoresColocanEjercitos() {
        Jugador jugadorUno = new Jugador(1);
        Jugador jugadorDos = new Jugador(2);
        Jugador jugadorTres = new Jugador(3);

        Parser parser = new Parser();

        parser.parsearArchivo("Teg - Cartas.json");
        parser.parsearArchivo("Teg - Fronteras.json");

        parser.construirObjetos();

        HashMap<String, Pais> paises = parser.getPaises();
        HashMap<String, Continente> continentes = parser.getContinentes();

        Pais francia = new Pais("Francia");
        Pais argentina = new Pais("Argentina");


        Continente asia = continentes.get("Asia");
        List<Pais> paisesDeAsia = (new ArrayList<>(paises.values())).stream().filter(asia::pertenece).collect(Collectors.toList());

        assertEquals(asia.cantidadPaisesQueMeConforman(), 15);
        assertEquals(asia.getCantidadDeFichasPorContinente(), 7);

        for(Pais pais: paisesDeAsia){
            jugadorDos.ocupasteA(pais);
        }

        jugadorUno.ocuparCon(francia, 2);
        jugadorTres.ocuparCon(argentina, 3);

        assertTrue(asia.fueConquistado(jugadorDos.getPaisesOcupados()));
    }

    @Test
    public void jugadorUnoConquistaDosPaisesDelJugadorDos(){
        Jugador jugadorUno = new Jugador(1);
        Jugador jugadorDos = new Jugador(2);

        Pais kamchatka = new Pais("kamchatka");
        Pais china = new Pais("china");
        Pais mongolia = new Pais("mongolia");

        kamchatka.agregarPaisConectado(china);
        china.agregarPaisConectado(kamchatka);
        mongolia.agregarPaisConectado(kamchatka);
        mongolia.agregarPaisConectado(china);

        jugadorDos.ocupa(kamchatka);
        jugadorDos.ocupa(china);

        jugadorUno.ocuparCon(mongolia, 10);

        while(jugadorDos.getPaisesOcupados().size() > 1){
            jugadorUno.atacarPaisDesdeA(mongolia, kamchatka);
        }
        while(jugadorDos.getPaisesOcupados().size() > 0){
            jugadorUno.atacarPaisDesdeA(mongolia, china);
        }
        assertEquals(jugadorUno.getPaisesOcupados().size(), 3);
    }
}
