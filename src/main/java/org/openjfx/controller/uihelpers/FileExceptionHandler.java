package org.openjfx.controller.uihelpers;

import javafx.scene.control.Alert;

import java.io.IOException;

public class FileExceptionHandler {

    public static void generateAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Feil persondata");
        alert.setHeaderText("Feil persondata");
        alert.setContentText(msg);

        alert.showAndWait();
    }
}
