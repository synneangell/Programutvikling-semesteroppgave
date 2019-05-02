package org.openjfx.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.openjfx.Filbehandling.LesArrangementFraCsvFil;
import org.openjfx.Filbehandling.LesBillettFraCsvFil;
import org.openjfx.Filbehandling.LeseDataFraJobjFil;
import org.openjfx.base.AlleArrangementer;
import org.openjfx.base.Arrangement;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;
import org.openjfx.controller.uihelpers.Tråd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KulturhusetController {

    private ExecutorService service = Executors.newSingleThreadExecutor();

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

    private void threadDone() {
        btnLesInnBestilling.setDisable(false);
        lblLasterInn.setText("Filen er lastet inn.");
    }

    @FXML
    void lesInnBestilling (ActionEvent event) throws IOException, InvalidBillettFormatException {
        lblLasterInn.setText("Laster inn fil...");
        btnLesInnBestilling.setDisable(true);
        Task<Void> task = new Tråd(this::threadDone);
        service.execute(task);
    }

    private void launchKjøpBillett() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/kjøpBillett.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    private void launchBookLokale() throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/org/openjfx/bookLokale.fxml"));
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