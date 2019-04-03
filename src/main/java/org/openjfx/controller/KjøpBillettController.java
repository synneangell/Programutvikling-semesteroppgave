package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.openjfx.base.ForestillingsArrangement;
import org.openjfx.base.ForestillingsArrangement;
import org.openjfx.base.Kjøper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KjøpBillettController {

    // Kjøperinfo:

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtTelefonnummer;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtVelgAntall;

    // Kontoopplysninger:

    @FXML
    private TextField txtKontonummer;

    @FXML
    private TextField txtNavnKortholder;

    //Kjøp:

    @FXML
    private Label lblDittKjøp;

    @FXML
    private Label lblÅBetale;

    @FXML
    private MenuButton mbtnBetalingskort;

    @FXML
    private MenuButton mbtnKvitteringForKjøp;

    @FXML
    private Button btnFullfør;

    @FXML
    private ChoiceBox cboxVelgForestilling;

    @FXML
    private ChoiceBox cboxVelgDatoTid;


    @FXML
    void fullførBestilling(ActionEvent event) throws ParseException {

        if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() && !txtEmail.getText().isEmpty() &&
                !txtVelgAntall.getText().isEmpty() && !txtKontonummer.getText().isEmpty() &&
                !txtNavnKortholder.getText().isEmpty()) {

            Kjøper kjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());

            // Skal vi også ha med velgantall?

            /*try{
                int billettpris = Integer.parseInt(arrangement_pris.getText());
                String innTidspunkt = arrangement_tidspunkt.getText();
                Date tidspunkt =new SimpleDateFormat("dd/MM/yyyy").parse(innTidspunkt);


                ForestillingsArrangement ForesetillingsArrangement = new ForestillingsArrangement
                        (kontaktperson, arrangement_navn.getText(), billettpris,
                        tidspunkt);
            }
            catch(Exception e){
                //feilmelding ut til bruker
                lblDittKjøp.setText("feilmelding");

            }*/

        }
    }
}