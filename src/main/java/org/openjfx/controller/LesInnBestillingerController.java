package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LesInnBestillingerController {

    @FXML
    private AnchorPane rootLesInnBestillinger;

    @FXML
    private Button btnAvslutt;

    @FXML
    private ListView lvOversikt;

    @FXML
    private Label lblOversikt;


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


    //Er det sånn at jeg bruker filechooser generelt til å lese hvilken som helst fil eller må jeg lage if setninger som
    //igjen går ut ifra hva brukeren trykker på i programmet (csv eller jobj)


    @FXML
    private void SøkEtterFil(ActionEvent event){


    }
  }

