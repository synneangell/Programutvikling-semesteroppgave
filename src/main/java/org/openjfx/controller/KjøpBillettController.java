package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.openjfx.base.*;
import org.openjfx.base.ForestillingsArrangement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KjøpBillettController {

    LokalRegister lokalRegister = new LokalRegister();

    ObservableList<String> BillettType = FXCollections.observableArrayList("Kino", "Teater", "Konsert", "Foredrag");

    ObservableList<String> AntallBilletter = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

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
    private ComboBox comboxVelgForestilling;

    @FXML
    private ComboBox comboxVelgDatoTid;

    @FXML
    private ComboBox comboxVelgAntall;

    @FXML
    private ChoiceBox chboxVelgBillettType;

    // Kjøp:

    @FXML
    private Label lblDittKjøp;

    @FXML
    private Button btnFullfør;

    @FXML
    private MenuButton mbtnKvitteringForKjøp;



    // Setter billettype
    @FXML
    public void initialize() {
        chboxVelgBillettType.setItems(BillettType);
    }

    @FXML
    public void velgForestilling(ActionEvent event) {
    }

    @FXML
    public void velgDatoTid(ActionEvent actionEvent) {
    }

    @FXML
    public void velgAntall(ActionEvent actionEvent) {
        comboxVelgAntall.setItems(AntallBilletter);

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
                && comboxVelgForestilling.getOnKeyPressed().equals(true) && comboxVelgDatoTid.getOnKeyPressed().equals(true)
                && comboxVelgAntall.getOnKeyPressed().equals(true)) {

            // ..oppretter vi en ny Kjøper:
            Kjøper kjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());
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