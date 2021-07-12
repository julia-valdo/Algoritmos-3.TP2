package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EjercitosTest {
    @Test
    public void creoEjercitoYDebeTenerCero(){
        Ejercitos ejercito = new Ejercitos();

        assertEquals(0, ejercito.getCantidadEjercitos());
    }

    @Test
    public void creoEjercitoYAgregoEjercito(){
        Ejercitos ejercito = new Ejercitos();
        ejercito.agregarEjercitos(5);
        assertEquals(5, ejercito.getCantidadEjercitos());
    }

    @Test
    public void creoEjercitoYAgregoEjercitoYResto(){
        Ejercitos ejercito = new Ejercitos();
        ejercito.agregarEjercitos(5);
        ejercito.restarEjercitos(2);
        assertEquals(3, ejercito.getCantidadEjercitos());
    }
}
