package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoPermitidoError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class PaisTest {
    @Test
    public void creoUnPaisYVerificoSuNombre(){
        Pais argentina = new Pais("Argentina");

        assertEquals("Argentina",argentina.getNombreDelPais());
    }

    @Test
    public void creoUnPaisYAgregoEjercitos(){
        Jugador jugador1 = new Jugador(1);
        jugador1.agregarFichas(6);
        Pais argentina = new Pais("Argentina");
        jugador1.ocupa(argentina);
        argentina.agregarEjercito(5);

        assertEquals(6,argentina.getCantidadDeEjercitos());
    }

    @Test
    public void creoDosPaisesLimitrofesYVericoQueSePuedenAtacar(){
        Executable excepcion = () -> {
            Jugador jugador1 = new Jugador(1);
            Jugador jugador2 = new Jugador(2);
            jugador1.agregarFichas(1);
            jugador2.agregarFichas(1);
            Pais argentina = new Pais("Argentina");
            Pais chile = new Pais("Chile");
            jugador1.ocupa(argentina);
            jugador2.ocupa(chile);
            chile.agregarEjercito(2);
            argentina.agregarEjercito(2);
            argentina.agregarPaisConectado(chile);
            chile.agregarPaisConectado(argentina);
            chile.atacarA(argentina);
        };

        assertDoesNotThrow(excepcion);
    }

    @Test
    public void creoDosPaisesQuePertenezcanAlMismoJugadorYVerificoQueNoSePuedenAtacar(){
        Executable excepcion = () -> {
            Jugador jugador1 = new Jugador(1);
            jugador1.agregarFichas(2);
            Pais argentina = new Pais("Argentina");
            Pais chile = new Pais("Chile");
            jugador1.ocupa(argentina);
            jugador1.ocupa(chile);
            chile.atacarA(argentina);
        };

        assertThrows(AtaqueNoPermitidoError.class, excepcion);
    }

    @Test
    public void creoDosPaisesQueNoPertenezcanAlMismoJugadorYVerificoQueSePuedenAtacar(){
        Executable excepcion = () -> {
            Jugador jugador1 = new Jugador(1);
            Jugador jugador2 = new Jugador(2);
            jugador1.agregarFichas(3);
            jugador2.agregarFichas(3);
            Pais argentina = new Pais("Argentina");
            Pais chile = new Pais("Chile");
            argentina.agregarPaisConectado(chile);
            chile.agregarPaisConectado(argentina);
            jugador1.ocuparCon(chile, 3);
            jugador2.ocuparCon(argentina, 3);

            chile.atacarA(argentina);
        };

        assertDoesNotThrow(excepcion);
    }
}
