package edu.fiuba.algo3.PrimeraIteracion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InicialesTest {
    @Test
    public void test01ColocarEjercitos() {

        Pais pais = new Pais("Argentina", "Celeste");
        pais.agregarPaisesConectados("Chile");
        pais.agregarEjercito(3);

        assertEquals(3, pais.getEjercitos());
    }

    @Test
    public void test02AtacarEntrePaisesYElDefensorEsElGanador() {

        Pais paisUno = new Pais("Argentina", "Celeste");
        Pais paisDos = new Pais("Chile", "Rojo");
        Dado dadoAtacante = new Dado(2);
        Dado dadoDefensor = new Dado(3);

        paisUno.agregarPaisesConectados("Chile");
        paisDos.agregarPaisesConectados("Argentina");

        assertTrue(paisUno.puedoAtacarA(paisDos)); //Chequeo que pueda atacar correctamente

        paisUno.agregarEjercito(2);
        paisDos.agregarEjercito(5);

        dadoAtacante.tiradasPerdedoras();
        dadoDefensor.tiradasGanadoras();

        paisDos.defenderseDeCon(paisUno, dadoAtacante, dadoDefensor);
        assertEquals(5, paisDos.getEjercitos()); //Chequeo que la defensa haya sido un exito


    }

    @Test
    public void test03AtacarEntrePaisesYElAtacanteEsElGanadorYTomoElPais() {

        Pais argentina = new Pais("Argentina", "Celeste");
        Pais chile = new Pais("Chile", "Rojo");

        argentina.agregarEjercito(5);
        chile.agregarEjercito(1);

        Dado dadoAtacante = new Dado(3);
        Dado dadoDefensor = new Dado(1);

        argentina.agregarPaisesConectados("Chile");
        chile.agregarPaisesConectados("Argentina");

        assertTrue(argentina.puedoAtacarA(chile)); //Chequeo que pueda atacar correctamente

        dadoAtacante.tiradasGanadoras();
        dadoDefensor.tiradasPerdedoras();

        chile.defenderseDeCon(argentina, dadoAtacante, dadoDefensor);
        assertEquals(1, chile.getEjercitos());
        assertEquals("Celeste", chile.getColorDelPais()); //Chequeo el ataque haya sido un exito


    }
}
