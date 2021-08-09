package edu.fiuba.algo3.modelo.Excepciones;

public class ColocacionEjercitoError extends RuntimeException {

    public ColocacionEjercitoError(String mensaje){
        super(mensaje);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
