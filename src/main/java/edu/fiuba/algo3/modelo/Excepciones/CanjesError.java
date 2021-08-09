package edu.fiuba.algo3.modelo.Excepciones;

public class CanjesError extends RuntimeException {

    public CanjesError(String mensaje){
        super(mensaje);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
