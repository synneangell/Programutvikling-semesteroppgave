package org.openjfx.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.openjfx.controller.hjelpeklasser.InvalidFilDataException;
import org.openjfx.controller.hjelpeklasser.TrådLeserStarter;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class KulturhusetController {

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
    void opprettBillett (ActionEvent event) throws IOException {
        launchOpprettBillett();
    }

    @FXML
    void opprettArrangement (ActionEvent event) throws IOException {
        launchOpprettArrangement();
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

        if (markertFil != null){
            lblLasterInn.setText("Filen lastes inn...");
            Platform.runLater(() -> {
                try {
                    TrådLeserStarter.startLeser(markertFil);
                    threadFerdig();
                }
                catch (ExecutionException | InterruptedException e) {
                    lblLasterInn.setText("Filen ble ikke lastet inn.");
                    e.printStackTrace();
                }
            });
        } else {
            lblLasterInn.setText("Filen ble ikke lastet inn");
        }
    }

    private void launchOpprettBillett() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/opprettBillett.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    private void launchOpprettArrangement() throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/org/openjfx/opprettArrangement.fxml"));
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