package edu.fiuba.algo3.modelo.Objetivos;

import edu.fiuba.algo3.modelo.Batalla.Pais;
import edu.fiuba.algo3.modelo.Objetivos.Objetivo;

import java.util.ArrayList;

public class ObjetivoJugador implements Objetivo {
    Objetivo general;
    Objetivo secreto;

    public ObjetivoJugador(Objetivo general, Objetivo secreto){
        this.general = general;
        this.secreto = secreto;
    }

    @Override
    public boolean objetivoCumplido(ArrayList<Pais> paises) {
        return general.objetivoCumplido(paises) || secreto.objetivoCumplido(paises);
    }
}
