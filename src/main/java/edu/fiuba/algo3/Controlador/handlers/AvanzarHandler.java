package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.Controlador.Controlador;
import edu.fiuba.algo3.musica.ControladorMusica;
import edu.fiuba.algo3.vista.Elementos.TextoNotificable;
import edu.fiuba.algo3.vista.ventanas.VentanaDePapel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.ExecutionException;


public class AvanzarHandler implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scena;
        try{
            scena = Controlador.pedirMenuSiguiente();
        } catch (Exception exception){
            mostrarError(exception);
            return;
        }
        stage.setScene(scena);
        stage.show();
        ControladorMusica.playEffect();
        ControladorMusica.soundRestart();
    }

    private void mostrarError(Exception exception){
        TextoNotificable texto = new TextoNotificable();
        texto.setText(exception.getMessage());
        VentanaDePapel ventana = new VentanaDePapel(texto);
        ventana.prepararFondo(200,300);

        Scene scena = new Scene(ventana);
        Stage popUpDeCarta = new Stage();


        popUpDeCarta.setScene(scena);
        popUpDeCarta.show();
    }
}
