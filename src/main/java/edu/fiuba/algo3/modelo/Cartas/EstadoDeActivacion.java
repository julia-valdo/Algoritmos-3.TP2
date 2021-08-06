package edu.fiuba.algo3.modelo.Cartas;

import edu.fiuba.algo3.modelo.Batalla.Pais;

public interface EstadoDeActivacion {

    EstadoDeActivacion activarseEn(Pais unPais);

    boolean estaActivada();
}
