package edu.fiuba.algo3.modelo.Batalla;
import edu.fiuba.algo3.Controlador.handlers.HandlerDePais;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoPermitidoError;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoDeEjercitoError;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.util.Pair;

import java.util.ArrayList;

public class Pais {
    private Ejercitos ejercitos;
    private String nombreDelPais;
    private ArrayList<Pais> paisesConectados;
    private int posX, posY;
    private Ficha miFicha;

    public void recibirTropas(Ejercitos otrosEjercitos) {
        this.ejercitos = this.ejercitos.disputarDominioDe(this, otrosEjercitos);
        this.notifyFicha();
    }


    private void notifyFicha() {
        if(this.miFicha != null){
            this.miFicha.notificar(this.ejercitos.getColor(), this.ejercitos.getCantidadEjercitos());
        }
    }

    public Pais (String nombre){
        ejercitos = new EjercitosNulos();
        this.nombreDelPais = nombre;
        paisesConectados = new ArrayList<>();
    }

    public String getNombreDelPais() {
        return nombreDelPais;
    }

    public int getCantidadDeEjercitos() {return this.ejercitos.getCantidadEjercitos();}

    public void agregarPaisConectado(Pais unPais) {
        paisesConectados.add(unPais);
    }

    public void agregarEjercito(int cantidadDeEjercitos) {
        ejercitos.agregarEjercitos(cantidadDeEjercitos);
        this.notifyFicha();
    }

    public void atacarA(Pais otroPais) {
        verificarPosibilidadDeAtaque(otroPais);
        Batalla batalla = new Batalla();
       batalla.atacar(this.ejercitos, otroPais.ejercitos);
       otroPais.recibirTropas(this.ejercitos);
        notificarFichasDeResultado(otroPais);
    }

    private boolean esDelMismoEquipo(Pais otroPais) {
        return this.ejercitos.sonAliadosDe(otroPais.ejercitos);
    }

    private boolean esLimitrofe(Pais otroPais) { return paisesConectados.contains(otroPais); }

    public void moverEjercitoA(Pais otroPais, int cantidad){
        if(!this.esDelMismoEquipo(otroPais) || !this.esLimitrofe(otroPais)){
            throw new MovimientoDeEjercitoError("Movimiento de ejercito invalido");
        }
        this.ejercitos.moverEjercitoACon(otroPais.ejercitos, cantidad);
        notificarFichasDeResultado(otroPais);
    }

    public void setCordenadas(Pair<Integer, Integer> parDeCoordenadas) {
        this.posX = parDeCoordenadas.getKey();
        this.posY = parDeCoordenadas.getValue();
    }

    public void setFicha(Ficha unaFicha){
        this.miFicha = unaFicha;
        this.miFicha.setPosicion(this.posX, this.posY);
        this.notifyFicha();
    }

    public void agregarHandler(HandlerDePais handler) {
        if(this.miFicha != null) {
            handler.asociarPais(this);
            this.miFicha.agregarNuevoHandler(handler);
        }
    }

    public void habilitarLimitrofes(HandlerDePais confirmacion){
        for(Pais pais: paisesConectados){
            pais.agregarHandler(confirmacion.getCopy());

        }
    }

    public void restablecerLimitrofesParaAtaque() {
        for(Pais pais: paisesConectados){
            if(this.esDelMismoEquipo(pais)){
                pais.copiarMiHandler(this.miFicha);
            }
            else pais.limpiarFicha();
        }
    }

    private void copiarMiHandler(Ficha unaFicha) {
        this.miFicha.copiarEn(unaFicha, this);
    }

    private void limpiarFicha() {
        this.miFicha.limpiarHandler();
    }

    public void atacarAVisual(Pais otroPais) {
        verificarPosibilidadDeAtaque(otroPais);
        Batalla batalla = new Batalla();
        batalla.atacarVisual(this.ejercitos, otroPais.ejercitos);
        otroPais.recibirTropas(this.ejercitos);
        notificarFichasDeResultado(otroPais);
    }

    private void verificarPosibilidadDeAtaque(Pais otroPais) {
        if (this.esDelMismoEquipo(otroPais)) {
            throw new AtaqueNoPermitidoError("No se puede atacar a un pais del mismo equipo");
        }
        if (!this.esLimitrofe(otroPais)) {
            throw new AtaqueNoPermitidoError("No se puede atacar a un pais no limitrofe");
        }
    }

    private void notificarFichasDeResultado(Pais otroPais) {
        this.notifyFicha();
        otroPais.notifyFicha();
    }
}
