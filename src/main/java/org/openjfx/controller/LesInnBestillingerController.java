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
import org.openjfx.Filbehandling.LeseDataFraJobjFil;

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

     FileChooser fc = new FileChooser();

     fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ og CSV filer", "*.csv"));

     File merkertFil = fc.showOpenDialog(null);

        String res = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(merkertFil))) {

            String line = "";
            while ((line = reader.readLine()) != null) {
                res += line;
                //lvOversikt.getItems().add(res);
            }

            System.out.println("resultat: " + line);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int teller = 0;
        String test = "";
        for(int i = 0; i < res.length(); i++) {
            teller++;
            test += res.charAt(i);
            if(teller == 50) {
                teller = 0;
                lvOversikt.getItems().add(test);
                test = "";
            }
        }

        if (merkertFil != null) {
            //lvOversikt.getItems().add(res);
            //Her må filsti være slik at man kan hente filen fra hvor som helst på pcen

        } else {
            System.out.println("Filen er ikke gyldig");
        }
    }
  }

