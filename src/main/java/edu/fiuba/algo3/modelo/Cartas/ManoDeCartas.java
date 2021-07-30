package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.Cartas.Canjes;
import edu.fiuba.algo3.modelo.Cartas.CanjesMenosDeTres;
import edu.fiuba.algo3.modelo.Cartas.Carta;
import edu.fiuba.algo3.modelo.JuegoYJugador.InventarioDeJuego;

import java.util.ArrayList;

public class ManoDeCartas {
    private ArrayList<Carta> cartas;
    private Canjes cantidadDeCanjesHechos;
    private Habilitado puedePedirCarta;


    public ManoDeCartas(){
        this.cartas = new ArrayList<>();
        this.cantidadDeCanjesHechos = new CanjesMenosDeTres();
        this.puedePedirCarta = new NoEstaHabilitado();
    }

    public void recibirCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public int canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
        if(this.tengoLasCartas(primeraCarta, segundaCarta, terceraCarta)){
            return this.realizarCanje(primeraCarta, segundaCarta, terceraCarta);
        }
        return 0;
    }

    public void activarCarta(Carta unaCarta) {
        if(this.tengo(unaCarta)){
            unaCarta.activarse();
        }
    }

    private boolean tengo(Carta unaCarta){
        return this.cartas.contains(unaCarta);
    }

    private boolean tengoLasCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta){

        return this.tengo(primeraCarta) && this.tengo(segundaCarta) && this.tengo(terceraCarta);
    }

    private void finalizarCanje(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta){
        primeraCarta.devolverAlMazo(); segundaCarta.devolverAlMazo(); terceraCarta.devolverAlMazo();
        this.cartas.remove(primeraCarta); this.cartas.remove(segundaCarta); this.cartas.remove(terceraCarta);
    }

    private int realizarCanje(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta){
        int fichasPorCanje = 0;
        if(primeraCarta.esValidoElCanje(segundaCarta, terceraCarta)){
            fichasPorCanje = this.confirmarCanje();
            this.finalizarCanje(primeraCarta, segundaCarta, terceraCarta);
        }
        return fichasPorCanje;
    }

    private int confirmarCanje() {
        int fichasPorCanje = cantidadDeCanjesHechos.realizarCanje();
        this.cantidadDeCanjesHechos = this.cantidadDeCanjesHechos.obtenerProximoCanje();
        return fichasPorCanje;
    }

    public void pedirCarta(InventarioDeJuego inventario) {
        this.puedePedirCarta = this.puedePedirCarta.pedirCarta(this, inventario);
    }

    public void ocupePais() {
        this.puedePedirCarta = this.puedePedirCarta.ocupePais();
    }
}
