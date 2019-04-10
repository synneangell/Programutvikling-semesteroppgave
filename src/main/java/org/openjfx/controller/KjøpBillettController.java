package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.openjfx.base.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KjøpBillettController {

    LokalRegister lokalRegister = new LokalRegister();
    BillettRegister billettRegister = new BillettRegister();

    ObservableList<String> BillettType = FXCollections.observableArrayList("Kino", "Teater", "Konsert", "Foredrag");

    ObservableList<Integer> AntallBilletter = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);


    ObservableList<Arrangement> Kino = FXCollections.observableArrayList(lokalRegister.kinoArrangementer);

    ObservableList<Arrangement> Teater = FXCollections.observableArrayList(lokalRegister.teaterArrangementer);

    ObservableList<Arrangement> Konsert = FXCollections.observableArrayList(lokalRegister.konsertArrangementer);

    final ComboBox<String> Forestilling = new ComboBox<>();

    ObservableList<Arrangement> Foredrag = FXCollections.observableArrayList(lokalRegister.foredragsArrangementer);

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
    private Button btnFullfør;

    @FXML
    private MenuButton mbtnKvitteringForKjøp;

    @FXML
    public void initialize() {
        chboxVelgBillettType.setItems(BillettType);

        Test test = new Test();
        test.leggTilFilmer();
        chboxVelgBillettType.valueProperty().addListener((ob, o, n)-> {
            if(n.toString().equals("Kino")) {
                System.out.print("Jeg er her");
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
    public void velgForestilling(){
        /*
        if(chboxVelgBillettType.getValue().equals("Kino")) {
                chboxVelgForestilling.setItems(Kino);
            } else if (chboxVelgBillettType.getValue().equals("Teater")) {
                chboxVelgForestilling.setItems(Teater);
            } else if (chboxVelgBillettType.getValue().equals("Konsert")) {
                chboxVelgForestilling.setItems(Konsert);
            } else if (chboxVelgBillettType.getValue().equals("Foredrag")) {
                chboxVelgForestilling.setItems(Foredrag);
            } else {
                //egen label for feilmelding?
                lblDittKjøp.setText("Du må velge type forestilling");
            }                      */
    }


    @FXML
    public void velgAntall() {
            chboxVelgAntall.setItems(AntallBilletter);
    }

    @FXML
    public void DittKjøp() {
        lblDittKjøp.setText("Hello");
    }


    @FXML
    void fullførBestilling(ActionEvent event) throws ParseException {

        // Hvis alle feltene på Billettkjøp er fylt ut/ valgt..
        if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() && !txtEmail.getText().isEmpty()
                && chboxVelgBillettType.getOnAction().equals(true)
                && chboxVelgForestilling.getOnKeyPressed().equals(true) && chboxVelgDatoTid.getOnKeyPressed().equals(true)
                && chboxVelgAntall.getOnKeyPressed().equals(true)) {

            // ..oppretter vi en ny Kjøper:
            Kjøper kjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());

            //oppretter x antall billetter
            //Hvordan få tak i arrangementobjektene og antall billetter?
          /*int i = chboxVelgAntall.getValue();
            for(int i = 0; i<chboxVelgAntall.getValue(); i++){
                Billett enBillett = new Billett(kjøper,chboxVelgForestilling.getValue());
                billettRegister.registrerBillett(enBillett);
                //må kjøre metode til arrangementet som legger billett til arrangement

            }*/


        }
    }

    public void lagreKvittering(ActionEvent event) {
    }



    /*
    @FXML
    public void Kino(ActionEvent actionEvent) {
        comboxVelgForestilling.getItems().addAll(
                "Titanic",
                "Mission Impossible",
                "Pulp Fiction"
        );
    }

    @FXML
    public void Teater(ActionEvent actionEvent) {
        comboxVelgForestilling.getItems().addAll(
                "Sweeney Todd",
                "Cats",
                "Rent"
        );
    }

    @FXML
    public void Konsert(ActionEvent actionEvent) {
    }

    @FXML
    public void Foredrag(ActionEvent actionEvent) {
    }*/
}