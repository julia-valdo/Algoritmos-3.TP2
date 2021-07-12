package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Pais {
    Ejercitos ejercitos;
    int numeroDelJugador;
    String nombreDelPais;
    ArrayList<Pais> paisesConectados;

    public Pais (String nombre){
        ejercitos = new Ejercitos();
        this.nombreDelPais = nombre;
        paisesConectados = new ArrayList<Pais>();
    }

    public String getNombreDelPais() {
        return nombreDelPais;
    }

    public int getNumeroDelJugador() {
        return this.numeroDelJugador;
    }

    public int getCantidadDeEjercitos() {return this.ejercitos.getCantidadEjercitos();}

    public Ejercitos getEjercitos() {
        return ejercitos;
    }

    public void setNumeroDelJugador(int numeroDelJugador) {
        this.numeroDelJugador = numeroDelJugador;
    }

    public void agregarPaisesConectados(Pais unPais) {
        paisesConectados.add(unPais);
    }

    //Son public para probar
    public boolean esLimitrofe(Pais otroPais) {
        return paisesConectados.contains(otroPais);
    }

    public boolean esDelMismoEquipo(Pais otroPais) {
        return this.numeroDelJugador == otroPais.getNumeroDelJugador();
    }

    public void agregarEjercito(int cantidadDeEjercitos) {
        ejercitos.agregarEjercitos(cantidadDeEjercitos);
    }

//    public void atacarA(Pais otroPais) {
//        if(!this.esDelMismoEquipo(otroPais) && this.esLimitrofe(otroPais)){
//            Batalla batalla = Batalla new();
//            batallaEntre(this.ejercitos, otroPais.getEjercitos());
//        }
//    }
}
