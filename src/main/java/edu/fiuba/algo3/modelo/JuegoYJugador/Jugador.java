package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.Controlador.handlers.BoxCartaHandlerDos;
import edu.fiuba.algo3.Controlador.handlers.HandlerDeCarta;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Batalla.Ejercitos;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Objetivos.Objetivo;
import edu.fiuba.algo3.vista.Botones.BotonMostrarObjetivo;
import edu.fiuba.algo3.vista.Elementos.ColoresJugadores;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import edu.fiuba.algo3.vista.ventanas.VentanaVictoria;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import edu.fiuba.algo3.vista.Botones.BotonMostrarCartas;
import edu.fiuba.algo3.vista.Elementos.BoxCarta;
import edu.fiuba.algo3.vista.Elementos.ColoresJugadores;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Jugador {
    private int numeroDeJugador;
    private String nombreJugador;
    private String color;
    private ArrayList<Pais> paisesOcupados;
    private InventarioDeJugador inventarioDeJugador;
    private Objetivo objetivo;

    public Jugador(int numeroDeJugador){
        this.paisesOcupados = new ArrayList<>();
        this.numeroDeJugador = numeroDeJugador;
        this.setColor();
        this.inventarioDeJugador = new InventarioDeJugador(this);
    }

    private void setColor(){
        ColoresJugadores colores = new ColoresJugadores();
        this.color = colores.getColor(this.numeroDeJugador);
    }

    public void ocupa(Pais unPais){ this.ocuparCon(unPais, 1); }

    public void ocuparCon(Pais unPais, int cantidadFuerzas){
        Ejercitos nuevaDivision = this.inventarioDeJugador.generarDivision(cantidadFuerzas);
        unPais.recibirTropas(nuevaDivision);
        devolverFuerzas(unPais, cantidadFuerzas);
    }

    private void devolverFuerzas(Pais unPais, int cantidadFuerzas) {
        if(!this.ocupeElPais(unPais)){
            this.agregarFichas(cantidadFuerzas);
        }
    }

    //AgregarEstadoDerrotado
    public void perdisteA(Pais unPais){
        this.paisesOcupados.remove(unPais);
    }

    public void ocupasteA(Pais unPais){ paisesOcupados.add(unPais); }

    public void agregarFichas(int cantidadFichas){
        this.inventarioDeJugador.agregarEjercitos(cantidadFichas);
    }

    public void atacarPaisDesdeA(Pais unPais, Pais otroPais){
        unPais.atacarA(otroPais);
        this.verificarOcupacion(otroPais);
    }

    private void verificarOcupacion(Pais otroPais) {
        if(this.ocupeElPais(otroPais)){
            this.inventarioDeJugador.ocupePais();
        }
    }

    private boolean ocupeElPais(Pais otroPais) {
        return this.paisesOcupados.contains(otroPais);
    }

    public void cantidadDeEjercitosAColocar(InventarioDeJuego inventarioDeJuego){
        int cantidadEjercitos = (paisesOcupados.size()) / 2;
        cantidadEjercitos += inventarioDeJuego.ejercitosPorContinentesConquistados(paisesOcupados);
        this.agregarFichas(cantidadEjercitos);
    }


    public void agregarFichasA(int numeroDeFichas, Pais unPais) {
        this.inventarioDeJugador.agregarFichasA(numeroDeFichas, unPais);
    }


    public void recibirCarta(Carta unaCarta) {
        this.inventarioDeJugador.recibirCarta(unaCarta);
    }


    public void canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
            this.inventarioDeJugador.canjearCartas(primeraCarta, segundaCarta, terceraCarta);
    }

    public void canjearCarta(Carta unaCarta) {
        if(this.puedoCanjearLaCarta(unaCarta)){
            this.inventarioDeJugador.activarCarta(unaCarta);
        }
    }

    public ArrayList<Pais> getPaisesOcupados() {
        return paisesOcupados;
    }

    private boolean puedoCanjearLaCarta(Carta unaCarta){
        return paisesOcupados.contains(unaCarta.getPais());
    }

    public boolean fueDerrotado(){
        return this.paisesOcupados.isEmpty();
    }

    public void moverFichasDeACon(Pais unPais, Pais otroPais, int cantidad){
        unPais.moverEjercitoA(otroPais, cantidad);
    }

    public Integer getNumeroJugador() {
        return this.numeroDeJugador;
    }

    public void pedirCarta(InventarioDeJuego inventario) {
        this.inventarioDeJugador.pedirCarta(inventario);
    }

    public void setNombre(String nombre) {
        this.nombreJugador = nombre;
    }

    public String getColor() {
        return  this.color;
    }

    public void habilitarPaises(HandlerDePais handler) {
        for(Pais pais: this.paisesOcupados){
            HandlerDePais handlerDePais = handler.getCopy();
            pais.agregarHandler(handlerDePais);
        }
    }

    public Ficha getFicha() {
        return this.inventarioDeJugador.getFicha();
    }

    public Text prepararNombre() {
        Text nombre = new Text("Turno de: " + this.nombreJugador);
        nombre.setStyle("-fx-font-weight: bold");
        nombre.setTranslateY(50);
        nombre.setTranslateX(900);

        return nombre;
    }

    public String getNombreJugador(){
        return this.nombreJugador;
    }

    public boolean esElNumero(int numero) {
        return this.getNumeroJugador() == numero;
    }

    public void asignarObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Node prepararObjetivo() {
        Text textoDeObjetivo = this.objetivo.prepararVista();

        return new BotonMostrarObjetivo(textoDeObjetivo,this.nombreJugador, this.getColor());
    }
    
    private boolean gane(){
        return this.objetivo.objetivoCumplido(this.paisesOcupados);
    }

    public void evaluarVictoria(MouseEvent evento) {
        if (this.gane()) {
            Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
            VentanaVictoria victoria = new VentanaVictoria(this);
            Scene scenaFinal = new Scene(victoria);

            stage.setScene(scenaFinal);
            stage.show();
        }
    }

    public ArrayList<Carta> getCartas(){
        return this.inventarioDeJugador.getCartas();
    }


    public void elegirCarta(Carta primeraCarta, HandlerDeCarta boxCartaHandlerDos) {
        for(Carta carta: this.inventarioDeJugador.getCartas()){
            boxCartaHandlerDos.asociarCarta(carta);
            carta.agregarHandler(boxCartaHandlerDos);
        }
    }

    public void habilitarCartas(HandlerDeCarta handler){
        for(Carta carta : inventarioDeJugador.getCartas()){
            carta.agregarHandler(handler);
        }
    }


    public Button botonMostrarCarta(){
        return new BotonMostrarCartas(this.inventarioDeJugador);
    }
}
