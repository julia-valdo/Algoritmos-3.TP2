package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.modelo.Parser.Parser;
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
        jugadorUno.agregarFichas(3);
        jugadorDos.agregarFichas(3);
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
        jugadorUno.agregarFichas(15);
        jugadorDos.agregarFichas(15);
        jugadorTres.agregarFichas(15);
        HashMap<Integer, Jugador> jugadores = new HashMap<>();
        jugadores.put(1, jugadorUno);
        jugadores.put(2, jugadorDos);
        jugadores.put(3, jugadorTres);

        Parser parser = new Parser(jugadores);

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
        jugadorUno.agregarFichas(10);
        jugadorDos.agregarFichas(2);
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
