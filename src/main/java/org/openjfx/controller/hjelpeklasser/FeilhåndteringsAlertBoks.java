package org.openjfx.controller.hjelpeklasser;

import javafx.scene.control.Alert;

public class FeilhåndteringsAlertBoks {

    public static void generateAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Feil input");
        alert.setHeaderText("Feil input");
        alert.setContentText(msg);

        alert.showAndWait();
    }
}
