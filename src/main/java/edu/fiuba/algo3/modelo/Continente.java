package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {

    String nombre;
    private ArrayList<Pais> paises;
    private int cantidadDeFichasPorContinente;


    public Continente(String nombreContinente) {
        nombre = nombreContinente;
        paises = new ArrayList<>();
    }

    public Continente(String nombreContinente, int fichasADevolver){
        nombre = nombreContinente;
        paises = new ArrayList<>();
        cantidadDeFichasPorContinente = fichasADevolver;

    }

    public void agregarPais(Pais pais){
        paises.add(pais);
    }

    public int cantidadPaisesQueMeConforman() {
        return paises.size();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean fueConquistado(ArrayList<Pais> paises){
        return this.paises.equals(paises);
    }

    public int getCantidadDeFichasPorContinente() {
        return cantidadDeFichasPorContinente;
    }

}
