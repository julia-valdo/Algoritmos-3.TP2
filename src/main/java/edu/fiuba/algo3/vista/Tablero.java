package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.ventanas.VentanaComienzo;
import edu.fiuba.algo3.vista.ventanas.VentanaCantidadJugadores;
import edu.fiuba.algo3.vista.ventanas.VentanaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tablero extends Application {
    @Override

    public void start (Stage stage) throws Exception{
        stage.setTitle("A.L.T.E.G.O.");

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(stage);
        Scene escenaJuego = new Scene(ventanaPrincipal);

        VentanaCantidadJugadores ventanaCantidadJugadores = new VentanaCantidadJugadores(stage, escenaJuego);
        Scene escenaJugadores = new Scene(ventanaCantidadJugadores);

        VentanaComienzo ventanaComienzo = new VentanaComienzo(stage, escenaJugadores);
        Scene escenaComienzo = new Scene(ventanaComienzo);

        stage.setScene(escenaComienzo);
        stage.show();
    }
    public static void main (String[] args){
        launch(args);
    }
}