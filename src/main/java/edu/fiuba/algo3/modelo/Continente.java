package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {

    String nombre;
    private ArrayList<Pais> paises;
<<<<<<< HEAD

    public Continente(String nombreContinente){
        nombre = nombreContinente;
        paises = new ArrayList<>();
=======
    private int cantidadDeFichasPorContinente;

    public Continente(String nombreContinente, int fichasADevolver){
        nombre = nombreContinente;
        paises = new ArrayList<>();
        cantidadDeFichasPorContinente = fichasADevolver;
>>>>>>> 8e319831bdf454fe9e654daaa03357e2cec10b0e
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

<<<<<<< HEAD
=======
    public int getCantidadDeFichasPorContinente() {
        return cantidadDeFichasPorContinente;
    }
>>>>>>> 8e319831bdf454fe9e654daaa03357e2cec10b0e
}
