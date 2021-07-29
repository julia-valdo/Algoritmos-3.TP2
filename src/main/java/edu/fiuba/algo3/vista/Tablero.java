package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.ventana.VentanaComienzo;
import edu.fiuba.algo3.vista.ventana.VentanaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tablero extends Application {
    @Override

    public void start (Stage stage) throws Exception{
        stage.setTitle("A.L.T.E.G.O.");

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(stage);
        Scene escenaJuego = new Scene(ventanaPrincipal);

        VentanaComienzo vetanaComienzo = new VentanaComienzo(stage, escenaJuego);
        Scene escenaComienzo = new Scene(vetanaComienzo);

        stage.setScene(escenaComienzo);
        stage.show();
    }
    public static void main (String[] args){
        launch(args);
    }
}