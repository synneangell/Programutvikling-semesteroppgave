package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.openjfx.base.*;
import org.openjfx.base.ForestillingsArrangement;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class KjøpBillettController {


    LokalRegister lokalRegister = new LokalRegister();
    BillettRegister billettRegister = new BillettRegister();

    ObservableList<String> BillettType = FXCollections.observableArrayList("Kino", "Teater", "Konsert", "Foredrag");

    ObservableList<Integer> AntallBilletter = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);

    ObservableList<Arrangement> Kino = FXCollections.observableList(lokalRegister.kinoArrangementer);

    ObservableList<Arrangement> Teater = FXCollections.observableArrayList(lokalRegister.teaterArrangementer);

    ObservableList<Arrangement> Konsert = FXCollections.observableArrayList(lokalRegister.konsertArrangementer);

    ObservableList<Arrangement> Foredrag = FXCollections.observableArrayList(lokalRegister.foredragsArrangementer);

    //LokalRegister lokalRegister = new LokalRegister();

    final ComboBox<String> Forestilling = new ComboBox<>();


    // Kjøperinfo:

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtTelefonnummer;

    @FXML
    private TextField txtEmail;

    // Valg:

    @FXML
    private ChoiceBox chboxVelgForestilling;

    @FXML
    private ChoiceBox chboxVelgDatoTid;

    @FXML
    private ChoiceBox chboxVelgAntall;

    @FXML
    private ChoiceBox chboxVelgBillettType;

    // Kjøp:

    @FXML
    private Label lblDittKjøp;

    @FXML
    private Button btnFullfør;

    @FXML
    private MenuButton mbtnKvitteringForKjøp;

    @FXML
    private Button btnAvslutt;

    @FXML
    private Button btnAvbryt;



    // Setter billettype
    @FXML
    public void initialize() {
        chboxVelgBillettType.setItems(BillettType);
    }

    @FXML
    public void velgForestilling(ActionEvent event){
        if(chboxVelgBillettType.isPressed()) {
            if (BillettType.equals("Kino")) {
                chboxVelgForestilling.setItems(Kino);
            } else if (BillettType.equals("Teater")) {
                chboxVelgForestilling.setItems(Teater);
            } else if (BillettType.equals("Konsert")) {
                chboxVelgForestilling.setItems(Konsert);
            } else if (BillettType.equals("Foredrag")) {
                chboxVelgForestilling.setItems(Foredrag);
            } else {
                //egen label for feilmelding?
                lblDittKjøp.setText("Du må velge type forestilling");
            }
        }

    //public void velgForestilling(ActionEvent event) {
        // Hvis forestilling ikke er valgt, må det velges en kinofilm
        //if (!comboxVelgForestilling.getOnKeyPressed().equals(true)) {

        }
   // }

    @FXML
    public void velgDatoTid(ActionEvent actionEvent) {
    }

    @FXML
    public void velgAntall(ActionEvent event) {
        if(chboxVelgForestilling.isPressed()) {
            chboxVelgAntall.setItems(AntallBilletter);
        }
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

    @FXML
    private void Avslutt(ActionEvent event){
        Stage stage = (Stage) btnAvslutt.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Tilbake (ActionEvent event) throws IOException {


    }

    @FXML
    public void back(String instance,Stage stage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/openjfx/kulturhuset.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/css/Style.css");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


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
    }}