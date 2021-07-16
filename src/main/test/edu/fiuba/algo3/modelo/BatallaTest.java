package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BatallaTest {

    @Test
    public void ataqueEntrePaisesConElDefensorComoGanador() {

        Ejercitos kamchatka = new Ejercitos(2, new Jugador());
        Ejercitos china = new Ejercitos(70, new Jugador());

        Batalla batalla = new Batalla();
        batalla.atacar(kamchatka, china);

        assertNotEquals(0, china.getCantidadEjercitos());

    }

    @Test
    public void ataqueEntrePaisesConElAtacanteComoGanador() {

        Ejercitos kamchatka = new Ejercitos(70, new Jugador());
        Ejercitos china = new Ejercitos(1, new Jugador());

        Batalla batalla = new Batalla();
        batalla.atacar(kamchatka, china);

        while (china.getCantidadEjercitos() != 0) batalla.atacar(kamchatka, china);
        assertEquals(0, china.getCantidadEjercitos());

    }

}
