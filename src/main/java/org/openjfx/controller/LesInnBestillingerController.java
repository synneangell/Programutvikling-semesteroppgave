package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class LesInnBestillingerController {

    @FXML
    private AnchorPane rootLesInnBestillinger;

    @FXML
    private Button btnAvslutt;


    private void avsluttProgram() {
        Stage stage = (Stage) btnAvslutt.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Avslutt (ActionEvent event){
        avsluttProgram();
    }

    @FXML
    private void Tilbake (ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/kulturhuset.fxml"));
        rootLesInnBestillinger.getChildren().setAll(pane);
    }

    @FXML
    private void SøkEtterFil(ActionEvent event){

    }
  }

