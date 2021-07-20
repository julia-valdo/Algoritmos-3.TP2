package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Pais {
    private Ejercitos ejercitos;
    private String nombreDelPais;
    private ArrayList<Pais> paisesConectados;

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
       else if (!this.esLimitrofe(otroPais)){
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

}
