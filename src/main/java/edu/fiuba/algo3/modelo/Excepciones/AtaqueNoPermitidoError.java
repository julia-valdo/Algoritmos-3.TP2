package edu.fiuba.algo3.modelo.Excepciones;

public class AtaqueNoPermitidoError extends RuntimeException {

    public AtaqueNoPermitidoError(String mensaje){
        super(mensaje);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
