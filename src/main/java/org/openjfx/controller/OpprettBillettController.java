package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.openjfx.controller.hjelpeklasser.TrådLeser;
import org.openjfx.controller.hjelpeklasser.TrådLeserStarter;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class OpprettBillettController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label lblLasterInn;

    @FXML
    private Button btnLesInnBestilling;

    @FXML
    void endreArrangement(ActionEvent event) throws IOException {
        launchEndreArrangement();
    }

    @FXML
    void kjøpBillett (ActionEvent event) throws IOException {
        launchKjøpBillett();
    }

    @FXML
    void bookLokale (ActionEvent event) throws IOException {
        launchBookLokale();
    }

    @FXML
    void seBilletter (ActionEvent event) throws IOException {
        launchSeBilletter();
    }

    private void threadFerdig() {
        btnLesInnBestilling.setDisable(false);
        lblLasterInn.setText("Filen er lastet inn.");
    }

    @FXML
    void lesInnBestilling (ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ og CSV filer", "*.csv", "*.jobj"));
        File markertFil = fc.showOpenDialog(null);

        try {
            TrådLeserStarter.startLeser(markertFil);
            threadFerdig();
        }
        catch (ExecutionException | InterruptedException e) {
            lblLasterInn.setText("Filen ble ikke lastet inn.");
            e.printStackTrace();
        }
    }

    private void launchKjøpBillett() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/OpprettBillett.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    private void launchBookLokale() throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/org/openjfx/OpprettArrangement.fxml"));
        rootPane.getChildren().setAll(pane2);
    }

    private void launchEndreArrangement() throws IOException {
        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("/org/openjfx/endreArrangement.fxml"));
        rootPane.getChildren().setAll(pane3);
    }

    private void launchSeBilletter() throws IOException {
        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("/org/openjfx/seBilletter.fxml"));
        rootPane.getChildren().setAll(pane3);
    }
}