package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.vista.ventanas.VentanaDePapel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MostrarObjetivoHandler implements EventHandler<ActionEvent> {
    Text textoDeObjetivo;
    Text textoDeJugador;

    public MostrarObjetivoHandler(Text textoDeObjetivo, String nombreJugador){
        this.textoDeObjetivo = textoDeObjetivo;
        this.prepararTextoJugador(nombreJugador);
    }

    private void prepararTextoJugador(String nombre){
        this.textoDeJugador = new Text("Objetivo de: " + nombre);
        this.textoDeJugador.setTranslateY(50);
        this.textoDeJugador.setTranslateX(60);
        this.textoDeJugador.setStyle("-fx-font-weight: bold");
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        VentanaDePapel ventana = new VentanaDePapel(this.textoDeObjetivo);
        ventana.getChildren().add(this.textoDeJugador);
        Scene scena = new Scene(ventana);
        Stage popUpDeObjetivo = new Stage();

        popUpDeObjetivo.setScene(scena);
        popUpDeObjetivo.show();
    }
}
