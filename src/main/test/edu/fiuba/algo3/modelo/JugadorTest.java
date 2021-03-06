package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Excepciones.NoHayFuerzasRestantesError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


public class JugadorTest {


    @Test
    public void unJugadorPuedeOcuparUnPaisConEjercitosDerrotados(){
        Jugador jugador1 = new Jugador(1);
        jugador1.agregarFichas(1);
        Pais argentina = new Pais("argentina");

        jugador1.ocupa(argentina);//Argentina empieza con ejercitos derrotados


        assertNotEquals(0, argentina.getCantidadDeEjercitos());

    }

    @Test
    public void unJugadorNoPuedeOcuparUnPaisConEjercitosEnPie(){
        Jugador jugador1 = new Jugador(1);
        Jugador jugador2 = new Jugador(2); //no se derrotan sus fuerzas
        jugador1.agregarFichas(10);
        jugador2.agregarFichas(10);
        Pais argentina = new Pais("argentina");
        Pais chile = new Pais("chile");
        chile.agregarPaisConectado(argentina);
        argentina.agregarPaisConectado(chile);

        jugador1.ocupa(argentina);
        jugador2.ocupa(chile);
        jugador1.agregarFichasA(5,argentina);

        jugador1.ocupa(chile);

        Executable noExcepcion = () -> {
            jugador1.atacarPaisDesdeA(argentina, chile);
        };
        //Como no lo ocupa, lo puede atacar
        assertDoesNotThrow(noExcepcion);
    }

    @Test
    public void siUnJugadorTrataDeOcuparUnPaisSinTenerFuerzasRestantesSeLanzaExcepcion(){
        Executable excepcion =  () -> {
          Jugador jugador1 = new Jugador(1);
          jugador1.agregarFichas(10);
          Pais argentina = new Pais("argentina");
          Pais chile = new Pais("chile");

          jugador1.ocuparCon(argentina, 10);
          jugador1.ocupa(chile);
        };

        assertThrows(NoHayFuerzasRestantesError.class, excepcion);
    }

    @Test
    public void unJugadorNoPierdeFichasSiLaOcupacionDeUnPaisNoEsExitosa(){
        Jugador unJugador = new Jugador(1);
        Jugador otroJugador = new Jugador(2);

        unJugador.agregarFichas(1);
        otroJugador.agregarFichas(1);

        Pais argentina = new Pais("Argentina");
        Pais chile = new Pais("Chile");

        unJugador.ocupa(argentina);

        otroJugador.ocupa(argentina);

        Executable puedeOcuparChile = () -> {
            otroJugador.ocupa(chile);
        };

        assertDoesNotThrow(puedeOcuparChile);
    }


}
