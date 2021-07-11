package edu.fiuba.algo3.PrimeraIteracion;

import java.util.ArrayList;

public class Pais {
    int ejercitos;
    String colorDelPais;
    String nombre;
    ArrayList<String> paisesConectados;

    public Pais (String nombre, String colorDelPais){
        ejercitos = 0;
        this.nombre = nombre;
        this.colorDelPais = colorDelPais;
        paisesConectados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getColorDelPais() {
        return colorDelPais;
    }

    public void setColorDelPais(String colorDelJugador) {
        this.colorDelPais = colorDelJugador;
    }

    public int getEjercitos() {
        return this.ejercitos;
    }

    public void agregarPaisesConectados(String unPais) {
        paisesConectados.add(unPais);
    }

    private boolean esLimitrofe(Pais otroPais) {
        return paisesConectados.contains(otroPais.getNombre());
    }

    private boolean esDelMismoEquipo(Pais otroPais) {
        return this.colorDelPais.equals(otroPais.getColorDelPais());
    }

    public void agregarEjercito(int cantidadDeEjercitos) {
        ejercitos += cantidadDeEjercitos;
    }

    public boolean puedoAtacarA(Pais otroPais) {
        return ((!this.esDelMismoEquipo(otroPais)) && this.esLimitrofe(otroPais));
    }

    public void defenderseDeCon(Pais atacante, Dado dadoAtacante, Dado dadoDefensor) {
        int cantidadPerdidas = dadoDefensor.cantidadPerdidas(dadoAtacante);
        ejercitos -= cantidadPerdidas;
        if (ejercitos<1) this.fueOcupadoPor(atacante);
    }


    private void fueOcupadoPor(Pais atacante) {
        this.colorDelPais = atacante.getColorDelPais();
        atacante.agregarEjercito(-1);
        this.ejercitos = 1;
    }
}
