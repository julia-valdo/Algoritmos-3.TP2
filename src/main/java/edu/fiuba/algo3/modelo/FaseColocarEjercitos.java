package edu.fiuba.algo3.modelo;

public class FaseColocarEjercitos implements FaseDeRonda{

    @Override
    public void accionJugador(Jugador jugador, InventarioDeJuego inventarioDeJuego) {
        int cantidadFichas = jugador.cantidadDeEjercitosAColocar(inventarioDeJuego);
        jugador.agregarFichas(cantidadFichas);
    }
    @Override
    public FaseDeRonda cambiarFase() {
        return new FaseAtacar();
    }
}
