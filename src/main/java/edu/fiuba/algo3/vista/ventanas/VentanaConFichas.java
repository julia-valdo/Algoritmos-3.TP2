package edu.fiuba.algo3.vista.ventanas;

import edu.fiuba.algo3.vista.Elementos.Ficha;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class VentanaConFichas extends Group {

    public VentanaConFichas(){
        super();
        Group principal = new VentanaPrincipal();
        this.getChildren().add(principal);
        this.agregarFicha();
    }

    private void agregarFicha(){
        ArrayList<Ficha> fichas = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            fichas.add(new Ficha("#ee3377"));
        }

        fichas.get(0).setPosicion(290, 165);//Groenlandia
        fichas.get(1).setPosicion(133, 177);//Canada
        fichas.get(2).setPosicion(230, 170);//Labrador
        fichas.get(3).setPosicion(80, 185);//Yukon
        fichas.get(4).setPosicion(30, 220);//Alaska
        fichas.get(5).setPosicion(70, 285);//Oregon
        fichas.get(6).setPosicion(120, 305);//California
        fichas.get(7).setPosicion(155, 210);//Nueva York
        fichas.get(8).setPosicion(185, 200);//Terranova
        fichas.get(9).setPosicion(220, 335);//Mexico

        //Oceania
        fichas.get(10).setPosicion(713, 410);//Sumatra
        fichas.get(11).setPosicion(768, 365);//Borneo
        fichas.get(12).setPosicion(838, 365);//Java
        fichas.get(13).setPosicion(796, 427);//Australia

        //Africa
        fichas.get(14).setPosicion(523, 405);//Sahara
        fichas.get(15).setPosicion(653, 410);//Egipto
        fichas.get(16).setPosicion(583, 420);//Etiopia
        fichas.get(17).setPosicion(542, 455);//Zaire
        fichas.get(18).setPosicion(623, 505);//Sudafrica
        fichas.get(19).setPosicion(663, 460);//Madagascar

        //America del Sur
        fichas.get(20).setPosicion(270, 340);//Colombia
        fichas.get(21).setPosicion(340, 400);//Brasil
        fichas.get(22).setPosicion(255, 395);//Peru
        fichas.get(23).setPosicion(260, 465);//Chile
        fichas.get(24).setPosicion(340, 450);//Uruguay
        fichas.get(25).setPosicion(300, 465);//Argentina

        //Europa
        fichas.get(26).setPosicion(370, 220);//Isalndia
        fichas.get(27).setPosicion(470, 235);//GB
        fichas.get(28).setPosicion(510, 165);//Suecia
        fichas.get(29).setPosicion(591, 195);//Rusia
        fichas.get(30).setPosicion(603, 265);//Polonia
        fichas.get(31).setPosicion(550, 275);//Alemania
        fichas.get(32).setPosicion(510, 290);//Francia
        fichas.get(33).setPosicion(550, 330);//Italia
        fichas.get(34).setPosicion(445, 335);//Espana

        //Asia
        fichas.get(35).setPosicion(623, 140);//Aral
        fichas.get(36).setPosicion(643, 120);//Tartaria
        fichas.get(37).setPosicion(688, 117);//Taymir
        fichas.get(38).setPosicion(738, 117);//Kamtchatka
        fichas.get(39).setPosicion(663, 169);//Siberia
        fichas.get(40).setPosicion(788, 144);//Japon
        fichas.get(41).setPosicion(691, 195);//Mongolia
        fichas.get(42).setPosicion(711, 262);//Gobi
        fichas.get(43).setPosicion(653, 220);//Iran
        fichas.get(44).setPosicion(768, 227);//China
        fichas.get(45).setPosicion(623, 315);//Turquia
        fichas.get(46).setPosicion(748, 305);//India
        fichas.get(47).setPosicion(813, 304);//Malasia
        fichas.get(48).setPosicion(628, 350);//Israel
        fichas.get(49).setPosicion(683, 365);//Arabia

        this.getChildren().addAll(fichas);
    }

}
