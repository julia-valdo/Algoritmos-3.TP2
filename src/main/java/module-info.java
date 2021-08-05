module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires javafx.media;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vista;
    opens edu.fiuba.algo3.vista to javafx.fxml;
}