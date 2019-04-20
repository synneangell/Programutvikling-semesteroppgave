package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LesInnBestillingerController {

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

    //TODO: hvis jeg skal lese fra CSV fil via filechooser må jeg lese filen inn i TableView (for øyeblikket bruker jeg listView.
    // Må kanskje gjøre slik at det kommer opp TableView når brukeren velger csv fil? Tror ikke det går an å ha jobj fil i TableView.


    @FXML
    private void SøkEtterFil(ActionEvent event){

      FileChooser fc = new FileChooser();

     fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files", "*.txt"));

     File merkertFil = fc.showOpenDialog(null);

     if (merkertFil != null){
        lvOversikt.getItems().add(merkertFil.getName()); //Innholdet i filen kommer ikke opp fordi her sier jeg at kun navnet skal komme opp.
     } else {
        System.out.println("Filen er ikke gyldig");
     }
  }
    }


