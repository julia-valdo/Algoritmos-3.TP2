package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.Controlador.handlers.HandlerDeCarta;
import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.vista.Elementos.BoxCarta;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Carta {
    private final Pais pais;
    private final String simbolo;
    private Mazo mazo;
    private EstadoDeActivacion estadoCarta;
    BoxCarta boxCarta;

    public Carta(Pais pais, String simbolo){
        this.pais = pais;
        this.simbolo = simbolo;
        this.mazo = new Mazo(new ArrayList<Carta>());
        this.estadoCarta = new Desactivada();
        this.boxCarta = new BoxCarta(this);
    }

    public String getSimbolo(){
        return simbolo;
    }

    public boolean esValidoElCanje(Carta segundaCarta, Carta terceraCarta) {
        return (this.sonTresIguales(segundaCarta, terceraCarta) || this.sonTresDistintas(segundaCarta, terceraCarta));
    }

    private boolean sonTresIguales(Carta segundaCarta, Carta terceraCarta){
        return (this.sonDelMismoTipo(segundaCarta)) && this.sonDelMismoTipo(terceraCarta);
    }

    private boolean sonTresDistintas(Carta segundaCarta, Carta terceraCarta){
        boolean esDiferenteALaSegunda = this.noSonDelMismoTipo(segundaCarta);
        boolean esDiferenteALaTercera = this.noSonDelMismoTipo(terceraCarta);
        boolean segundaYTerceraSonDiferentes = segundaCarta.noSonDelMismoTipo(terceraCarta);

        return esDiferenteALaSegunda && esDiferenteALaTercera && segundaYTerceraSonDiferentes;
    }

    public Pais getPais(){
        return pais;
    }

    private boolean sonDelMismoTipo(Carta otraCarta){
        return this.simbolo.equals(otraCarta.simbolo) || this.simbolo.equals("Comodin") || otraCarta.simbolo.equals("Comodin");
    }

    private boolean noSonDelMismoTipo(Carta otraCarta){
        return !this.sonDelMismoTipo(otraCarta);
    }

    public void activarse() {
        this.estadoCarta = this.estadoCarta.activarseEn(this.pais);
    }

    public void devolverAlMazo(){
        this.estadoCarta = new Desactivada();
        this.mazo.vuelveAlMazo(this);
    }

    public void asociarAlMazo(Mazo unMazo){
        this.mazo = unMazo;
    }

    public void agregarHandler(HandlerDeCarta handler) {
        if(this.boxCarta != null) {
            handler.asociarCarta(this);
            this.boxCarta.agregarNuevoHandler(handler);
        }
    }

    public void limpiarCartas() {
        this.mazo.limpiarCartas();
    }

    private void copiarMiHandler(Carta otraCarta) {
        this.boxCarta.copiarEn(this.boxCarta, otraCarta);
    }

    public void limpiarHandler() {
        this.boxCarta.limpiarHandler();
    }

    public BoxCarta getBox(){
        return this.boxCarta;
    }

}
