package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegracionTest {

    @Test
    public void ataqueEntreDosJugadoresYGanaElAtacante(){
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisesConectados(china);
        china.agregarPaisesConectados(kamchatka);
        atacante.agregarFichas(70);

        atacante.ocuparCon(kamchatka, 80);
        defensor.ocuparCon(china, 1);

        while(defensor.tieneFuerzasEn(china)) atacante.atacarPaisDesdeA(kamchatka, china);

        assertTrue(atacante.tieneFuerzasEn(china));


    }


    @Test
    public void ataqueEntreDosJugadoresYGanaElDefensor(){
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisesConectados(china);
        china.agregarPaisesConectados(kamchatka);
        defensor.agregarFichas(70);

        atacante.ocuparCon(kamchatka, 4);
        defensor.ocuparCon(china, 80);

        atacante.atacarPaisDesdeA(kamchatka, china);

        assertFalse(atacante.tieneFuerzasEn(china));

    }

}

