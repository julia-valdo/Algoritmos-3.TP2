package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertEquals(6,argentina.getCantidadDeEjercitos());
    }

    @Test
    public void creoDosPaisesLimitrofesYVerificoQueLoSean(){
        Pais argentina = new Pais("Argentina");
        Pais chile = new Pais("Chile");
        argentina.agregarPaisesConectados(chile);
        chile.agregarPaisesConectados(argentina);

        assertTrue(argentina.esLimitrofe(chile));
    }

    @Test
    public void creoDosPaisesQuePertenezcanAlMismoJugadorYVerificoQueLoSean(){
        Pais argentina = new Pais("Argentina");
        Pais chile = new Pais("Chile");
        argentina.setNumeroDelJugador(1);
        chile.setNumeroDelJugador(1);

        assertTrue(argentina.esDelMismoEquipo(chile));
    }
}
