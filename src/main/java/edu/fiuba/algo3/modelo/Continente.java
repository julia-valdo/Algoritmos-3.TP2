package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.stream.Stream;

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
        return paises.containsAll(this.paises);
    }

    public int getCantidadDeFichasPorContinente() {
        return cantidadDeFichasPorContinente;
    }

    public boolean pertenece(Pais pais){
        return paises.contains(pais);
    }

}
