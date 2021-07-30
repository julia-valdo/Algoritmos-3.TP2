package edu.fiuba.algo3.vista.Elementos;

import java.util.HashMap;

public class ColoresJugadores {

    private HashMap<Integer, String> colores;

    public ColoresJugadores(){
        this.colores = new HashMap<>();
        this.setUpColores();
    }


    private void setUpColores(){
        String[] coloresJugadores = {"#0077bb", "#cc3311", "#ee7733", "#009988", "#ee3377", "#000000"};
        for(Integer i = 1; i < 7; i++){
            this.colores.put(i, coloresJugadores[i - 1]);
        }
    }

    public  String getColor(Integer numeroJugador){
        return this.colores.get(numeroJugador);
    }
}
