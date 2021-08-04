package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Batalla.Ejercitos;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.vista.Elementos.ColoresJugadores;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Jugador {
    private int numeroDeJugador;
    private String nombreJugador;
    private String color;
    private ArrayList<Pais> paisesOcupados;
    private InventarioDeJugador inventarioDeJugador;
    private boolean derrotado;

    public Jugador(int numeroDeJugador){
        this.paisesOcupados = new ArrayList<>();
        this.numeroDeJugador = numeroDeJugador;
        this.setColor();
        this.inventarioDeJugador = new InventarioDeJugador(this);
        this.derrotado = false;
    }

    private void setColor(){
        ColoresJugadores colores = new ColoresJugadores();
        this.color = colores.getColor(this.numeroDeJugador);
    }

    public void ocupa(Pais unPais){ this.ocuparCon(unPais, 1); }

    public void ocuparCon(Pais unPais, int cantidadFuerzas){
        Ejercitos nuevaDivision = this.inventarioDeJugador.generarDivision(cantidadFuerzas);
        unPais.recibirTropas(nuevaDivision);
    }

    //AgregarEstadoDerrotado
    public void perdisteA(Pais unPais){
        this.paisesOcupados.remove(unPais);
        if (this.paisesOcupados.isEmpty()) this.derrotado = true;
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
        if(this.paisesOcupados.contains(otroPais)){
            this.inventarioDeJugador.ocupePais();
        }
    }

    public int cantidadDeEjercitosAColocar(InventarioDeJuego inventarioDeJuego){
        int cantidadEjercitos = (paisesOcupados.size()) / 2;
        cantidadEjercitos += inventarioDeJuego.ejercitosPorContinentesConquistados(paisesOcupados);
        return cantidadEjercitos;
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
        };
    }

    public ArrayList<Pais> getPaisesOcupados() {
        return paisesOcupados;
    }

    private boolean puedoCanjearLaCarta(Carta unaCarta){
        return paisesOcupados.contains(unaCarta.getPais());
    }

    public boolean fueDerrotado(){
        return this.derrotado;
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

    public boolean esElNumero(int numero) {
        return this.getNumeroJugador() == numero;
    }

}
