package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
<<<<<<< HEAD
=======
import static org.junit.jupiter.api.Assertions.assertTrue;
>>>>>>> 8e319831bdf454fe9e654daaa03357e2cec10b0e


public class ParseoTest {

    @Test
    public void parsearAmbosArchivos() {
        //Este test tiene que cambiarse con el Facade pattern, esta implementado como interfaz para probar nomas

        ParserJson parserBienPiola = new ParserJson();
        parserBienPiola.parsearArchivo("Teg - Cartas.json");
        parserBienPiola.parsearArchivo("Teg - Fronteras.json");

        ArrayList<Carta> cartas  = parserBienPiola.getCartas();
        Collection<Continente> continentes = parserBienPiola.getContinentes();
        Collection<Pais> paises = parserBienPiola.getPaises();

        for (Continente continente : continentes) {
            if ((continente.getNombre()).equals("Asia")){
                assertEquals(15, continente.cantidadPaisesQueMeConforman());
            }
            if ((continente.getNombre()).equals("Europa")){
                assertEquals(9, continente.cantidadPaisesQueMeConforman());
            }
            if ((continente.getNombre()).equals("America del Norte")){
                assertEquals(10, continente.cantidadPaisesQueMeConforman());
            }
            if ((continente.getNombre()).equals("America del Sur")){
                assertEquals(6, continente.cantidadPaisesQueMeConforman());
            }
            if ((continente.getNombre()).equals("Oceania")){
                assertEquals(4, continente.cantidadPaisesQueMeConforman());
            }
            if ((continente.getNombre()).equals("Africa")){
                assertEquals(6, continente.cantidadPaisesQueMeConforman());
            }

        }
        assertEquals(50, cartas.size());
        assertEquals(50, paises.size());

    }

<<<<<<< HEAD

=======
>>>>>>> 8e319831bdf454fe9e654daaa03357e2cec10b0e
}
