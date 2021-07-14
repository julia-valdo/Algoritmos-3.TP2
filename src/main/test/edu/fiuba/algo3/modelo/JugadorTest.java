package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class JugadorTest {


    @Test
    public void unJugadorPuedeOcuparUnPaisConEjercitosDerrotados(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Pais argentina = new Pais("argentina");
        Pais chile = new Pais("chile");

        jugador1.ocupa(argentina);
        jugador2.ocuparCon(chile, 0);//Las fuerzas de este ya estan derrotadas


        jugador1.ocupa(chile);


        assertFalse(jugador2.tieneFuerzasEn(chile));
        assertTrue(jugador1.tieneFuerzasEn(chile));

    }

    @Test
    public void unJugadorNoPuedeOcuparUnPaisConEjercitosEnPie(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador(); //no se derrotan sus fuerzas
        Pais argentina = new Pais("argentina");
        Pais chile = new Pais("chile");

        jugador1.ocupa(argentina);
        jugador2.ocupa(chile);


        jugador1.ocupa(chile);


        assertTrue(jugador2.tieneFuerzasEn(chile));
    }

    @Test
    public void siUnJugadorTrataDeOcuparUnPaisSinTenerFuerzasRestantesSeLanzaExcepcion(){
        Executable excepcion =  () -> {
          Jugador jugador1 = new Jugador();
          Pais argentina = new Pais("argentina");
          Pais chile = new Pais("chile");

          jugador1.ocuparCon(argentina, 10);
          jugador1.ocupa(chile);
        };

        assertThrows(NoHayFuerzasRestantes.class, excepcion);
    }


}
