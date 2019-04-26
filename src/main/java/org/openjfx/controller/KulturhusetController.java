package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.openjfx.Filbehandling.LesArrangementFraCsvFil;
import org.openjfx.Filbehandling.LesBillettFraCsvFil;
import org.openjfx.Filbehandling.LeseDataFraJobjFil;
import org.openjfx.base.AlleArrangementer;
import org.openjfx.base.Arrangement;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KulturhusetController {



    @FXML
    private AnchorPane rootPane;

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
    void lesInnBestilling (ActionEvent event) throws IOException, InvalidBillettFormatException {
        FileChooser fc = new FileChooser();

        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ og CSV filer", "*.csv", "*.jobj"));

        File markertFil = fc.showOpenDialog(null);

        if (markertFil != null) {
            AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

            String[] array = markertFil.getName().split(".");
            if(array.length > 1) {
                if (array[1].equals("csv")){
                    if(array[0].equals("billett")){
                        LesBillettFraCsvFil lesBillettFraCsvFil = new LesBillettFraCsvFil();
                        lesBillettFraCsvFil.leseFraFil(markertFil.getPath());


                    }
                    if(array[0].equals("arrangement")){
                        LesArrangementFraCsvFil lesArrangementFraCsvFil = new LesArrangementFraCsvFil();
                        alleArrangementer.gjørOmTilObservableList(lesArrangementFraCsvFil.leseFraFil(markertFil.getPath()));
                    }
                }
                if (array[1].equals("jobj")){
                    if(array[0].equals("billett")){
                        LeseDataFraJobjFil leseDataFraJobjFil = new LeseDataFraJobjFil();
                        leseDataFraJobjFil.leseFraFil(markertFil.getPath());

                    }
                    if(array[0].equals("arrangement")){
                        LeseDataFraJobjFil leseDataFraJobjFil = new LeseDataFraJobjFil();
                        alleArrangementer.gjørOmTilObservableList((ArrayList<? extends Arrangement>) leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                    }
                }

            }



        } else {
            System.out.println("Filen er ikke gyldig");
        }

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


}