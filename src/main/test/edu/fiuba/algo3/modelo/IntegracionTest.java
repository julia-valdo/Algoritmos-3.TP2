package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Cartas.Mazo;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Juego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegracionTest {

    @Test
    public void ataqueEntreDosJugadoresYGanaElAtacante(){
        Jugador atacante = new Jugador(1);
        Jugador defensor = new Jugador(2);

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisConectado(china);
        china.agregarPaisConectado(kamchatka);
        atacante.agregarFichas(80);
        defensor.agregarFichas(1);

        atacante.ocuparCon(kamchatka, 80);
        defensor.ocuparCon(china, 1);

        try{
            while(true) atacante.atacarPaisDesdeA(kamchatka, china);
        }catch(RuntimeException excepcion){
            assertEquals("No se puede atacar a un pais del mismo equipo", excepcion.getMessage());
        }

    }


    @Test
    public void ataqueEntreDosJugadoresYGanaElDefensor(){
        Jugador atacante = new Jugador(1);
        Jugador defensor = new Jugador(2);

        Pais kamchatka = new Pais("Kamchatka");
        Pais china = new Pais("China");

        kamchatka.agregarPaisConectado(china);
        china.agregarPaisConectado(kamchatka);
        defensor.agregarFichas(80);
        atacante.agregarFichas(5);

        atacante.ocuparCon(kamchatka, 5);
        defensor.ocuparCon(china, 80);

        atacante.atacarPaisDesdeA(kamchatka, china);

        Executable noExcepcion = () ->{
            atacante.atacarPaisDesdeA(kamchatka, china);
        };
        //Como no lo ocupo, lo puede volver a atacar
        assertDoesNotThrow(noExcepcion);

    }

    @Test
    public void alPerderUnaBatallaElJugadorNoPuedePedirUnaCarta(){
        Jugador jugador1 = new Jugador(1);
        Jugador jugador2 = new Jugador(2);
        Pais holanda = new Pais("Holanda");
        Pais belgica = new Pais("Belgica");
        Carta cartaChina = new Carta(new Pais("China"), "Globo");
        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(cartaChina);
        InventarioDeJuego inventario = new InventarioDeJuego(cartas, new ArrayList<>());


        holanda.agregarPaisConectado(belgica);
        belgica.agregarPaisConectado(holanda);

        jugador1.agregarFichas(10);
        jugador1.ocuparCon(holanda, 10);

        jugador2.agregarFichas(3);
        jugador2.ocuparCon(belgica, 3);

        jugador2.atacarPaisDesdeA(belgica, holanda);

        jugador2.pedirCarta(inventario);

        assertTrue(inventario.quedanCartas());

    }

    @Test
    public void siUnJugadorConquistaUnPaisEntoncesPuedePedirUnaCarta(){
        Jugador jugador1 = new Jugador(1);
        Jugador jugador2 = new Jugador(2);
        Pais holanda = new Pais("Holanda");
        Pais belgica = new Pais("Belgica");
        Carta cartaChina = new Carta(new Pais("China"), "Globo");
        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.add(cartaChina);
        InventarioDeJuego inventario = new InventarioDeJuego(cartas, new ArrayList<>());


        holanda.agregarPaisConectado(belgica);
        belgica.agregarPaisConectado(holanda);

        jugador1.agregarFichas(80);
        jugador1.ocuparCon(holanda, 80);

        jugador2.agregarFichas(1);
        jugador2.ocuparCon(belgica, 1);

        try{
            while(true) jugador1.atacarPaisDesdeA(holanda, belgica);
        }catch(RuntimeException excepcion){
            jugador1.pedirCarta(inventario);
            assertFalse(inventario.quedanCartas());
        }

    }

    @Test
    public void alEmpezarLosNumerosDeLosJugadoresNoEstanOrdenados(){
        Juego teg = new Juego(6);
        ArrayList<Integer> unaLista = new ArrayList();
        for(int i = 1; i < 7; i++){
            unaLista.add(i);
        }

        assertFalse(teg.obtenerOrder().equals(unaLista));
    }

    @Test
    public void enUnJuegoCon2JugadoresCadaUnoTiene25Paises(){
        Juego teg = new Juego(2);

        Jugador primero = teg.obtenerSiguiente();
        Jugador segundo = teg.obtenerSiguiente();

        teg.iniciarJuego();

        boolean tienenLaMismaCantidadDePaises = primero.getPaisesOcupados().size() == segundo.getPaisesOcupados().size();
        boolean son25Paises = primero.getPaisesOcupados().size() == 25;

        assertTrue(tienenLaMismaCantidadDePaises && son25Paises);
    }

    @Test
    public void conDosJugadoresDespuesDelUltimoVuelveElPrimero(){
        Juego teg = new Juego(2);
        Jugador primero = teg.obtenerSiguiente();
        teg.obtenerSiguiente();
        Jugador deNuevoElPrimero = teg.obtenerSiguiente();

        assertSame(primero, deNuevoElPrimero);
    }

    @Test
    public void enLaPrimeraRondaLosJugadoresPuedenPoner5Fichas(){
        Juego teg = new Juego(2);

        teg.iniciarJuego();

        Jugador primero = teg.obtenerSiguienteEnTurno();
        Jugador segundo = teg.obtenerSiguienteEnTurno();



        Executable elPrimeroPuedePoner5Fichas = () -> {
            Pais unPais = primero.getPaisesOcupados().get(0);
            teg.seleccionDeJugador(primero, new SeleccionJugador(unPais, unPais, 5));
        };

        Executable elSegundoPuedePoner5Fichas = () -> {
            Pais otroPais = segundo.getPaisesOcupados().get(0);
            teg.seleccionDeJugador(segundo, new SeleccionJugador(otroPais, otroPais, 5));
        };

        assertDoesNotThrow(elPrimeroPuedePoner5Fichas);
        assertDoesNotThrow(elSegundoPuedePoner5Fichas);
    }

    @Test
    public void enLaSegundaFaseLosJugadoresPuedenPonerTresFichasMas(){
        Juego teg = new Juego(2);
        Pais unPaisDelPrimero, unPaisDelSegundo;
        teg.iniciarJuego();

        Jugador primero = teg.obtenerSiguienteEnTurno();
        Jugador segundo = teg.obtenerSiguienteEnTurno();
        unPaisDelPrimero = primero.getPaisesOcupados().get(0);
        unPaisDelSegundo = segundo.getPaisesOcupados().get(0);
        teg.seleccionDeJugador(primero, new SeleccionJugador(unPaisDelPrimero, unPaisDelPrimero, 5));
        teg.seleccionDeJugador(segundo, new SeleccionJugador(unPaisDelSegundo, unPaisDelSegundo, 5));



        Executable elPrimeroPuedePoner3Fichas = () -> {
            teg.obtenerSiguienteEnTurno();
            teg.seleccionDeJugador(primero, new SeleccionJugador(unPaisDelPrimero, unPaisDelPrimero, 3));
        };

        Executable elSegundoPuedePoner3Fichas = () -> {
            teg.obtenerSiguienteEnTurno();
            teg.seleccionDeJugador(segundo, new SeleccionJugador(unPaisDelSegundo, unPaisDelSegundo, 3));
        };

        assertDoesNotThrow(elPrimeroPuedePoner3Fichas);
        assertDoesNotThrow(elSegundoPuedePoner3Fichas);
    }

}

