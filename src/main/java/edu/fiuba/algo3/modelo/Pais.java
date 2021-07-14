package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Pais {
    private Ejercitos ejercitos;
    private String nombreDelPais;
    private ArrayList<Pais> paisesConectados;

    public void recibirTropas(Ejercitos otrosEjercitos) {
        this.ejercitos = this.ejercitos.disputarDominioDe(this, otrosEjercitos);
    }
    public Pais (String nombre){
        ejercitos = new Ejercitos();
        this.nombreDelPais = nombre;
        paisesConectados = new ArrayList<>();
    }

    public String getNombreDelPais() {
        return nombreDelPais;
    }

    public boolean estaOcupadoPor(Jugador unJugador){
        return this.ejercitos.estanBajoElMandoDe(unJugador);
    }

    //Solo para pruebas
    public int getCantidadDeEjercitos() {return this.ejercitos.getCantidadEjercitos();}

    public void agregarPaisesConectados(Pais unPais) {
        paisesConectados.add(unPais);
    }

    //Son public para probar
    public boolean esLimitrofe(Pais otroPais) { return paisesConectados.contains(otroPais); }

    public boolean esDelMismoEquipo(Pais otroPais) {
        return this.ejercitos.sonAliadosDe(otroPais.ejercitos);
    }


    public void agregarEjercito(int cantidadDeEjercitos) {
        ejercitos.agregarEjercitos(cantidadDeEjercitos);
    }



   public void atacarA(Pais otroPais) {
       if(!this.esDelMismoEquipo(otroPais) && this.esLimitrofe(otroPais)){
            Batalla batalla = new Batalla();
            batalla.atacar(this.ejercitos, otroPais.ejercitos);
        }
    }

}
