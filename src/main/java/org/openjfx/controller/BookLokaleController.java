package org.openjfx.controller;

import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.openjfx.base.Deltaker;
import org.openjfx.base.DeltakerArrangement;
import org.openjfx.base.Kontaktperson;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookLokaleController {

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
    void fullførBooking(ActionEvent event) throws ParseException {

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

                //Tidspunktet til arrangementet skal ha formatet: 14:30 den 10/03/2019
                Date tidspunkt = new SimpleDateFormat("HH:mm den dd/MM/yyyy").parse(heleTidspunkt);


                DeltakerArrangement DeltakerArrangement = new DeltakerArrangement(kontaktperson, txtNavnArrangement.getText(), billettpris,
                        tidspunkt);


            }
            catch(Exception e){
                //feilmelding ut til bruker
                lblFullførBestilling.setText("feilmelding");

            }

        }


    }

}
