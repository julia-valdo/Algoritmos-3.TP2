package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.Controlador.Controlador;
import edu.fiuba.algo3.vista.Elementos.Ficha;
import edu.fiuba.algo3.vista.ventanas.VentanaConFichas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonComenzarJuegoHandler implements EventHandler<ActionEvent> {

    private ArrayList<TextField> textos;
    private ArrayList<Ficha> fichas;
    private final int numeroDePaises = 50;

    public BotonComenzarJuegoHandler(ArrayList<TextField> textos){
        super();
        this.textos = textos;
        this.crearFichas();
    }

    private void crearFichas() {
        this.fichas = new ArrayList<>();
        for(int i = 0; i < this.numeroDePaises; i++){
            this.fichas.add(new Ficha("#000000"));
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scena = new Scene(new VentanaConFichas(fichas));
        this.setearNombres();
        this.asociarFichas();
        stage.setScene(scena);
        stage.show();
    }


    private void setearNombres(){
        ArrayList<String> nombres = new ArrayList<>();
        for(TextField texto: textos){
            nombres.add(texto.getText());
        }
        Controlador.setearNombres(nombres);
    }

    private void asociarFichas(){
        Controlador.empezarJuego(this.fichas);
    }
}
