package org.openjfx.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.Filbehandling.SkriveTilCsvFil;
import org.openjfx.Filbehandling.SkriveTilJobjFil;
import org.openjfx.base.*;
import org.openjfx.controller.uihelpers.*;

public class BookLokaleController {

    SkriveTilJobjFil skrivTilJobj = new SkriveTilJobjFil();
    SkriveTilCsvFil skrivTilCsv = new SkriveTilCsvFil();
    ObservableList<String> typeArrangementer = FXCollections.observableArrayList("Konsert", "Foredrag");
    ObservableList<String> filtyper = FXCollections.observableArrayList(".jobj", ".csv");

    @FXML
    private TextField txtNavn, txtTelefonnummer, txtEmail, txtNettside, txtAndreOpplysninger, txtVirksomhet,
            txtNavnArrangement, txtBillettpris, txtTidspunkt, txtDato, txtDeltakerNavn, txtEgenskapDeltaker;

    @FXML
    private ChoiceBox velgTypeArrangement;

    @FXML
    private ComboBox chBoxKvittering;

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
    public void initialize() {
        //Tabellen lages her:
        TypeColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("typeArrangement"));
        ArrangementNavnColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementNavn"));
        KlokkeslettColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("klokkeslett"));
        DatoColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));

        Tableview.setItems(ModelViewArrangement.getArrangementer());
        velgTypeArrangement.setItems(typeArrangementer);
        velgTypeArrangement.setValue("Konsert");
        chBoxKvittering.setItems(filtyper);
        chBoxKvittering.setValue(".csv");
    }

    @FXML
    void fullførBooking(ActionEvent event) throws ParseException, InvalidTekstException, IOException {

        boolean konsert = false;
        boolean foredrag = false;
        boolean csv = false;
        boolean jobj = false;
        String valg = velgTypeArrangement.getValue().toString();
        String filtype = velgTypeArrangement.getValue().toString();

        if (valg == "Konsert") {
            konsert = true;
        } else if (valg == "Foredrag") {
            foredrag = true;
        }

        if(filtype == ".csv"){
            csv = true;
        }
        else if(filtype == ".jobj"){
            jobj = true;
        }

        if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() &&
                !txtEmail.getText().isEmpty() && !txtNettside.getText().isEmpty() &&
                !txtAndreOpplysninger.getText().isEmpty() && !txtVirksomhet.getText().isEmpty() &&
                !txtNavnArrangement.getText().isEmpty() && !txtBillettpris.getText().isEmpty() &&
                !txtTidspunkt.getText().isEmpty() && !txtDato.getText().isEmpty() &&
                !txtEgenskapDeltaker.getText().isEmpty() && !txtDeltakerNavn.getText().isEmpty()) {



            Kontaktperson kontaktperson = new Kontaktperson(
                    txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText(),
                    txtNettside.getText(), txtAndreOpplysninger.getText(), txtVirksomhet.getText());

            Deltaker deltaker = new Deltaker(txtDeltakerNavn.getText(), txtEgenskapDeltaker.getText());


            try {
                if(SjekkOmGyldig.sjekkKunBokstaver(txtNavn.getText()) && SjekkOmGyldig.sjekkGyldigTlfNr(txtTelefonnummer.getText()) &&
                SjekkOmGyldig.sjekkGyldigEmail(txtEmail.getText()) && SjekkOmGyldig.sjekkGyldigNettsideAdresse(txtNettside.getText()) &&
                SjekkOmGyldig.sjekkKunBokstaver(txtAndreOpplysninger.getText()) && SjekkOmGyldig.sjekkKunBokstaver(txtVirksomhet.getText())
                && SjekkOmGyldig.sjekkGyldigBillettpris(txtBillettpris.getText()) && SjekkOmGyldig.sjekkGyldigKlokkeslett(txtTidspunkt.getText())
                && SjekkOmGyldig.sjekkGyldigDato(txtDato.getText())){

                    int billettpris = Integer.parseInt(txtBillettpris.getText());

                    if (konsert) {

                        DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement
                            (kontaktperson, deltaker, txtNavnArrangement.getText(), billettpris, txtDato.getText(),
                             txtTidspunkt.getText(), ModelViewArrangement.antallPlasserKonsertsal(), TypeArrangement.KONSERT);

                        Tableview.getItems().add(etDeltakerArrangement);
                        skrivTilJobj.skriveTilFil("arrangement.jobj", etDeltakerArrangement);

                        //Oppretter kvittering
                        if(jobj){
                            skrivTilJobj.skriveTilFil("kvittering.jobj", etDeltakerArrangement);
                        }
                        else if(csv){
                            skrivTilCsv.skriveTilFil("kvittering.csv", etDeltakerArrangement);
                        }

                    }
                    else if (foredrag) {
                        DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement
                            (kontaktperson, deltaker, txtNavnArrangement.getText(), billettpris, txtDato.getText(),
                                    txtTidspunkt.getText(), ModelViewArrangement.antallPlasserForedragssal(), TypeArrangement.FOREDRAG);
                        Tableview.getItems().add(etDeltakerArrangement);
                        skrivTilJobj.skriveTilFil("arrangement.jobj", etDeltakerArrangement);

                        //Oppretter kvittering
                        if(jobj){
                            skrivTilJobj.skriveTilFil("kvittering.jobj", etDeltakerArrangement);
                        }
                        else if(csv){
                            skrivTilCsv.skriveTilFil("kvittering.csv", etDeltakerArrangement);
                        }
                    }

                }
            }
            catch (InvalidTekstException e) {
                FileExceptionHandler.generateAlert("Det er brukt tall der det kun skal være tekst. ");
            }
            catch (InvalidTelefonnummerException e) {
                FileExceptionHandler.generateAlert("Ikke gyldig telefonnummer skrevet inn. ");
            }
            catch (InvalidDatoException e) {
                FileExceptionHandler.generateAlert("Ikke gyldig dato. Format: dd/mm/åååå. ");
            }
            catch (InvalidKlokkeslettException e) {
                FileExceptionHandler.generateAlert("Ikke gyldig klokkeslett. Format: tt:mm. ");
            }
            catch (InvalidNettsideAdresseException e) {
                FileExceptionHandler.generateAlert("Ikke gyldig nettadresse skrevet inn.");
            }
            catch (InvalidEmailException e) {
                FileExceptionHandler.generateAlert("Ikke gyldig email skrevet inn.");
            }
            catch (InvalidBillettprisException e) {
                FileExceptionHandler.generateAlert("Billettpris må bestå av tall.");
            }
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
