package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.modelo.JuegoYJugador.Jugador;
import edu.fiuba.algo3.vista.Botones.BotonComienzo;
import edu.fiuba.algo3.vista.Botones.BotonSalir;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class VentanaVictoria extends Group {

    public VentanaVictoria(Jugador jugadorGanador){
        super();
        this.prepararFondoDeVentana();
        this.prepararVentanaDeVictoria(jugadorGanador);
        this.prepararBotonDeReinicio();
    }

    private void prepararBotonDeReinicio() {
        Button botonDeReinicio = new BotonComienzo();
        botonDeReinicio.setText("Volver a jugar");
        botonDeReinicio.setStyle("-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000");
        Button botonDeSalir = new BotonSalir();
        botonDeSalir.setText("Salir");
        botonDeSalir.setStyle("-fx-font-weight: bold;-fx-background-color: #ffebcd; -fx-border-color: #000000");
        this.setPosiciones(botonDeReinicio, botonDeSalir);
        this.getChildren().addAll(botonDeReinicio, botonDeSalir);
    }

    private void setPosiciones(Button botonDeReinicio, Button botonDeSalir) {
        botonDeReinicio.setTranslateX(920);
        botonDeSalir.setTranslateX(955);
        botonDeReinicio.setTranslateY(550);
        botonDeSalir.setTranslateY(580);
    }

    private void prepararVentanaDeVictoria(Jugador ganador){
        Text textoDeVictoria = new Text("ATR EL " + ganador.getNombreJugador() + "\n PERRO");
        textoDeVictoria.setStyle("-fx-font: 24 sans-serif; -fx-font-weight: bold;");
        textoDeVictoria.setFill(Paint.valueOf(ganador.getColor()));
        textoDeVictoria.setTranslateX(900);
        textoDeVictoria.setTranslateY(50);
        this.getChildren().add(textoDeVictoria);
    }

    private void prepararFondoDeVentana(){
        VentanaPrincipal principal = new VentanaPrincipal();
        this.getChildren().add(principal);
    }

}
