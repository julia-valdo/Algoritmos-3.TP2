package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjetivoTest {
    @Test
    public void creoUnObjetivoYNoLoCumplo(){
        Pais japon = new Pais("Japon");
        Pais china = new Pais("China");
        Pais kamchatka = new Pais("Kamchatcka");

        Continente asia = new Continente("asia");
        asia.agregarPais(japon);
        asia.agregarPais(china);
        asia.agregarPais(kamchatka);

        Continente americaDelSur = new Continente("america del sur");

        Objetivo conquistarContinente = new ObjetivoConquistar(asia, americaDelSur, 0);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(japon);

        assertFalse(conquistarContinente.objetivoCumplido(paises));
    }

    @Test
    public void creoUnObjetivoYLoCumplo(){
        Pais japon = new Pais("Japon");
        Pais china = new Pais("China");
        Pais kamchatka = new Pais("Kamchatcka");

        Continente asia = new Continente("asia");
        asia.agregarPais(japon);
        asia.agregarPais(china);
        asia.agregarPais(kamchatka);

        Continente americaDelSur = new Continente("america del sur");

        Objetivo conquistarContinente = new ObjetivoConquistar(asia, americaDelSur, 0);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(japon);
        paises.add(china);
        paises.add(kamchatka);
        assertTrue(conquistarContinente.objetivoCumplido(paises));
    }

    @Test
    public void creoUnObjetivoYNoLoCumploConContinenteYPais(){
        Pais japon = new Pais("Japon");
        Pais china = new Pais("China");
        Pais kamchatka = new Pais("Kamchatcka");
        Pais argentina = new Pais("Argentina");

        Continente asia = new Continente("asia");
        asia.agregarPais(japon);
        asia.agregarPais(china);
        asia.agregarPais(kamchatka);

        Continente americaDelSur = new Continente("america del sur");
        americaDelSur.agregarPais(argentina);

        Objetivo conquistarContinente = new ObjetivoConquistar(asia, americaDelSur, 1);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(japon);
        paises.add(china);
        paises.add(kamchatka);
        assertFalse(conquistarContinente.objetivoCumplido(paises));
    }

    @Test
    public void creoUnObjetivoYLoCumploConContinenteYPais(){
        Pais japon = new Pais("Japon");
        Pais china = new Pais("China");
        Pais kamchatka = new Pais("Kamchatcka");
        Pais argentina = new Pais("Argentina");

        Continente asia = new Continente("asia");
        asia.agregarPais(japon);
        asia.agregarPais(china);
        asia.agregarPais(kamchatka);

        Continente americaDelSur = new Continente("america del sur");
        americaDelSur.agregarPais(argentina);

        Objetivo conquistarContinente = new ObjetivoConquistar(asia, americaDelSur, 1);

        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(japon);
        paises.add(china);
        paises.add(kamchatka);
        paises.add(argentina);
        assertTrue(conquistarContinente.objetivoCumplido(paises));
    }

    @Test
    public void objetivoDerrotarAlJugadorNoseCumpleAlPrincipio(){
        Jugador jugador = new Jugador(1);

        Pais japon = new Pais("Japon");
        Pais china = new Pais("China");
        Pais kamchatka = new Pais("Kamchatcka");

        ArrayList<Pais> paises = new ArrayList<>();

        paises.add(japon);
        paises.add(china);
        paises.add(kamchatka);

        Objetivo derrotarJugador1 = new ObjetivoDerrotar(jugador);

        assertFalse(derrotarJugador1.objetivoCumplido(paises));
    }

    @Test
    public void objetivoDerrotarAlJugadorSeCumpleAlPerderElultimoPaisConquistado(){
        Jugador jugador = new Jugador(1);
        jugador.agregarFichas(1);
        Objetivo derrotarJugador1 = new ObjetivoDerrotar(jugador);

        Pais japon = new Pais("Japon");
        jugador.ocupa(japon);
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(japon);
        jugador.perdisteA(japon);

        assertTrue(derrotarJugador1.objetivoCumplido(paises));
    }

}
