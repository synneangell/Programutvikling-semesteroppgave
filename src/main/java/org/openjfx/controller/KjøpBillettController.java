package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.openjfx.base.*;
import java.text.ParseException;
import java.util.Date;


public class KjøpBillettController {

    LokalRegister lokalRegister = new LokalRegister();
    BillettRegister billettRegister = new BillettRegister();
    ArrangementRegister arrangementRegister = new ArrangementRegister();

    ObservableList<String> BillettType = FXCollections.observableArrayList("Kino", "Teater", "Konsert", "Foredrag");

    ObservableList<String> AntallBilletter = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");

    ObservableList<String> Kino = FXCollections.observableArrayList(lokalRegister.ArrayTilString(lokalRegister.kinoArrangementer));

    ObservableList<String> Teater = FXCollections.observableArrayList(lokalRegister.ArrayTilString(lokalRegister.teaterArrangementer));

    ObservableList<String> Konsert = FXCollections.observableArrayList(lokalRegister.ArrayTilString(lokalRegister.konsertArrangementer));

    ObservableList<String> Foredrag = FXCollections.observableArrayList(lokalRegister.ArrayTilString(lokalRegister.foredragsArrangementer));

    // Kjøperinfo:

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtTelefonnummer;

    @FXML
    private TextField txtEmail;

    // Valg:

    @FXML
    private ComboBox chboxVelgForestilling;

    @FXML
    private ComboBox chboxVelgDatoTid;

    @FXML
    private ComboBox chboxVelgAntall;

    @FXML
    private ComboBox chboxVelgBillettType;

    // Kjøp:

    @FXML
    private Label lblDittKjøp;


    @FXML
    public void initialize() {
        chboxVelgBillettType.setItems(BillettType);
        chboxVelgAntall.setItems(AntallBilletter);

        chboxVelgBillettType.valueProperty().addListener((ob, o, n) -> {
            if (n.toString().equals("Kino")) {
                chboxVelgForestilling.setItems(Kino);
            } else if (n.toString().equals("Teater")) {
                chboxVelgForestilling.setItems(Teater);
            } else if (n.toString().equals("Konsert")) {
                chboxVelgForestilling.setItems(Konsert);
            } else if (n.toString().equals("Foredrag")) {
                chboxVelgForestilling.setItems(Foredrag);
            } else {
                //egen label for feilmelding?
                lblDittKjøp.setText("Du må velge type forestilling");
            }
        });
    }


    @FXML
    void fullførBestilling(ActionEvent event) throws ParseException {

        // Hvis alle feltene på Billettkjøp er fylt ut/ valgt..
       /* if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() && !txtEmail.getText().isEmpty()
                && chboxVelgBillettType.getOnAction().equals(true)
                && chboxVelgForestilling.getOnKeyPressed().equals(true) && chboxVelgDatoTid.getOnKeyPressed().equals(true)
                && chboxVelgAntall.getOnKeyPressed().equals(true)) {          */

       //TODO: må kjøre metoden antallBilletterIgjen for å se om det er ledige billetter før noe gjøres
       // if(lokalRegister.antallBilletterIgjen(finnArrangement()>0);

            //Oppretter kjøper:
            Kjøper kjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());

            //Oppretter x billetter:
            //TODO: legg inn arrangement objektet
            int antallBilletter = Integer.valueOf((String)chboxVelgAntall.getValue());

            for(int i= 0; i<antallBilletter; i++){
                Billett enBillett = new Billett(kjøper,finnArrangement());
                billettRegister.registrerBillett(enBillett);
            }
        }


    public Arrangement finnArrangement() {
        //TODO: Legger billett(er) til i valgt arrangement:
        String valgtForestilling = String.valueOf(chboxVelgForestilling.getValue());


        //Må splitte objektet fra valgtForestilling for å finne arrangementNavn og tidspunkt til arrangement
        String[] arrOfStr = valgtForestilling.split(": ");
        String navnArrangementFraSplit = arrOfStr[0];
        String tidspunktFraSplit = arrOfStr[1];
        Date dato = new Date(tidspunktFraSplit);


        for (Arrangement etArrangement : arrangementRegister.alleArrangementer) {
            if (etArrangement.getArrangementNavn().equals(navnArrangementFraSplit) && etArrangement.getTidspunkt().equals(dato)) {
                return etArrangement;
            }
        }
        return null;

    }
}