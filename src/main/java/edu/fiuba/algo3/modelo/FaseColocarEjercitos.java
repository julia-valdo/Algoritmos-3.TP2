package edu.fiuba.algo3.modelo;

public class FaseColocarEjercitos implements FaseDeRonda{

    @Override
    public void accionJugador(Jugador jugador, Banco banco) {
        int cantidadFichas = jugador.cantidadDeEjercitosAColocar(banco);
        jugador.agregarFichas(cantidadFichas);
    }
    @Override
    public FaseDeRonda cambiarFase() {
        return new FaseAtacar();
    }
}
