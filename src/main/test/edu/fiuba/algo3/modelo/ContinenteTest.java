package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContinenteTest {
    @Test
    public void creoContinenteYNoLoConquisto(){
        Continente asia = new Continente("asia", 7);
        Pais japon = new Pais("Japon");
        Pais china = new Pais("china");

        asia.agregarPais(japon);
        asia.agregarPais(china);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(japon);

        assertFalse(asia.fueConquistado(paises));
    }

    @Test
    public void creoContinenteYLoConquisto(){
        Continente asia = new Continente("asia", 7);
        Pais japon = new Pais("Japon");
        Pais china = new Pais("china");

        asia.agregarPais(japon);
        asia.agregarPais(china);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(japon);
        paises.add(china);
        assertTrue(asia.fueConquistado(paises));
    }

    @Test
    public void creoContinenteYLoConquistoConMasPaises(){
        Continente asia = new Continente("asia", 7);
        Pais japon = new Pais("Japon");
        Pais china = new Pais("China");
        Pais argentina = new Pais("Argentina");

        asia.agregarPais(japon);
        asia.agregarPais(china);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(japon);
        paises.add(china);
        paises.add(argentina);

        assertTrue(asia.fueConquistado(paises));
    }
}
