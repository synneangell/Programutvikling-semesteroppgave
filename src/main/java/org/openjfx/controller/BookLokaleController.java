package org.openjfx.controller;

import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
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
    void fullførBooking(ActionEvent event) throws ParseException {

        if(!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() && !txtEmail.getText().isEmpty() &&
                !txtNettside.getText().isEmpty() && !txtAndreOpplysninger.getText().isEmpty() &&
                !txtVirksomhet.getText().isEmpty() && !txtNavnArrangement.getText().isEmpty() &&
                !txtBillettpris.getText().isEmpty() && !txtTidspunkt.getText().isEmpty()  && !txtDato.getText().isEmpty()){

            Kontaktperson kontaktperson = new Kontaktperson(txtNavn.getText(),txtTelefonnummer.getText(),txtEmail.getText(),
                    txtNettside.getText(),txtAndreOpplysninger.getText(),
                    txtVirksomhet.getText());

            try{
                int billettpris = Integer.parseInt(txtBillettpris.getText());
                String innTidspunkt=txtTidspunkt.getText();
                String innDato = txtDato.getText();

                //setter sammen hele strengen som skal settes inn i datoformatet??
                String heleTidspunkt = innTidspunkt + innDato;

                //Tidspunktet til arrangementet skal ha formatet: 14:30 den 10/03/2019
                Date tidspunkt = new SimpleDateFormat("HH:mm den dd/MM/yyyy").parse(heleTidspunkt);


          //      DeltakerArrangement DeltakerArrangement = new DeltakerArrangement(kontaktperson, txtNavnArrangement.getText(),
           //             billettpris, tidspunkt);
            }
            catch(Exception e){
                //feilmelding ut til bruker
                lblFullførBestilling.setText("feilmelding");

            }

        }
    }

}
