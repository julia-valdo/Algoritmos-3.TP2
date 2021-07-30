package edu.fiuba.algo3.modelo.Batalla;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoPermitidoError;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoDeEjercitoError;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.util.Pair;

import java.util.ArrayList;

public class Pais {
    private Ejercitos ejercitos;
    private String nombreDelPais;
    private ArrayList<Pais> paisesConectados;
    private int posX, posY;
    private Ficha miFicha;

    public void recibirTropas(Ejercitos otrosEjercitos) {
        this.ejercitos = this.ejercitos.disputarDominioDe(this, otrosEjercitos);
    }
    public Pais (String nombre){
        ejercitos = new EjercitosNulos();
        this.nombreDelPais = nombre;
        paisesConectados = new ArrayList<>();
    }

    public String getNombreDelPais() {
        return nombreDelPais;
    }

    public int getCantidadDeEjercitos() {return this.ejercitos.getCantidadEjercitos();}

    public void agregarPaisConectado(Pais unPais) {
        paisesConectados.add(unPais);
    }

    public void agregarEjercito(int cantidadDeEjercitos) {
        ejercitos.agregarEjercitos(cantidadDeEjercitos);
    }

    public void atacarA(Pais otroPais) {
       if(this.esDelMismoEquipo(otroPais)){
            throw new AtaqueNoPermitidoError("No se puede atacar a un pais del mismo equipo");
       }
       if (!this.esLimitrofe(otroPais)){
           throw new AtaqueNoPermitidoError("No se puede atacar a un pais no limitrofe");
       }
       Batalla batalla = new Batalla();
       batalla.atacar(this.ejercitos, otroPais.ejercitos);
       otroPais.recibirTropas(this.ejercitos);
   }

    private boolean esDelMismoEquipo(Pais otroPais) {
        return this.ejercitos.sonAliadosDe(otroPais.ejercitos);
    }

    private boolean esLimitrofe(Pais otroPais) { return paisesConectados.contains(otroPais); }

    public void moverEjercitoA(Pais otroPais, int cantidad){
        if(!this.esDelMismoEquipo(otroPais) || !this.esLimitrofe(otroPais)){
            throw new MovimientoDeEjercitoError("Movimiento de ejercito invalido");
        }
        this.ejercitos.moverEjercitoACon(otroPais.ejercitos, cantidad);
    }

    public void setCordenadas(Pair<Integer, Integer> parDeCoordenadas) {
        this.posX = parDeCoordenadas.getKey();
        this.posY = parDeCoordenadas.getValue();
    }
}
