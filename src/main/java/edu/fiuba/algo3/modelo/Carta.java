package edu.fiuba.algo3.modelo;

public class Carta {
    private final Pais pais;
    private final String simbolo;
    private EstadoDeActivacion estadoCarta;

    public Carta(Pais pais, String simbolo){
        this.pais = pais;
        this.simbolo = simbolo;
        this.estadoCarta = new Desactivada();
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
        return this.simbolo.equals(otraCarta.simbolo);
    }

    private boolean noSonDelMismoTipo(Carta otraCarta){
        return !this.sonDelMismoTipo(otraCarta);
    }

    public void canjearse() {
        this.estadoCarta = this.estadoCarta.activarseEn(this.pais);
    }
}
