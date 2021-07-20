package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class CartaTest {

    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void unJugadorConTresGlobosAlCanjearlosPuedePoner3FichasEnElPaisQueOcupa(){
        Jugador jugador1 = new Jugador(1);
        Carta globoUno = new Carta(new Pais("Francia"), "Globo");
        Carta globoDos = new Carta(new Pais("Chile"), "Globo");
        Carta globoTres = new Carta(new Pais("Etiopia"), "Globo");
        Pais argentina = new Pais("Argentina");

        //Pongo todas las fichas del jugador en argentina
        jugador1.ocuparCon(argentina, 10);

        //Le doy las cartas al jugador
        jugador1.recibirCarta(globoUno);
        jugador1.recibirCarta(globoDos);
        jugador1.recibirCarta(globoTres);

        //Las canjeo
        jugador1.canjearCartas(globoUno, globoDos, globoTres);

        //Pongo tres fichas en el pais que ocupa el jugador
        Executable noProduceExcepcion = () -> {
          jugador1.agregarFichasA(3, argentina);
        };

        assertDoesNotThrow(noProduceExcepcion);
    }


    @Test
    public void jugadorCanjeaCartaDePaisQueOcupaYLeAgregaDosEjercitos(){
        ArgumentCaptor<Integer> ejercitosParametros = ArgumentCaptor.forClass(Integer.class);
        Jugador jugador1 = new Jugador(1);
        Pais argentina = mock(Pais.class);
        Carta cartaArgentina = new Carta(argentina, "Globo");
        //Armo el mock
        doAnswer(invocationOnMock -> {
            jugador1.ocupasteA(argentina);
            return null;
        }).when(argentina).recibirTropas(any());
        //Hago que el jugador ocupe argentina y le doy la carta de argentina
        jugador1.ocupa(argentina);
        jugador1.recibirCarta(cartaArgentina);

        //El jugador canjea la carta de argentina
        jugador1.canjearCarta(cartaArgentina);

        //Compruebo que se haya llamado al metodo recibirFuerzasAliadas
        verify(argentina, times(1)).agregarEjercito(ejercitosParametros.capture());

        //Verifico que el parametro sea el que queria
        assertEquals(2, ejercitosParametros.getValue());

    }

    @Test
    public void alCanjearGruposDeCartasSucesivamenteAgregaBienLaCantidadDeFichasAJugador(){
        Jugador jugador1 = new Jugador(1);
        Pais chile = new Pais("chile");
        Carta globoUno = new Carta(new Pais("Francia"), "Globo");
        Carta globoDos = new Carta(new Pais("Chile"), "Globo");
        Carta globoTres = new Carta(new Pais("Etiopia"), "Globo");
        //Dejo al jugador sin fichas
        jugador1.ocuparCon(chile, 10);

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
    public void alCanjearUnaCartaDeUnPaisQueNoOcupaNoAumentanLasFuerzasEnEsePais(){

        Jugador jugador1 = new Jugador(1);
        Pais argentina = mock(Pais.class);
        Carta cartaFrancia = new Carta(new Pais("Francia"), "Globo");
        //Armo el mock

        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                jugador1.ocupasteA(argentina);
                return null;
            }
        }).when(argentina).recibirTropas(any());
        //Hago que el jugador ocupe argentina y le doy la carta de argentina
        jugador1.ocupa(argentina);
        jugador1.recibirCarta(cartaFrancia);

        //El jugador canjea la carta de argentina
        jugador1.canjearCarta(cartaFrancia);

        //Compruebo que se haya llamado al metodo recibirFuerzasAliadas
        verify(argentina, times(0)).agregarEjercito(2);
    }

    @Test
    public void alCanjearCartasQueNoTienenElMismoSimboloNoSeAgreganFichasAlJugador(){
        Jugador jugador1 = new Jugador(1);
        Pais chile = new Pais("chile");
        Carta barcoUno = new Carta(new Pais("Francia"), "Barco");
        Carta globoUno = new Carta(new Pais("Chile"), "Globo");
        Carta globoDos = new Carta(new Pais("Etiopia"), "Globo");

        jugador1.ocuparCon(chile, 10);

        jugador1.recibirCarta(barcoUno);
        jugador1.recibirCarta(globoUno);
        jugador1.recibirCarta(globoDos);

        jugador1.canjearCartas(barcoUno, globoUno, globoDos);

        Executable noTieneMasFichas = () -> {
            jugador1.agregarFichasA(1, chile);
        };

        assertThrows(NoHayFuerzasRestantesError.class, noTieneMasFichas);
    }


}
