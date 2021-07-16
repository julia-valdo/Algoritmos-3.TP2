package edu.fiuba.algo3.modelo;

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
        Pais argentina = new Pais("Argentina");
        argentina.agregarEjercito(5);

        assertEquals(5,argentina.getCantidadDeEjercitos());
    }

    @Test
    public void creoDosPaisesLimitrofesYVericoQueSePuedenAtacar(){
        Executable excepcion = () -> {
            Pais argentina = new Pais("Argentina");
            Pais chile = new Pais("Chile");
            chile.agregarEjercito(2);
            argentina.agregarEjercito(2);
            argentina.agregarPaisesConectados(chile);
            chile.agregarPaisesConectados(argentina);
            chile.atacarA(argentina);
        };

        assertDoesNotThrow(excepcion);
    }

    @Test
    public void creoDosPaisesQuePertenezcanAlMismoJugadorYVerificoQueNoSePuedenAtacar(){
        Executable excepcion = () -> {
            Jugador jugador1 = new Jugador();
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
            Jugador jugador1 = new Jugador();
            Jugador jugador2 = new Jugador();
            Pais argentina = new Pais("Argentina");
            Pais chile = new Pais("Chile");
            argentina.agregarPaisesConectados(chile);
            chile.agregarPaisesConectados(argentina);
            jugador1.ocuparCon(chile, 3);
            jugador2.ocuparCon(argentina, 3);

            chile.atacarA(argentina);
        };

        assertDoesNotThrow(excepcion);
    }
}
