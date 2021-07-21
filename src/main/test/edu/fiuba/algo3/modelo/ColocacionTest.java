package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
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

        Pais francia = new Pais("francia");
        Pais argentina = new Pais("argentina");

        Pais tartaria = new Pais("tartaria");
        Pais mongolia = new Pais("mongolia");
        Pais kantchatka = new Pais("kantchatka");
        Pais turquia = new Pais("turquia");
        Pais iran = new Pais("iran");
        Pais israel = new Pais("israel");
        Pais taymir = new Pais("taymir");
        Pais aral = new Pais("aral");
        Pais siberia = new Pais("siberia");
        Pais japon = new Pais("japon");
        Pais gobi = new Pais("gobi");
        Pais arabia = new Pais("arabia");
        Pais india = new Pais("india");
        Pais china = new Pais("china");
        Pais malasia = new Pais("malasia");
        Continente asia = new Continente("asia", 7);

        asia.agregarPais(tartaria);
        asia.agregarPais(mongolia);
        asia.agregarPais(kantchatka);
        asia.agregarPais(turquia);
        asia.agregarPais(iran);
        asia.agregarPais(israel);
        asia.agregarPais(taymir);
        asia.agregarPais(aral);
        asia.agregarPais(siberia);
        asia.agregarPais(japon);
        asia.agregarPais(gobi);
        asia.agregarPais(arabia);
        asia.agregarPais(india);
        asia.agregarPais(china);
        asia.agregarPais(malasia);

        assertEquals(asia.cantidadPaisesQueMeConforman(), 15);
        assertEquals(asia.getCantidadDeFichasPorContinente(), 7);

        jugadorDos.ocupasteA(tartaria);
        jugadorDos.ocupasteA(mongolia);
        jugadorDos.ocupasteA(kantchatka);
        jugadorDos.ocupasteA(turquia);
        jugadorDos.ocupasteA(iran);
        jugadorDos.ocupasteA(israel);
        jugadorDos.ocupasteA(taymir);
        jugadorDos.ocupasteA(aral);
        jugadorDos.ocupasteA(siberia);
        jugadorDos.ocupasteA(japon);
        jugadorDos.ocupasteA(gobi);
        jugadorDos.ocupasteA(arabia);
        jugadorDos.ocupasteA(india);
        jugadorDos.ocupasteA(china);
        jugadorDos.ocupasteA(malasia);

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
