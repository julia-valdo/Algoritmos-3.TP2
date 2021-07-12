package edu.fiuba.algo3.modelo;

public class Ejercitos {
    int cantidadDeEjercitos;

    public Ejercitos(){
        cantidadDeEjercitos = 0;
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
}
