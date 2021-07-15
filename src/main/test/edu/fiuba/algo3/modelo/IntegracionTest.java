package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegracionTest {

    @Test
    public void ataqueEntreDosJugadoresYGanaCualquieraDeLosDos(){
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisesConectados(china);
        china.agregarPaisesConectados(kamchatka);

        atacante.ocuparCon(kamchatka, 4);
        defensor.ocuparCon(china, 1);

        atacante.atacarPaisDesdeA(kamchatka, china);

        assertGanoAlguien(atacante, defensor, china);


    }


    private void assertGanoAlguien(Jugador atacante, Jugador defensor, Pais enDisputa){
        if(atacante.tieneFuerzasEn(enDisputa)){
            System.out.println("gano el atacante");

        }
        else if (defensor.tieneFuerzasEn(enDisputa)){
            System.out.println("Gano el defensor");
        }
        else{
            throw new RuntimeException();
        }
    }
}

