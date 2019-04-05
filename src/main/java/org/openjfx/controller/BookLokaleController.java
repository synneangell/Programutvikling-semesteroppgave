package org.openjfx.controller;

import java.text.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.openjfx.base.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookLokaleController {

    ObservableList<String> typeArrangementer = FXCollections.observableArrayList("Konsert", "Foredrag");

    //initialiserings klasse?
    LokalRegister lokalregister = new LokalRegister();
    ArrangementRegister arrangementregister = new ArrangementRegister();

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
    private TextField txtDato;

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
    private Button btnAvbryt;

    @FXML
    private MenuButton mbtnTypeArrangement;

    @FXML
    private MenuButton mbtnKvitteringForBooking;

    @FXML
    private MenuItem mitemKonsert;

    @FXML
    private MenuItem mitemForedrag;

    @FXML
    private ChoiceBox velgTypeArrangement;


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
                !txtTidspunkt.getText().isEmpty() && !txtDato.getText().isEmpty() &&
                !txtEgenskapDeltaker.getText().isEmpty() && !txtDeltakerNavn.getText().isEmpty()){

            Kontaktperson kontaktperson = new Kontaktperson(
                    txtNavn.getText(),txtTelefonnummer.getText(),txtEmail.getText(),
                    txtNettside.getText(),txtAndreOpplysninger.getText(), txtVirksomhet.getText());

            Deltaker deltaker = new Deltaker(txtDeltakerNavn.getText(),txtEgenskapDeltaker.getText());


            try{    //MÅ SE PÅ HELE DELEN MED PARSING TIL DATOFORMAT
                int billettpris = Integer.parseInt(txtBillettpris.getText());
                String innTidspunkt=txtTidspunkt.getText();
                String innDato = txtDato.getText();

                //setter sammen hele strengen som skal settes inn i datoformatet??
                String heleTidspunkt = innTidspunkt + innDato;

                //Tidspunktet til arrangementet skal ha formatet for eks: 14:30 den 10/03/2019
                Date tidspunkt = new SimpleDateFormat("HH:mm den dd/MM/yyyy").parse(heleTidspunkt);

                DeltakerArrangement etDeltakerArrangement = new DeltakerArrangement(
                        kontaktperson, txtNavnArrangement.getText(), billettpris, tidspunkt);

                if(konsert){
                    arrangementregister.registrerKonsertArrangement(etDeltakerArrangement);
                }
                else if(foredrag){
                    arrangementregister.registrerForedragsArrangement(etDeltakerArrangement);
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

}
