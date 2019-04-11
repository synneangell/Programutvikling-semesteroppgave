package org.openjfx.controller;

import java.io.IOException;
import java.text.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.openjfx.base.*;
import org.openjfx.controller.uihelpers.InputValidering;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookLokaleController {

    ObservableList<String> typeArrangementer = FXCollections.observableArrayList("Konsert", "Foredrag");
    LokalRegister lokalregister = new LokalRegister();
    // ArrangementRegister arrangementregister = new ArrangementRegister();

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtTelefonnummer;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNettside;

    @FXML
    private TextField txtAndreOpplysninger;

    @FXML
    private TextField txtVirksomhet;

    @FXML
    private TextField txtNavnArrangement;

    @FXML
    private TextField txtBillettpris;

    @FXML
    private TextField txtTidspunkt;

    @FXML
    private DatePicker dpDato;

    @FXML
    private TextField txtDeltakerNavn;

    @FXML
    private TextField txtEgenskapDeltaker;

    @FXML
    private Label lblFullførBestilling;

    @FXML
    private Label lblOversiktOpplysninger;

    @FXML
    private ChoiceBox velgTypeArrangement;

    @FXML
    private Button btnAvslutt;

    @FXML
    private Button btnTilbake;

    @FXML
    private AnchorPane rootPane;


    @FXML
    private void initialize(){
        velgTypeArrangement.setItems(typeArrangementer);
    }

    @FXML
    void fullførBooking(ActionEvent event) throws ParseException {

        boolean konsert = false;
        boolean foredrag = false;
        if(velgTypeArrangement.getValue() == "konsert"){
            konsert = true;
        }
        else if(velgTypeArrangement.getValue() == "foredrag"){
            foredrag = true;
        }

        //Sjekker her at alle felt er fylt inn
        if(!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() &&
                !txtEmail.getText().isEmpty() && !txtNettside.getText().isEmpty() &&
                !txtAndreOpplysninger.getText().isEmpty() && !txtVirksomhet.getText().isEmpty() &&
                !txtNavnArrangement.getText().isEmpty() && !txtBillettpris.getText().isEmpty() &&
                !txtTidspunkt.getText().isEmpty() &&
                !txtEgenskapDeltaker.getText().isEmpty() && !txtDeltakerNavn.getText().isEmpty()){
            //må datepicker også sjekkes her?


            //Input validering av alle feltene bruker skriver inn på
            InputValidering.validerKunTekst(txtNavn, txtNavn.getText());
            // InputValidering.validerKunTelefonnummer(txtTelefonnummer, txtTelefonnummer.getText());
            //InputValidering.validerEmail(txtEmail, txtEmail.getText());
            //InputValidering.validerNettside(txtNettside, txtNettside.getText());
            //Andre opplysninger ikke nødvendig å input validere? Fri tekst, kan ha tall
            InputValidering.validerKunTekst(txtVirksomhet, txtVirksomhet.getText());
            InputValidering.validerKunTekst(txtNavnArrangement, txtNavnArrangement.getText());
            InputValidering.validerKunTall(txtBillettpris, txtBillettpris.getText());
            //Tidspunkt og dato??
            InputValidering.validerKunTekst(txtEgenskapDeltaker, txtEgenskapDeltaker.getText());
            InputValidering.validerKunTekst(txtDeltakerNavn, txtDeltakerNavn.getText());


            Kontaktperson kontaktperson = new Kontaktperson(
                    txtNavn.getText(),txtTelefonnummer.getText(),txtEmail.getText(),
                    txtNettside.getText(),txtAndreOpplysninger.getText(), txtVirksomhet.getText());

            Deltaker deltaker = new Deltaker(txtDeltakerNavn.getText(),txtEgenskapDeltaker.getText());


            try{    //MÅ SE PÅ HELE DELEN MED PARSING TIL DATOFORMAT
                int billettpris = Integer.parseInt(txtBillettpris.getText());
                //Tidspunktet til arrangementet skal ha formatet for eks: 14:30 den 10/03/2019
                //Blir dette riktig?
                Date tidspunkt = new Date(txtTidspunkt.getText() + dpDato.getValue());

                if(konsert){
                    DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement(
                            kontaktperson, txtNavnArrangement.getText(), billettpris, tidspunkt, 400);
                    lokalregister.registrerKonsertArrangement(etDeltakerArrangement);
                }
                else if(foredrag){
                    DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement(
                    kontaktperson, txtNavnArrangement.getText(), billettpris, tidspunkt, 100);
                    lokalregister.registrerForedragsArrangement(etDeltakerArrangement);

                }
                else{
                    //Feilhåndtere at ingen arrangementtype er valgt
                    String feilmelding = "Ingen arrangementtype er valgt!";
                    lblFullførBestilling.setText(feilmelding);
                }
            }
            catch(Exception e){
                //feilmelding ut til bruker
                String feilmelding = "Noe gikk galt.";
                lblFullførBestilling.setText(feilmelding);
            }
        }
    }

    @FXML
    private void Avslutt(ActionEvent event){
        Stage stage2 = (Stage) btnAvslutt.getScene().getWindow();
        stage2.close();
    }

    @FXML
    private void Tilbake (ActionEvent event) throws IOException {
        btnTilbake.getScene().getWindow().hide();
    }
}
