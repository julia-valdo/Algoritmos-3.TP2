package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;

public interface Parser  {
    //Implementar Facade

    public void parsearArchivo(String path);

    public Collection<Pais> getPaises() ;

    public ArrayList<Carta> getCartas();

    public Collection<Continente> getContinentes();

}
