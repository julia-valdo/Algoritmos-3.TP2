package edu.fiuba.algo3.modelo.Batalla;

public class EjercitosNulos extends Ejercitos {

    public EjercitosNulos(){
        super();
    }

    @Override
    public Ejercitos disputarDominioDe(Pais unPais, Ejercitos otrosEjercitos){
        otrosEjercitos.avisarOcupacionExitosa(unPais);
        return otrosEjercitos;
    }
}
