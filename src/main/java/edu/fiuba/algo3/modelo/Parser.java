package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;

public interface Parser  {
    //Implementar Facade

    void parsearArchivo(String path);

    Collection<Pais> getPaises() ;

    ArrayList<Carta> getCartas();

    Collection<Continente> getContinentes();

}
