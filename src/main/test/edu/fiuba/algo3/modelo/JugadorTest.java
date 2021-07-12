package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


public class JugadorTest {


    @Test
    public void despuesDeUnAtaqueExitosoElPaisCambiaDeJugador(){
        Jugador jugador1 = new Jugador(3);
        Jugador jugador2 = new Jugador(0); //Las fuerzas de este ya estan derrotadas
        Pais argentina = new Pais();
        Pais chile = new Pais();

        jugador1.ocupa(argentina);
        jugador2.ocupa(chile);

        jugador1.atacarA(chile);

        assertFalse(jugador2.tieneFuerzasEn(chile));

    }

    @Test
    public void despuesDeUnAtaqueFalladoUnPaisNoCambiaDeJugador(){
        Jugador jugador1 = new Jugador(3);
        Jugador jugador2 = new Jugador(3); //no se derrotan sus fuerzas
        Pais argentina = new Pais();
        Pais chile = new Pais();

        jugador1.ocupa(argentina);
        jugador2.ocupa(chile);

        jugador1.atacarA(chile);

        assertTrue(jugador2.tieneFuerzasEn(chile));
    }
}
