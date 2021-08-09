package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Excepciones.CanjesError;
import edu.fiuba.algo3.modelo.Excepciones.NoHayFuerzasRestantesError;
import edu.fiuba.algo3.modelo.Excepciones.NoQuedanCartasError;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class CanjeoDeCartasTest {

    @Test
    public void unJugadorConTresGlobosAlCanjearlosPuedePoner4FichasEnElPaisQueOcupa(){
        Jugador jugador1 = new Jugador(1);
        Carta globoUno = new Carta(new Pais("Francia"), "Globo");
        Carta globoDos = new Carta(new Pais("Chile"), "Globo");
        Carta globoTres = new Carta(new Pais("Etiopia"), "Globo");
        Pais argentina = new Pais("Argentina");

        jugador1.agregarFichas(1);
        jugador1.ocupa(argentina);


        jugador1.recibirCarta(globoUno);
        jugador1.recibirCarta(globoDos);
        jugador1.recibirCarta(globoTres);


        jugador1.canjearCartas(globoUno, globoDos, globoTres);

        Executable puedoPonerTresFichasMas = () -> {
          jugador1.agregarFichasA(3, argentina);
        };

        assertDoesNotThrow(puedoPonerTresFichasMas);
    }

    @Test
    public void unJugadorNoPuedeCambiarCartasQueNoLeFueronRepartidas(){
        Jugador jugador1 = new Jugador(0);
        Carta globoUno = new Carta(new Pais("Francia"), "Globo");
        Carta globoDos = new Carta(new Pais("Chile"), "Globo");
        Carta globoTres = new Carta(new Pais("Etiopia"), "Globo");
        Pais argentina = new Pais("Argentina");

        jugador1.canjearCartas(globoUno, globoDos, globoTres);

        Executable noPuedePonerMasFichas = () -> {
            jugador1.ocuparCon(argentina, 1);
        };

        assertThrows(NoHayFuerzasRestantesError.class, noPuedePonerMasFichas);

    }

    @Test
    public void alRepartirCartasElInventarioSeQuedaSinCartas(){
        Jugador jugador1 = new Jugador(1);
        Carta globoUno = new Carta(new Pais("Francia"), "Globo");
        Carta globoDos = new Carta(new Pais("Chile"), "Globo");
        Carta globoTres = new Carta(new Pais("Etiopia"), "Globo");
        ArrayList<Carta> mazoDeCartas = new ArrayList<>();
        mazoDeCartas.add(globoUno); mazoDeCartas.add(globoDos);mazoDeCartas.add(globoTres);

        InventarioDeJuego inventario = new InventarioDeJuego(mazoDeCartas, new ArrayList<>());

        inventario.repartirCarta(jugador1);
        inventario.repartirCarta(jugador1);
        inventario.repartirCarta(jugador1);

        Executable noHayMasCartas = () -> {
            inventario.repartirCarta(jugador1);
        };

        assertThrows(NoQuedanCartasError.class, noHayMasCartas);

    }

    @Test
    public void alCanjearTresCartasVuelvenAlMazo(){
        Jugador jugador1 = new Jugador(1);
        Carta globoUno = new Carta(new Pais("Francia"), "Globo");
        Carta globoDos = new Carta(new Pais("Chile"), "Globo");
        Carta globoTres = new Carta(new Pais("Etiopia"), "Globo");
        Pais unPais = new Pais("Angola");
        ArrayList<Carta> mazoDeCartas = new ArrayList<>();
        mazoDeCartas.add(globoUno); mazoDeCartas.add(globoDos);mazoDeCartas.add(globoTres);

        InventarioDeJuego inventario = new InventarioDeJuego(mazoDeCartas, new ArrayList<>());

        inventario.repartirCarta(jugador1);
        inventario.repartirCarta(jugador1);
        inventario.repartirCarta(jugador1);

        jugador1.canjearCartas(globoUno, globoDos, globoTres);

        inventario.repartirCarta(jugador1);
        inventario.repartirCarta(jugador1);
        inventario.repartirCarta(jugador1);

        jugador1.canjearCartas(globoUno,globoDos,globoTres);

        //Canjeo dos veces las mismas cartas, 4 + 7 = 11 fichas disponibles

        Executable puedePoner11Fichas = () -> {
            jugador1.ocuparCon(unPais, 11);
        };

        assertDoesNotThrow(puedePoner11Fichas);


    }


    @Test
    public void jugadorCanjeaCartaDePaisQueOcupaYLeAgregaDosEjercitos(){
        Jugador jugador1 = new Jugador(1);
        jugador1.agregarFichas(1);
        Pais argentina = mock(Pais.class);
        Carta cartaArgentina = new Carta(argentina, "Globo");
        //Armo el mock
        doAnswer(invocationOnMock -> {
            jugador1.ocupasteA(argentina);
            return null;
        }).when(argentina).recibirTropas(any());

        jugador1.ocupa(argentina);
        jugador1.recibirCarta(cartaArgentina);


        jugador1.canjearCarta(cartaArgentina);

        //Compruebo que se haya llamado al metodo recibirFuerzasAliadas
        verify(argentina, times(1)).agregarEjercito(2);


    }

    @Test
    public void alCanjearGruposDeCartasSucesivamenteAgregaBienLaCantidadDeFichasAJugador(){
        Jugador jugador1 = new Jugador(1);
        Pais chile = new Pais("chile");
        Carta globoUno = new Carta(new Pais("Francia"), "Globo");
        Carta globoDos = new Carta(new Pais("Chile"), "Globo");
        Carta globoTres = new Carta(new Pais("Etiopia"), "Globo");
        //Dejo al jugador sin fichas
        jugador1.agregarFichas(1);
        jugador1.ocupa(chile);

        //4->7->10->(n-1)*5 si canjeo 5 veces entonces sumo 56 ejercitos
        for(int i = 0; i < 5; i++){
            jugador1.recibirCarta(globoUno);
            jugador1.recibirCarta(globoDos);
            jugador1.recibirCarta(globoTres);
            jugador1.canjearCartas(globoUno,globoDos,globoTres);
        }

        Executable puedoPoner56Cartas = () -> {
          jugador1.agregarFichasA(56, chile);
        };
        Executable noPuedoPonerUnaMas = () -> {
            jugador1.agregarFichasA(1, chile);
        };

        assertDoesNotThrow(puedoPoner56Cartas);
        assertThrows(NoHayFuerzasRestantesError.class, noPuedoPonerUnaMas);

    }

    @Test
    public void seRealizaElCanjeTambienCuandoLasTresCartasSonDiferentes(){
        Jugador jugador1 = new Jugador(1);
        Pais chile = new Pais("chile");
        Carta cartaGlobo = new Carta(new Pais("Francia"), "Globo");
        Carta cartaBarco = new Carta(new Pais("Chile"), "Barco");
        Carta cartaCanon = new Carta(new Pais("Etiopia"), "Cañon");

        jugador1.agregarFichas(1);
        jugador1.ocupa(chile);

        jugador1.recibirCarta(cartaGlobo);
        jugador1.recibirCarta(cartaBarco);
        jugador1.recibirCarta(cartaCanon);

        jugador1.canjearCartas(cartaBarco, cartaCanon, cartaGlobo);

        Executable puedoAgregar4FichasAChile = () -> {
            jugador1.agregarFichasA(4, chile);
        };

        assertDoesNotThrow(puedoAgregar4FichasAChile);


    }

    @Test
    public void alCanjearUnaCartaDeUnPaisQueNoOcupaNoAumentanLasFuerzasEnEsePaisYLanzaExcepcion(){

        Jugador jugador1 = new Jugador(1);
        jugador1.agregarFichas(10);
        Carta cartaFrancia = new Carta(new Pais("Francia"), "Globo");
        Pais argentina = this.armarMockPaisPara(jugador1);

        jugador1.ocupa(argentina);
        jugador1.recibirCarta(cartaFrancia);

        try{
            jugador1.canjearCarta(cartaFrancia);
        } catch (Exception e){
            assertEquals(e.getClass(), CanjesError.class);
        }

        //Compruebo que se haya llamado al metodo recibirFuerzasAliadas
        verify(argentina, times(0)).agregarEjercito(2);
    }

    @Test
    public void alCanjearCartasQueNoTienenElMismoSimboloNoSeAgreganFichasAlJugadorYLanzaExcepcion(){
        Jugador jugador1 = new Jugador(1);
        Pais chile = new Pais("chile");
        Carta barcoUno = new Carta(new Pais("Francia"), "Barco");
        Carta globoUno = new Carta(new Pais("Chile"), "Globo");
        Carta globoDos = new Carta(new Pais("Etiopia"), "Globo");

        jugador1.agregarFichas(1);
        jugador1.ocupa(chile);

        jugador1.recibirCarta(barcoUno);
        jugador1.recibirCarta(globoUno);
        jugador1.recibirCarta(globoDos);
        try{
            jugador1.canjearCartas(barcoUno, globoUno, globoDos);
        } catch (Exception e){
            assertEquals(e.getClass(), CanjesError.class);
        }


        Executable noTieneMasFichas = () -> {
            jugador1.agregarFichasA(1, chile);
        };

        assertThrows(NoHayFuerzasRestantesError.class, noTieneMasFichas);
    }

    @Test
    public void siSeCanjeaDosVecesUnaMismaCartaLaSegundaVezNoSeSumanEjercitosYLanzaExcepcion(){
        Jugador jugador1 = new Jugador(0);
        Pais argentina = this.armarMockPaisPara(jugador1);
        Carta cartaArgentina = new Carta(argentina, "Globo");
        jugador1.agregarFichas(1);
        jugador1.ocupa(argentina);
        jugador1.recibirCarta(cartaArgentina);

        try{
            jugador1.canjearCarta(cartaArgentina);
        } catch (Exception e){
            assertEquals(e.getClass(), CanjesError.class);
        }

        verify(argentina, times(1)).agregarEjercito(2);

    }


    private Pais armarMockPaisPara(Jugador unJugador){
        Pais argentina = mock(Pais.class);
        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                unJugador.ocupasteA(argentina);
                return null;
            }
        }).when(argentina).recibirTropas(any());

        return argentina;
    }


}
