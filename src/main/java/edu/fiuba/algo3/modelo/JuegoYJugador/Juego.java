package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.FlujoDeJuego.FaseDeRonda;
import edu.fiuba.algo3.modelo.FlujoDeJuego.FasePrimeraColocacion;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.modelo.Parser.Parser;
import edu.fiuba.algo3.vista.Elementos.CampoDeNombre;
import edu.fiuba.algo3.vista.Elementos.ColoresJugadores;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaFaseColocacion;
import edu.fiuba.algo3.vista.ventanas.VentanaMenu;
import edu.fiuba.algo3.vista.ventanas.VentanaMenuColocacion;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.*;

public class Juego {
    private Integer turnoActual;
    private HashMap<Integer, Jugador> turnoJugadores;
    private FaseDeRonda fase;
    private Parser parser;
    private InventarioDeJuego inventario;
    private List<Pais> paises;
    private ArrayList<Ficha> fichasDeJuego;

    public Juego(int cantidadDeJugadores){
        parser = new Parser();
        this.turnoActual = 1;
        this.turnoJugadores = new HashMap<>();
        this.fase = new FasePrimeraColocacion(new TextoNotificable());
        this.crearJugadores(cantidadDeJugadores);
    }

    public void iniciarJuego(){
        parser.parsearArchivo("Teg - Cartas.json");
        parser.parsearArchivo("Teg - Fronteras.json");
        parser.parsearArchivo("Teg - Objetivos.json");
        parser.construirObjetos();
        this.repartirPaises();
        this.generarInventario();
    }


    private void crearJugadores(int cantidadDeJugadores){
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for(int i = 1; i <= cantidadDeJugadores; i++) jugadores.add(new Jugador(i));
        this.establecerTurnos(jugadores);
    }

    private void establecerTurnos(ArrayList<Jugador> jugadores) {
        int counter = 1;
        Collections.shuffle(jugadores);
        for (Jugador jugador : jugadores) {
            this.turnoJugadores.put(counter, jugador);
            counter += 1;
        }
    }

    public ArrayList<Integer> obtenerOrder() {
        ArrayList<Integer> numerosDeJugadores = new ArrayList<>();
        Collection<Jugador> jugadores = this.turnoJugadores.values();
        for(Jugador jugador : jugadores){
            numerosDeJugadores.add(jugador.getNumeroJugador());
        }

        return numerosDeJugadores;

    }

    public Jugador obtenerSiguiente() {
        Jugador siguiente =  this.turnoJugadores.get(this.turnoActual);
        this.avanzarTurno();
        return siguiente;
    }

    public void seleccionDeJugador(Jugador jugador, SeleccionJugador seleccion){
        this.fase.accionJugador(jugador, new InventarioDeJuego(new ArrayList<>(), new ArrayList<>()), seleccion);
        this.actualizarFase(jugador);
    }

    private void avanzarTurno() {
        if(this.esElUltimoJugador(this.turnoJugadores.get(this.turnoActual))){
            this.turnoActual = 1;
        }
        else {
            this.turnoActual++;
        }
    }


    private void repartirPaises(){
        this.paises =  new ArrayList<>(this.parser.getPaises().values());
        Collections.shuffle(paises);
        for(Pais pais: paises){
         Jugador actual = this.obtenerSiguiente();
         actual.agregarFichas(1);
         actual.ocupa(pais);
        }
        this.turnoActual = 1;
    }

    private boolean esElUltimoJugador(Jugador jugador){
        return jugador == this.turnoJugadores.get(this.turnoJugadores.size());
    }

    private void generarInventario() {
        ArrayList<Continente> continentes = new ArrayList<>(this.parser.getContinentes().values());
        ArrayList<Carta> cartas  = this.parser.getCartas();
        Collections.shuffle(cartas);
        this.inventario = new InventarioDeJuego(cartas, continentes);
    }

    public void setearFichas(ArrayList<Ficha> fichas) {
        this.fichasDeJuego = fichas;
        for(int i = 0; i < paises.size(); i++){
            paises.get(i).setFicha(fichas.get(i));
        }
    }


    public Jugador obtenerSiguienteEnTurno() {
        Jugador siguiente = this.obtenerSiguiente();
        this.fase.aplicarAccionesDeFase(siguiente, this.inventario);
        return siguiente;
    }

    public Scene prepararMenuSiguiente() {
        this.limpiarFichas();
        Jugador siguiente = this.obtenerSiguienteEnTurno();

        VentanaMenu ventana =  this.fase.prepararMenu();
        this.actualizarFase(siguiente);

        return new Scene(new VentanaFaseColocacion(this.fichasDeJuego,ventana));
    }

    private void actualizarFase(Jugador siguiente) {
        if(this.esElUltimoJugador(siguiente)){
            this.fase = this.fase.cambiarFase();
        }
    }

    public void setNombreJugador(TextField nombre) {
        int numeroJugador = ((CampoDeNombre) nombre).getNumero();
        this.setNombreJugadorNumero(numeroJugador, nombre.getText());

    }

    private void setNombreJugadorNumero(int numero, String nombre) {
        Jugador jugador = this.buscarNumero(numero);
        jugador.setNombre(nombre);
    }

    private Jugador buscarNumero(int numero) {
        ArrayList<Jugador> jugadores = new ArrayList<>(this.turnoJugadores.values());

        return jugadores.stream().filter(jugador -> jugador.esElNumero(numero)).findFirst().get();
    }

    private void limpiarFichas() {
        for(Ficha ficha: fichasDeJuego){
            ficha.limpiarHandler();
        }
    }
}
