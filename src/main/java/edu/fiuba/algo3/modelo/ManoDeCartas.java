package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ManoDeCartas {
    private ArrayList<Carta> cartas;
    private Canjes cantidadDeCanjesHechos;


    public ManoDeCartas(){
        this.cartas = new ArrayList<>();
        this.cantidadDeCanjesHechos = new CanjesMenosDeTres();
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
}
