package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegracionTest {
    @Test
    public void ataqueEntreDosJugadoresTestYGanaElAtacante(){
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisesConectados(china);
        china.agregarPaisesConectados(kamchatka);

        atacante.agregarFichas(60);

        atacante.ocuparCon(kamchatka, 70);
        defensor.ocupa(china);

       atacante.atacarPaisDesdeA(kamchatka, china);

        while (defensor.tieneFuerzasEn(china)) atacante.atacarPaisDesdeA(kamchatka, china);

        assertTrue(atacante.tieneFuerzasEn(china));

    }

    @Test
    public void ataqueEntreDosJugadoresTestYGanaElDefensor(){
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisesConectados(china);
        china.agregarPaisesConectados(kamchatka);

        defensor.agregarFichas(60);

        defensor.ocuparCon(china, 70);
        atacante.ocuparCon(kamchatka, 3);

        atacante.atacarPaisDesdeA(kamchatka, china);

        assertFalse(atacante.tieneFuerzasEn(china));

    }
}

