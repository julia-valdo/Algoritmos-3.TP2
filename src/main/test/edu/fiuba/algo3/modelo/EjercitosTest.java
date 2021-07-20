package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EjercitosTest {
    @Test
    public void creoEjercitoYDebeTenerCero(){
        Ejercitos ejercito = new Ejercitos();

        assertEquals(0, ejercito.getCantidadEjercitos());
    }

    @Test
    public void creoEjercitoYAgregoEjercito(){
        Ejercitos ejercito = new Ejercitos(1, new Jugador(1));
        ejercito.agregarEjercitos(4);
        assertEquals(5, ejercito.getCantidadEjercitos());
    }

    @Test
    public void creoEjercitoYAgregoEjercitoYResto(){
        Ejercitos ejercito = new Ejercitos(1, new Jugador(1));
        ejercito.agregarEjercitos(5);
        ejercito.restarEjercitos(3);
        assertEquals(3, ejercito.getCantidadEjercitos());
    }

    @Test
    public void creoEjercitoYAgregoEjercitoYLosEliminoATodosEntoncesFueDerrotado(){
        Ejercitos ejercito = new Ejercitos(1, new Jugador(1));
        ejercito.agregarEjercitos(4);
        ejercito.restarEjercitos(5);
        assertEquals(0, ejercito.getCantidadEjercitos());
    }

    @Test
    public void siSeTrataDeRestarEjercitosDeUnosDerrotadosSeLanzaExcepcion(){
        Executable excepcion = () -> {
            Ejercitos ejercitos = new Ejercitos();
            ejercitos.restarEjercitos(1);
        };

        assertThrows(NoHayFuerzasRestantesError.class, excepcion);

    }

    @Test
    public void siSeTrataDeRestarMasFuerzasDeLasQueHayEntoncesSeLanzaExcepcion(){
        Executable excepcion = () -> {
            Ejercitos ejercitos = new Ejercitos(2, new Jugador(1));
            ejercitos.restarEjercitos(3);
        };

        assertThrows(NoHayFuerzasRestantesError.class, excepcion);
    }
}
