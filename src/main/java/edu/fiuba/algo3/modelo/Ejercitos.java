package edu.fiuba.algo3.modelo;

public class Ejercitos implements Ocupante{

    Jugador comandante;
    int numeroDeFuerzas;

    public Ejercitos(int fuerzasIniciales, Jugador comandante){
        this.numeroDeFuerzas = fuerzasIniciales;
        this.comandante = comandante;
    }

    @Override
    public boolean estanBajoElMandoDe(Jugador unJugador){
        return comandante == unJugador;
    }

    /*
    Este metodo puede llegar a cambiar cuando se implementen los ejercitos
     */
    @Override
    public boolean debenDesocupar(Pais unPais){
        boolean hayQueDesocupar = this.fuimosDerrotados();
        if(hayQueDesocupar) {
            this.comandante.perdisteA(unPais);
        }
        return hayQueDesocupar;
    }

    @Override
    public void ocupacionExitosaDe(Pais unPais) {
        this.comandante.ocupasteA(unPais);
    }

    private boolean fuimosDerrotados(){
        return numeroDeFuerzas == 0;
    }

}
