package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class IntegracionTest {

    @Test
    public void ataqueEntreDosJugadoresYGanaElAtacante(){
        Jugador atacante = new Jugador(1);
        Jugador defensor = new Jugador(2);

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisConectado(china);
        china.agregarPaisConectado(kamchatka);
        atacante.agregarFichas(80);
        defensor.agregarFichas(1);

        atacante.ocuparCon(kamchatka, 80);
        defensor.ocuparCon(china, 1);

        try{
            while(true) atacante.atacarPaisDesdeA(kamchatka, china);
        }catch(RuntimeException excepcion){
            assertEquals("No se puede atacar a un pais del mismo equipo", excepcion.getMessage());
        }

    }


    @Test
    public void ataqueEntreDosJugadoresYGanaElDefensor(){
        Jugador atacante = new Jugador(1);
        Jugador defensor = new Jugador(2);

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisConectado(china);
        china.agregarPaisConectado(kamchatka);
        defensor.agregarFichas(80);
        atacante.agregarFichas(5);

        atacante.ocuparCon(kamchatka, 5);
        defensor.ocuparCon(china, 80);

        atacante.atacarPaisDesdeA(kamchatka, china);

        Executable noExcepcion = () ->{
            atacante.atacarPaisDesdeA(kamchatka, china);
        };
        //Como no lo ocupo, lo puede volver a atacar
        assertDoesNotThrow(noExcepcion);

    }

}

