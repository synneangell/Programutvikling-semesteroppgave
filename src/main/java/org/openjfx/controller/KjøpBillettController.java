package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.Filbehandling.*;
import org.openjfx.base.*;
import org.openjfx.controller.uihelpers.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


public class KjøpBillettController {

    ObservableList<String> AntallBilletter = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    ObservableList<String> filtyper = FXCollections.observableArrayList(".jobj", ".csv");

    @FXML
    private TextField txtNavn, txtTelefonnummer, txtEmail;

    @FXML
    private ComboBox chboxVelgAntall;

    @FXML
    private ComboBox lagreTilFilBox;

    @FXML
    private Button btnAvslutt;

    @FXML
    private AnchorPane rootKjøpBillett;

    @FXML
    private TableView<Arrangement> tableView;

    @FXML
    private TableColumn<Arrangement, String> ArrangementTypeColumn;

    @FXML
    private TableColumn<Arrangement, String> ArrangementNavnColumn;

    @FXML
    private TableColumn<Arrangement, String> KlokkeslettColumn;

    @FXML
    private TableColumn<Arrangement, String> DatoColumn;


    @FXML
    private TableColumn<Arrangement, Integer> PrisColumn;


    @FXML
    public void initialize() {
        // Setter opp kolonnene i Table View - tabellen
        ArrangementTypeColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("typeArrangement"));
        ArrangementNavnColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementNavn"));
        KlokkeslettColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("klokkeslett"));
        DatoColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));
        PrisColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, Integer>("billettpris"));

        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();
        tableView.setItems(alleArrangementer.getArrangementer());
        chboxVelgAntall.setItems(AntallBilletter);
        chboxVelgAntall.setValue("1");
        lagreTilFilBox.setItems(filtyper);
        lagreTilFilBox.setValue(".csv");

    }

    @FXML
     void fullførBestilling(ActionEvent event) throws ParseException, IOException {

            if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() && !txtEmail.getText().isEmpty()) {

                try {
                    if (SjekkOmGyldig.sjekkKunBokstaver(txtNavn.getText()) && SjekkOmGyldig.sjekkGyldigTlfNr(txtTelefonnummer.getText()) &&
                            SjekkOmGyldig.sjekkGyldigEmail(txtEmail.getText())) {

                        Arrangement etArrangement = tableView.getSelectionModel().getSelectedItem();

                        int antallBilletter = Integer.valueOf((String) chboxVelgAntall.getValue());

                        Kjøper enKjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());
                        String ut = etArrangement.leggTilBillett(enKjøper, antallBilletter);

                        AlertBoks.generateAlert(ut);


                    }
                } catch (InvalidTekstException e) {
                    FileExceptionHandler.generateAlert("Det er brukt tall der det kun skal være tekst. ");
                } catch (InvalidTelefonnummerException e) {
                    FileExceptionHandler.generateAlert("Ikke gyldig telefonnummer skrevet inn. ");
                } catch (InvalidEmailException e) {
                    FileExceptionHandler.generateAlert("Ikke gyldig email skrevet inn.");
                }
            }
        }



   @FXML
    void Lagre (ActionEvent event) throws IOException {
    String filtype = lagreTilFilBox.getValue().toString();
        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

        ArrayList<Billett> lagreBilletterTilFil = new ArrayList<>();

        for(Arrangement etArrangement : alleArrangementer.getArrangementer()){
            for(Billett enBillett : etArrangement.getBilletter()){
                if(enBillett.getKjøper() != null) {
                    lagreBilletterTilFil.add(enBillett);
                }
            }
        }

        if(filtype.equals(".csv")){
            SkriveCsvFil skriveTilCsvFil = new SkriveCsvFil();
            skriveTilCsvFil.skriveTilFil("billett.csv", lagreBilletterTilFil);
        }
        else if(filtype.equals(".jobj")){
            SkriveJobjFil skriveTilJobjFil = new SkriveJobjFil();
            skriveTilJobjFil.skriveTilFil("billett.jobj",lagreBilletterTilFil);
        }
    }

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
            rootKjøpBillett.getChildren().setAll(pane);
      }
}