package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.Controlador.SeleccionJugador;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.FlujoDeJuego.FaseDeRonda;
import edu.fiuba.algo3.modelo.FlujoDeJuego.FasePrimeraColocacion;
import edu.fiuba.algo3.modelo.Objetivos.Continente;
import edu.fiuba.algo3.modelo.Objetivos.Objetivo;
import edu.fiuba.algo3.modelo.Parser.Parser;
import edu.fiuba.algo3.vista.Elementos.CampoDeNombre;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.util.*;

public class Juego {
    private Integer turnoActual;
    private HashMap<Integer, Jugador> turnoJugadores;
    private FaseDeRonda faseActual;
    private Parser parser;
    private InventarioDeJuego inventario;
    private ArrayList<Ficha> fichasDeJuego;

    public Juego(int cantidadDeJugadores){
        this.turnoActual = 1;
        this.turnoJugadores = new HashMap<>();
        this.crearJugadores(cantidadDeJugadores);
        parser = new Parser(this.turnoJugadores);
    }

    public void iniciarJuego(){
        parser.parsearArchivo("Teg - Cartas.json");
        parser.parsearArchivo("Teg - Fronteras.json");
        parser.parsearArchivo("Teg - Objetivos.json");
        parser.construirObjetos();
        this.generarInventario();
        this.repartirPaises();
        this.repartirObjetivos();
        this.faseActual = new FasePrimeraColocacion(this.turnoJugadores.get(turnoActual), new TextoNotificable());
    }

    private void repartirObjetivos() {
        ArrayList<Objetivo> objetivos =  new ArrayList(this.parser.getObjetivos());
        Collections.shuffle(objetivos);
        for(int i = 1; i <= this.turnoJugadores.size(); i++){
            Objetivo objetivo = objetivos.get(i-1);

            if(i < this.turnoJugadores.size()) objetivo.setJugadorAuxiliar(turnoJugadores.get(i), turnoJugadores.get(i+1));
            else objetivo.setJugadorAuxiliar(turnoJugadores.get(i),turnoJugadores.get(1));

            this.turnoJugadores.get(i).asignarObjetivo(objetivos.get(i - 1));
        }
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
        this.faseActual.accionJugador(jugador, new InventarioDeJuego(new ArrayList<>(), new ArrayList<>()), seleccion);
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
        ArrayList<Pais> paises =  new ArrayList<>(this.parser.getPaises().values());
        Collections.shuffle(paises);
        for(Pais pais: paises){
            Jugador actual = this.obtenerSiguiente();
            actual.agregarFichas(1);
            actual.ocupa(pais);
        }
        this.turnoActual = 1;
        this.inventario.setPaises(paises);
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
        for(int i = 0; i < this.inventario.cantidadDePaises(); i++){
            this.inventario.agregarFichaA(fichas.get(i), i);
        }
    }


    public Jugador obtenerSiguienteEnTurno() {
        Jugador siguiente = this.obtenerSiguiente();
        this.faseActual.aplicarAccionesDeFase(siguiente, this.inventario);
        return siguiente;
    }

    public Scene prepararMenuSiguiente() {
        this.limpiarFichas();
        Jugador siguiente = this.obtenerSiguienteEnTurno();

        VentanaMenu ventana =  this.faseActual.prepararMenu();
        this.actualizarFase(siguiente);

        return new Scene(new VentanaJuego(this.fichasDeJuego,ventana));
    }

    private void actualizarFase(Jugador siguiente) {
        if(this.esElUltimoJugador(siguiente)){
            this.faseActual = this.faseActual.cambiarFase(siguiente);
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

    public Scene mostrarObjetivos() {
        VentanaMenu menuDeObjetivos = this.prepararObjetivos();
        VentanaMostrarObjetivos objetivos = new VentanaMostrarObjetivos(menuDeObjetivos);
        Scene scena = new Scene(objetivos);
        return scena;
    }

    private VentanaMenu prepararObjetivos() {
            ArrayList<Jugador> jugadores = new ArrayList<>(this.turnoJugadores.values());
            ArrayList<Node> nodosDeJugadores = new ArrayList<>();
            for(Jugador jugador: jugadores){
                nodosDeJugadores.add(jugador.prepararObjetivo());
            }
            return new VentanaMenuObjetivos(nodosDeJugadores);
    }

    public void habilitarPaisesParaAtaque(Pais pais, HandlerDePais confirmacionAtaqueHandle) {
        inventario.habilitarPaises(pais, confirmacionAtaqueHandle);
    }

    public void reestablecerPaises(Jugador jugador, HandlerDePais handler){
        this.inventario.reestablecerPaises();
        jugador.habilitarPaises(handler);
    }

    public void habilitarPaisesParaColocacion(HandlerDePais colocacion) {
        inventario.habilitarPaises(null, colocacion);
    }

}
