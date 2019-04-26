package org.openjfx.controller.uihelpers;

import javafx.scene.control.Alert;

import java.io.IOException;

public class FileExceptionHandler {

    public static void generateAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Feil input");
        alert.setHeaderText("Feil input");
        alert.setContentText(msg);

        alert.showAndWait();
    }
}
