package org.openjfx.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.openjfx.Base.Arrangement;
import org.openjfx.Base.DeltakerArrangement;
import org.openjfx.Base.Kontaktperson;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookLokaleController {

    @FXML
    private TextField kontakt_navn;

    @FXML
    private TextField kontakt_telefonnummer;

    @FXML
    private TextField kontakt_email;

    @FXML
    private TextField kontakt_nettside;

    @FXML
    private TextField kontakt_opplysninger;

    @FXML
    private TextField kontakt_virksomhet;

    @FXML
    private TextField arrangement_navn;

    @FXML
    private TextField arrangement_pris;

    @FXML
    private TextField arrangement_tidspunkt;

    @FXML
    private Label lbl_fullført_bestilling;


    @FXML
    void fullførBooking(ActionEvent event) throws ParseException {

        if(!kontakt_navn.getText().isEmpty() && !kontakt_telefonnummer.getText().isEmpty() && !kontakt_email.getText().isEmpty() &&
                !kontakt_nettside.getText().isEmpty() && !kontakt_opplysninger.getText().isEmpty() &&
                !kontakt_virksomhet.getText().isEmpty() && !arrangement_navn.getText().isEmpty() &&
                !arrangement_pris.getText().isEmpty() && !arrangement_tidspunkt.getText().isEmpty()){

            Kontaktperson kontaktperson = new Kontaktperson(kontakt_navn.getText(),kontakt_telefonnummer.getText(),kontakt_email.getText(),
                    kontakt_nettside.getText(),kontakt_opplysninger.getText(),
                    kontakt_virksomhet.getText());

            try{
                int billettpris = Integer.parseInt(arrangement_pris.getText());
                String innTidspunkt=arrangement_tidspunkt.getText();
                Date  tidspunkt =new SimpleDateFormat("dd/MM/yyyy").parse(innTidspunkt);


                DeltakerArrangement DeltakerArrangement = new DeltakerArrangement(kontaktperson, arrangement_navn.getText(), billettpris,
                        tidspunkt);
            }
            catch(Exception e){
                //feilmelding ut til bruker
                lbl_fullført_bestilling.setText("feilmelding");

            }

        }


    }

}
