package edu.fiuba.algo3.modelo;

public class MovimientoDeEjercitoError extends RuntimeException{
    public MovimientoDeEjercitoError(String mensaje){
        super(mensaje);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}