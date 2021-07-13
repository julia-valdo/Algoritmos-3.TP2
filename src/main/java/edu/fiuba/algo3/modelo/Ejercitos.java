package edu.fiuba.algo3.modelo;

public class Ejercitos {
    int cantidadDeEjercitos;

    //siempre debe tener 1 el pais
    public Ejercitos(){
        cantidadDeEjercitos = 1;
    }

    public int getCantidadEjercitos() {
        return cantidadDeEjercitos;
    }

    public void agregarEjercitos(int cantidad) {
        cantidadDeEjercitos += cantidad;
    }

    public void restarEjercitos(int cantidad) {
        cantidadDeEjercitos -= cantidad;
    }

    public boolean fueDerrotado(){
        return cantidadDeEjercitos <= 0;
    }

}
