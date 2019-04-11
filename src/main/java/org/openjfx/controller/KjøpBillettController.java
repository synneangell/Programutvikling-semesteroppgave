package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.base.*;

import java.io.IOException;
import java.text.ParseException;


public class KjøpBillettController {

    LokalRegister lokalRegister = new LokalRegister();
    BillettRegister billettRegister = new BillettRegister();

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
    private Button btnFullfør;

    @FXML
    private MenuButton mbtnKvitteringForKjøp;

    @FXML
    private Button btnAvslutt;

    @FXML
    private Button btnTilbake;

    @FXML
    private AnchorPane rootKjøpBillett;

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

    // Skriver ut info om kjøp på Kjøp Billetter
    @FXML
    public void DittKjøp(ActionEvent event) {
        lblDittKjøp.setText(lokalRegister.toString());
    }

    @FXML
    void fullførBestilling(ActionEvent event) throws ParseException {

        // Hvis alle feltene på Billettkjøp er fylt ut/ valgt..
       /* if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() && !txtEmail.getText().isEmpty()
                && chboxVelgBillettType.getOnAction().equals(true)
                && chboxVelgForestilling.getOnKeyPressed().equals(true) && chboxVelgDatoTid.getOnKeyPressed().equals(true)
                && chboxVelgAntall.getOnKeyPressed().equals(true)) {          */


            //Oppretter kjøper:
            Kjøper kjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());

            //Oppretter x billetter:
            int antallBilletter = Integer.valueOf((String)chboxVelgAntall.getValue());
            for(int i= 0; i<antallBilletter; i++){
                Billett enBillett = new Billett(kjøper, null);
                billettRegister.registrerBillett(enBillett);
            }

            //TODO: Legger billett(er) til i valgt arrangement:
            String valgtForestilling = String.valueOf(chboxVelgForestilling.getValue());
            System.out.println(valgtForestilling);

            //Hvordan t oppfatte hvilket objekt det er ut i fra denne stringen?

        }


    public void lagreKvittering(ActionEvent event) {
    }

    //Kode for å enten lukke vindu med bookLokale, og kode for å avslutte hele programmet:
    private void avsluttProgram() {
        Stage stage = (Stage) btnAvslutt.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Avslutt(ActionEvent event){
        avsluttProgram();
    }

    @FXML
    private void Tilbake(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/kulturhuset.fxml"));
        rootKjøpBillett.getChildren().setAll(pane);
    }
}