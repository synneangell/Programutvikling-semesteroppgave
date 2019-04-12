package org.openjfx.controller;

import java.io.IOException;
import java.text.ParseException;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.base.*;
import org.openjfx.controller.uihelpers.*;

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
    private Button btnAvslutt;

    @FXML
    private Button btnTilbake;

    @FXML
    private ChoiceBox velgTypeArrangement;

    @FXML
    private AnchorPane rootBookLokale;



    @FXML
    private void initialize(){
        velgTypeArrangement.setItems(typeArrangementer);
        velgTypeArrangement.setValue("Konsert");
    }

  /*  //TODO: Er dette nødvendig å ha med? I så fall bør det kanskje løses annerledes?
    @FXML
    private void alleOpplysningerRegistrert(ActionEvent e){
        //TODO: Sett inn også dato/tidspunkt i lblOversiktOpplysninger
        lblOversiktOpplysninger.setText("Informasjon om arrangement: \n"+txtNavnArrangement.getText()+txtBillettpris.getText()+"\n"+
                "Informasjon om kontaktperson: \n"+txtNavn.getText()+txtTelefonnummer.getText()+txtEmail.getText()+"\n"+
                txtNettside.getText()+txtAndreOpplysninger.getText()+txtVirksomhet.getText()+"\n"+
                "Informasjon om deltaker: \n"+txtDeltakerNavn.getText()+txtEgenskapDeltaker.getText());
    } */

    @FXML
    void fullførBooking(ActionEvent event) throws ParseException, InvalidInputException, InvalidEmailException {

        lblOversiktOpplysninger.setText("Her er oversikten over bookingen: ");

        boolean konsert = false;
        boolean foredrag = false;
        String valg = velgTypeArrangement.getValue().toString();

        if(valg == "Konsert"){
            konsert = true;
        }
        else if(valg == "Foredrag"){
            foredrag = true;
        }

        //Sjekker her at alle felt er fylt inn
       /* if(!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() &&
                !txtEmail.getText().isEmpty() && !txtNettside.getText().isEmpty() &&
                !txtAndreOpplysninger.getText().isEmpty() && !txtVirksomhet.getText().isEmpty() &&
                !txtNavnArrangement.getText().isEmpty() && !txtBillettpris.getText().isEmpty() &&
                !txtTidspunkt.getText().isEmpty() &&
                !txtEgenskapDeltaker.getText().isEmpty() && !txtDeltakerNavn.getText().isEmpty()){ */
            //må datepicker også sjekkes her?

        SjekkOmGyldig.sjekkGyldigNavn(txtNavn.getText());
        SjekkOmGyldig.sjekkGyldigEmail(txtEmail.getText());
        SjekkOmGyldig.sjekkGyldigTlfNr(txtTelefonnummer.getText());
        //SjekkOmGyldig.sjekkGyldigBillettPris(txtBillettpris.getText());


            Kontaktperson kontaktperson = new Kontaktperson(
                    txtNavn.getText(),txtTelefonnummer.getText(),txtEmail.getText(),
                    txtNettside.getText(),txtAndreOpplysninger.getText(), txtVirksomhet.getText());

            Deltaker deltaker = new Deltaker(txtDeltakerNavn.getText(),txtEgenskapDeltaker.getText());


            try{    //MÅ SE OM IGJEN PÅ HELE DELEN MED PARSING TIL DATOFORMAT
                int billettpris = Integer.parseInt(txtBillettpris.getText());

                //Hvordan formatere denne riktig til date(år, måned, dag, time, minutt)??

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String innTidspunkt = dpDato.getValue()+" "+txtTidspunkt.getText();
                Date tidspunkt = format.parse(innTidspunkt);
                System.out.println(tidspunkt);

                if(konsert){
                    DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement(
                            kontaktperson, txtNavnArrangement.getText(), billettpris, tidspunkt, 400, TypeArrangement.KONSERT);
                    lokalregister.registrerKonsertArrangement(etDeltakerArrangement);
                }
                else if(foredrag){
                    DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement(
                    kontaktperson, txtNavnArrangement.getText(), billettpris, tidspunkt, 100, TypeArrangement.FOREDRAG);
                    lokalregister.registrerForedragsArrangement(etDeltakerArrangement);
                }

            }
            catch(Exception e){
                //feilmelding ut til bruker
                String feilmelding = "Noe gikk galt.";
                lblFullførBestilling.setText(feilmelding);

            }
        }

    //Kode for å enten lukke vindu med bookLokale, og kode for å avslutte hele programmet:
    private void avsluttProgram() {
        Stage stage = (Stage) btnAvslutt.getScene().getWindow();
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
