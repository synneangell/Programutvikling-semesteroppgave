package org.openjfx.controller.uihelpers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.openjfx.controller.KjøpBillettController;

import java.util.Optional;

public class AlertBoks {

    public static void generateAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vellykket");
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }
}
