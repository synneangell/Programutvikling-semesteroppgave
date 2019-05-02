package org.openjfx.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.openjfx.Filbehandling.ArrangementCsvLeser;
import org.openjfx.Filbehandling.BillettCsvLeser;
import org.openjfx.Filbehandling.LeseJobjFil;
import org.openjfx.base.AlleArrangementer;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;
import org.openjfx.controller.uihelpers.InvalidFilData;
import org.openjfx.controller.uihelpers.Tråd;

import java.io.File;
import java.io.IOException;
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
    void lesInnBestilling (ActionEvent event) {
        FileChooser fc = new FileChooser();

        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ og CSV filer", "*.csv", "*.jobj"));

        File markertFil = fc.showOpenDialog(null);

            try {

                if (markertFil != null) {
                    AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

                    String[] array = markertFil.getName().split("\\.");
                    if(array.length > 1) {
                        if (array[1].equals("csv")){
                            if(array[0].equals("billett")){
                                BillettCsvLeser lesBillettFraCsvFil = new BillettCsvLeser();
                                lesBillettFraCsvFil.leseFraFil(markertFil.getPath());

                            }
                            if(array[0].equals("arrangement")){
                                ArrangementCsvLeser lesArrangementFraCsvFil = new ArrangementCsvLeser();
                                alleArrangementer.gjørOmTilObservableList(lesArrangementFraCsvFil.leseFraFil(markertFil.getPath()));
                            }
                        }
                        if (array[1].equals("jobj")){
                            if(array[0].equals("billett")){
                                LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                                leseDataFraJobjFil.leseFraFil(markertFil.getPath());

                            }
                            if(array[0].equals("arrangement")){
                                LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                                alleArrangementer.gjørOmTilObservableList(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                            }
                        }
                    }

                } else {
                    throw new InvalidFilData("Filen er ikke gyldig");
                }
            } catch (InvalidBillettFormatException | IOException | InvalidFilData e) {
                e.printStackTrace();
                // gjør ikke noe her, men hvis hvis du er i en løkke
                // burde løkkes stoppes med break hvis isCancelled() er true...
            }
        };

        /*
        lblLasterInn.setText("Laster inn fil...");
        btnLesInnBestilling.setDisable(true);
        Task<Void> task = new Tråd(this::threadDone);
        service.execute(task); */


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