package org.openjfx.controller.hjelpeklasser;

import javafx.scene.control.Alert;

public class AlertBoks {

    public static void generateAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vellykket");
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }
}
