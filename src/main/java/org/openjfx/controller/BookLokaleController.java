package org.openjfx.controller;

import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.Filbehandling.SkriveCsvFil;
import org.openjfx.Filbehandling.SkriveJobjFil;
import org.openjfx.base.*;
import org.openjfx.controller.hjelpeklasser.*;

public class BookLokaleController {

    ObservableList<String> typeArrangementer = FXCollections.observableArrayList("Konsert", "Foredrag");
    ObservableList<String> filtyper = FXCollections.observableArrayList(".jobj", ".csv");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML
    private TextField txtNavn, txtTelefonnummer, txtEmail, txtNettside, txtAndreOpplysninger, txtVirksomhet,
            txtNavnArrangement, txtBillettpris, txtTidspunkt, txtDato, txtDeltakerNavn, txtEgenskapDeltaker;

    @FXML
    private ChoiceBox velgTypeArrangement;

    @FXML
    private ComboBox lagreTilFilBox;

    @FXML
    private AnchorPane rootBookLokale;

    @FXML
    private TableView<Arrangement> Tableview;

    @FXML
    private TableColumn<Arrangement, String> TypeColumn;

    @FXML
    private TableColumn<Arrangement, String> ArrangementNavnColumn;

    @FXML
    private TableColumn<Arrangement, String> KlokkeslettColumn;

    @FXML
    private TableColumn<Arrangement, String> DatoColumn;

    @FXML
    private DatePicker dato;


    @FXML
    public void initialize() {
        //Tabellen med arrangementer opprettes her:
        TypeColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("typeArrangement"));
        ArrangementNavnColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementNavn"));
        KlokkeslettColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("klokkeslett"));
        DatoColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));

        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();
        Tableview.setItems(alleArrangementer.getArrangementer());
        velgTypeArrangement.setItems(typeArrangementer);
        velgTypeArrangement.setValue("Konsert");

        lagreTilFilBox.setItems(filtyper);
        lagreTilFilBox.setValue(".csv");
    }

    @FXML
    void fullførBooking(ActionEvent event) throws ParseException, InvalidTekstException, IOException {

        //Dette gjøres for å vite hvilket lokale arrangementet skal legges til
        boolean konsert = false;
        boolean foredrag = false;
        String valg = velgTypeArrangement.getValue().toString();

        if (valg == "Konsert") {
            konsert = true;
        } else if (valg == "Foredrag") {
            foredrag = true;
        }


        if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() &&
                !txtEmail.getText().isEmpty() && !txtNettside.getText().isEmpty() &&
                !txtAndreOpplysninger.getText().isEmpty() && !txtVirksomhet.getText().isEmpty() &&
                !txtNavnArrangement.getText().isEmpty() && !txtBillettpris.getText().isEmpty() &&
                !txtTidspunkt.getText().isEmpty() &&
                !txtEgenskapDeltaker.getText().isEmpty() && !txtDeltakerNavn.getText().isEmpty()) {


            //Validering av inputfelter:
            try {
                if(SjekkOmGyldig.sjekkKunBokstaver(txtNavn.getText()) && SjekkOmGyldig.sjekkGyldigTlfNr(txtTelefonnummer.getText()) &&
                SjekkOmGyldig.sjekkGyldigEmail(txtEmail.getText()) && SjekkOmGyldig.sjekkGyldigNettsideAdresse(txtNettside.getText()) &&
                SjekkOmGyldig.sjekkKunBokstaver(txtAndreOpplysninger.getText()) && SjekkOmGyldig.sjekkKunBokstaver(txtVirksomhet.getText())
                && SjekkOmGyldig.sjekkGyldigBillettpris(txtBillettpris.getText()) && SjekkOmGyldig.sjekkGyldigKlokkeslett(txtTidspunkt.getText())){

                    Kontaktperson kontaktperson = new Kontaktperson(
                            txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText(),
                            txtNettside.getText(), txtAndreOpplysninger.getText(), txtVirksomhet.getText());

                    Deltaker deltaker = new Deltaker(txtDeltakerNavn.getText(), txtEgenskapDeltaker.getText());

                    AlleLokaler alleLokaler = AlleLokaler.getSingelton();

                    int billettpris = Integer.parseInt(txtBillettpris.getText());

                    if (konsert) {
                        DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement
                            (kontaktperson, deltaker, txtNavnArrangement.getText(), billettpris, dato.getValue().format(dtf),
                             txtTidspunkt.getText(), AlleLokaler.antallPlasser(alleLokaler.getKonsertsal()), TypeArrangement.KONSERT);

                        Tableview.getItems().add(etDeltakerArrangement);
                        AlertBoks.generateAlert("Din bestillingen er gjennomført! ");

                    }
                    else if (foredrag) {
                        DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement
                            (kontaktperson, deltaker, txtNavnArrangement.getText(), billettpris, dato.getValue().format(dtf),
                             txtTidspunkt.getText(), AlleLokaler.antallPlasser(alleLokaler.getForedragssal()), TypeArrangement.FOREDRAG);

                        Tableview.getItems().add(etDeltakerArrangement);
                        AlertBoks.generateAlert("Din bestillingen er gjennomført! ");
                    }

                }
            }
            catch (InvalidTekstException e) {
                FeilhåndteringsAlertBoks.generateAlert("Det er brukt tall der det kun skal være tekst. ");
            }
            catch (InvalidTelefonnummerException e) {
                FeilhåndteringsAlertBoks.generateAlert("Ikke gyldig telefonnummer skrevet inn. ");
            }
            catch (InvalidKlokkeslettException e) {
                FeilhåndteringsAlertBoks.generateAlert("Ikke gyldig klokkeslett. Format: tt:mm. ");
            }
            catch (InvalidNettsideAdresseException e) {
                FeilhåndteringsAlertBoks.generateAlert("Ikke gyldig nettadresse skrevet inn.");
            }
            catch (InvalidEmailException e) {
                FeilhåndteringsAlertBoks.generateAlert("Ikke gyldig email skrevet inn.");
            }
            catch (InvalidBillettprisException e) {
                FeilhåndteringsAlertBoks.generateAlert("Billettpris må bestå av tall.");
            }
        }
    }

    @FXML
    void Lagre (ActionEvent event) throws IOException {
        String filtype = lagreTilFilBox.getValue().toString();
        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

        if(filtype.equals(".csv")){
            SkriveCsvFil skriveTilCsvFil = new SkriveCsvFil();
            skriveTilCsvFil.skriveTilFil("arrangement.csv",alleArrangementer.gjørOmTilArrayList(alleArrangementer.getArrangementer()));
        }
        else if(filtype.equals(".jobj")){
            SkriveJobjFil skriveTilJobjFil = new SkriveJobjFil();
            skriveTilJobjFil.skriveTilFil("arrangement.jobj",alleArrangementer.gjørOmTilArrayList(alleArrangementer.getArrangementer()));

        }
    }

    private void avsluttProgram() {
        Stage stage = (Stage) txtTidspunkt.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Avslutt(ActionEvent event){
        avsluttProgram();
    }

    @FXML
    private void Tilbake(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/kulturhuset.fxml"));
        rootBookLokale.getChildren().setAll(pane);
    }
}
