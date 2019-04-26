package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.Filbehandling.LeseDataFraJobjFil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LesInnBestillingerController {

    LeseDataFraJobjFil ldfj = new LeseDataFraJobjFil();

    @FXML
    private AnchorPane rootLesInnBestillinger;

    @FXML
    private Button btnAvslutt;

    @FXML
    private ListView lvOversikt;

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

     FileChooser fc = new FileChooser();

     fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ filer", "*.jobj"));

     File merkertFil = fc.showOpenDialog(null);

     if (merkertFil != null){
        //lvOversikt.getItems().add(ldfj.leseFraFil("/Users/nikolasekiw/Desktop"));
     } else {
        System.out.println("Filen er ikke gyldig");
     }
  }
    }


