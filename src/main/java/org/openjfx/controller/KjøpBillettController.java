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



public class KjøpBillettController {

    SkriveTilJobjFil skrivTilFil = new SkriveTilJobjFil();
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
    public void initialize() {
        // Setter opp kolonnene i Table View - tabellen
        ArrangementTypeColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("typeArrangement"));
        ArrangementNavnColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementNavn"));
        KlokkeslettColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("klokkeslett"));
        DatoColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));
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

                    System.out.println("Før billett opprettes:");
                    System.out.println("Size: "+etArrangement.visBilletterTilArrangement().size());
                    System.out.println("getAntallBilletter:"+etArrangement.getAntallBilletter());
                    System.out.println("Ledige billetter: "+etArrangement.ledigBilletter());
                    System.out.println("Solgte billetter: "+etArrangement.solgteBilletter());

                    //Oppretter x billetter som inneholder en kjøper og valgt arrangement:
                    int antallBilletter = Integer.valueOf((String) chboxVelgAntall.getValue());
                    System.out.println("Antall billetter valgt: "+antallBilletter);

                    Kjøper enKjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());
                    String ut = etArrangement.leggTilBillett(enKjøper, antallBilletter);

                        AlertBoks.generateAlert(ut);

                        System.out.println("Etter at billett har blitt opprettet: ");
                        System.out.println("Size: "+etArrangement.visBilletterTilArrangement().size());
                        System.out.println("getAntallBilletter:"+etArrangement.getAntallBilletter());
                        System.out.println("Ledige billetter: "+etArrangement.ledigBilletter());
                        System.out.println("Solgte billetter: "+etArrangement.solgteBilletter());
                    //} else {
                    //    FileExceptionHandler.generateAlert("Det er ikke nok billetter igjen. ");
                    //}
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
        AlleBilletter alleBilletter = AlleBilletter.getSingelton();

        if(filtype.equals(".csv")){
            SkriveTilCsvFil skriveTilCsvFil = new SkriveTilCsvFil();
            skriveTilCsvFil.skriveTilFil("billett.csv",alleBilletter.gjørOmBilletterTilArrayList(alleBilletter.getBilletter()));
        }
        else if(filtype.equals(".jobj")){
            SkriveTilJobjFil skriveTilJobjFil = new SkriveTilJobjFil();
            skriveTilJobjFil.skriveTilFil("billett.jobj",alleBilletter.gjørOmBilletterTilArrayList(alleBilletter.getBilletter()));
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