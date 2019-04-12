package org.openjfx.controller.uihelpers;

import javafx.scene.control.Alert;

import java.io.IOException;

public class FileExceptionHandler {

    public static void generateIOExceptionMsg(IOException e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Filhåndtering feil");
        alert.setHeaderText("Filhåndtering feil");
        alert.setContentText("Feil oppstod i lagringen av personen. \nMelding: " + e.getMessage());

        alert.showAndWait();
    }
}
