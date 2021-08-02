package edu.fiuba.algo3.modelo.JuegoYJugador;

import edu.fiuba.algo3.modelo.Batalla.Ejercitos;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.Cartas.ManoDeCartas;
import edu.fiuba.algo3.modelo.Cartas.Mazo;
import edu.fiuba.algo3.modelo.Excepciones.NoHayFuerzasRestantesError;
import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Elementos.Ficha;

/*
Guarda la informacion del canjeo de cartas del jugador particular
 */
public class InventarioDeJugador {
    private ManoDeCartas mano;
    private int fichasDisponibles;
    private Jugador duenoDelCuartel;
    private Ficha miFicha;

    public InventarioDeJugador(Jugador dueno){
        this.fichasDisponibles = 0;
        this.mano = new ManoDeCartas();
        this.duenoDelCuartel = dueno;
        this.miFicha = new Ficha(dueno.getColor());
    }

    public void recibirCarta(Carta unaCarta) {
        this.mano.recibirCarta(unaCarta);
    }

    public void canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
        this.fichasDisponibles += this.mano.canjearCartas(primeraCarta, segundaCarta, terceraCarta);
    }

    public Ejercitos generarDivision(int cantidadFuerzas) {
        if(cantidadFuerzas > fichasDisponibles){
            throw new NoHayFuerzasRestantesError();
        }
        this.fichasDisponibles -= cantidadFuerzas;
        return new Ejercitos(cantidadFuerzas, duenoDelCuartel);
    }

    public void agregarEjercitos(int cantidadFichas) {

        this.fichasDisponibles += cantidadFichas;
        this.notifyFicha();
    }

    public void agregarFichasA(int numeroDeFichas, Pais unPais) {
        if(numeroDeFichas > fichasDisponibles){
            throw new NoHayFuerzasRestantesError();
        }
        this.fichasDisponibles -= numeroDeFichas;
        unPais.agregarEjercito(numeroDeFichas);
        this.notifyFicha();
    }

    private void notifyFicha() {
        this.miFicha.notificar(this.getColor(), this.fichasDisponibles);
    }

    private String getColor() {
        return this.miFicha.getFill().toString();
    }

    public void activarCarta(Carta unaCarta) {
        this.mano.activarCarta(unaCarta);
    }

    public void pedirCarta(InventarioDeJuego inventario) {
        this.mano.pedirCarta(inventario);
    }

    public void ocupePais() {
        this.mano.ocupePais();
    }

    public Ficha getFicha() {
        return this.miFicha;
    }
}
