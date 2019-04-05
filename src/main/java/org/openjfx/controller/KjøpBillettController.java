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

    //Kjøp:

    @FXML
    private Label lblDittKjøp;

    @FXML
    private MenuButton mbtnKvitteringForKjøp;

    @FXML
    private Button btnFullfør;

    @FXML
    private ChoiceBox cboxVelgForestilling;

    @FXML
    private ChoiceBox cboxVelgDatoTid;

    @FXML
    private ChoiceBox cboxVelgAntall;


    @FXML
    void fullførBestilling(ActionEvent event) throws ParseException {
        if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() && !txtEmail.getText().isEmpty()
          && !cboxVelgDatoTid.getItems().isEmpty() && !cboxVelgAntall.getItems().isEmpty()) {

            Kjøper kjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());


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