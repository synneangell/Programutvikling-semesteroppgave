package org.openjfx.controller;

import java.io.IOException;
import java.text.ParseException;

import javafx.collections.*;
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
        //Får nullpointerException på linje 84

        String valg = velgTypeArrangement.getValue().toString();

        if(valg == "Konsert"){
            konsert = true;
        }
        else if(valg == "Foredrag"){
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

            Kontaktperson kontaktperson = new Kontaktperson(
                    txtNavn.getText(),txtTelefonnummer.getText(),txtEmail.getText(),
                    txtNettside.getText(),txtAndreOpplysninger.getText(), txtVirksomhet.getText());

            Deltaker deltaker = new Deltaker(txtDeltakerNavn.getText(),txtEgenskapDeltaker.getText());


            try{    //MÅ SE OM IGJEN PÅ HELE DELEN MED PARSING TIL DATOFORMAT
                int billettpris = Integer.parseInt(txtBillettpris.getText());
                //Hvordan formatere denne riktig til date(år, måned, dag, time, minutt)??
                Date tidspunkt = new Date(dpDato.getValue()+txtTidspunkt.getText());

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
