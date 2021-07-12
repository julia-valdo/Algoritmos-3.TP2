package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EjercitosTest {
    @Test
    public void creoEjercitoYDebeTenerCero(){
        Ejercitos ejercito = new Ejercitos();

        assertEquals(1, ejercito.getCantidadEjercitos());
    }

    @Test
    public void creoEjercitoYAgregoEjercito(){
        Ejercitos ejercito = new Ejercitos();
        ejercito.agregarEjercitos(5);
        assertEquals(6, ejercito.getCantidadEjercitos());
    }

    @Test
    public void creoEjercitoYAgregoEjercitoYResto(){
        Ejercitos ejercito = new Ejercitos();
        ejercito.agregarEjercitos(5);
        ejercito.restarEjercitos(2);
        assertEquals(4, ejercito.getCantidadEjercitos());
    }

    @Test
    public void creoEjercitoYAgregoEjercitoYLosEliminoATodosEntoncesFueDerrotado(){
        Ejercitos ejercito = new Ejercitos();
        ejercito.agregarEjercitos(5);
        ejercito.restarEjercitos(6);
        assertTrue(ejercito.fueDerrotado());
    }
}
