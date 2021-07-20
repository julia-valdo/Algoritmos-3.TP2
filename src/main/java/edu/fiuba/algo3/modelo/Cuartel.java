package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

/*
Guarda la informacion del canjeo de cartas del jugador particular
 */
public class Cuartel {
    private ArrayList<Carta> cartas;
    int fichasDisponibles;
    Jugador duenoDelCuartel;

    public Cuartel(Jugador dueno){
        cartas = new ArrayList<>();
        fichasDisponibles = 10;
        this.duenoDelCuartel = dueno;
    }

    /*
    Recibe una carta y la guarda
     */
    public void recibirCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    /*
    Canjea las cartas elegidas y actualiza la cantidad de fichas disponibles
     */
    public void canjearCartas(Carta primeraCarta, Carta segundaCarta, Carta terceraCarta) {
        this.fichasDisponibles += primeraCarta.recibirFichasPorCanjeCon(segundaCarta, terceraCarta);
        this.cartas.remove(primeraCarta);this.cartas.remove(primeraCarta);this.cartas.remove(primeraCarta);
    }

    /*
    Devuelve los ejercitos con la cantidad de fichas pasadas por parametro
    siempre que esta no supere las fichas disponibles
     */
    public Ejercitos generarDivision(int cantidadFuerzas) {
        if(cantidadFuerzas > fichasDisponibles){
            throw new NoHayFuerzasRestantesError();
        }
        this.fichasDisponibles -= cantidadFuerzas;
        return new Ejercitos(cantidadFuerzas, duenoDelCuartel);
    }

    /*
    Agrega la cantidad de fichas pasadas por parametro
     */
    public void agregarEjercitos(int cantidadFichas) {
        this.fichasDisponibles += cantidadFichas;
    }

    /*
    Canjea la carta y manda dos divisiones al pais ocupado si se encuentra comoparametro
     */
    public void canjearCarta(Carta unaCarta, ArrayList<Pais> paisesOcupados) {
        Pais paisASumarleEjercitos = unaCarta.ObtenerPaisAsociado(paisesOcupados);
        if(paisASumarleEjercitos != null){
            paisASumarleEjercitos.recibirTropasAliadas(new Ejercitos(2, this.duenoDelCuartel));
        }
    }
}
