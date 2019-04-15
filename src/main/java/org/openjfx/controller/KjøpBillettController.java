package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.Filbehandling.*;
import org.openjfx.base.*;
import java.io.IOException;
import java.text.ParseException;



public class KjøpBillettController {

    SkriveTilJobjFil skrivTilFil = new SkriveTilJobjFil();
    BillettRegister billettregister = new BillettRegister();        //TODO: se på denne
    ObservableList<String> AntallBilletter = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    @FXML
    private TextField txtNavn, txtTelefonnummer, txtEmail;

    @FXML
    private ComboBox chboxVelgAntall;

    @FXML
    private Button btnAvslutt;

    @FXML
    private AnchorPane rootKjøpBillett;

    @FXML
    private TableView<Arrangement> tableView;

    @FXML
    private TableColumn<Arrangement, String> ArrangementTypeColumn;

    @FXML
    private TableColumn<Arrangement, String> ArrangementNavnColumn;

    @FXML
    private TableColumn<Arrangement, String> KlokkeslettColumn;

    @FXML
    private TableColumn<Arrangement, String> DatoColumn;

    @FXML
    public void initialize() {
        // Setter opp kolonnene i Table View - tabellen
        ArrangementTypeColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("typeArrangement"));
        ArrangementNavnColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementNavn"));
        KlokkeslettColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("klokkeslett"));
        DatoColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));

        tableView.setItems(ModelViewArrangement.getArrangementer());
        chboxVelgAntall.setItems(AntallBilletter);
        chboxVelgAntall.setValue("1");
    }

    // Skriver ut info om kjøp på Kjøp Billetter
    @FXML
    public void DittKjøp(ActionEvent event) {

    }

    @FXML
    void fullførBestilling(ActionEvent event) throws ParseException, IOException {

        if (!txtNavn.getText().isEmpty() && !txtTelefonnummer.getText().isEmpty() && !txtEmail.getText().isEmpty()) {



            Arrangement etArrangement = tableView.getSelectionModel().getSelectedItem();

            //Oppretter x billetter som inneholder en kjøper og valgt arrangement:
            int antallBilletter = Integer.valueOf((String)chboxVelgAntall.getValue());
                if(billettregister.antallBilletterIgjen(etArrangement)>antallBilletter) {
                    Kjøper kjøper = new Kjøper(txtNavn.getText(), txtTelefonnummer.getText(), txtEmail.getText());
                    for (int i = 0; i < antallBilletter; i++) {
                        Billett enBillett = new Billett(kjøper, etArrangement);
                        billettregister.registrerBillett(enBillett);
                        skrivTilFil.skriveTilFil("billett.jobj", enBillett);
                    }
                }
                else {
                    String feilmelding = "Det er ikke nok billetter igjen.";
                }
        }
    }

        private void avsluttProgram() {
            Stage stage = (Stage) btnAvslutt.getScene().getWindow();
            stage.close();
        }

        @FXML
        private void Avslutt (ActionEvent event){
            avsluttProgram();
        }

        @FXML
        private void Tilbake (ActionEvent event) throws IOException {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/kulturhuset.fxml"));
            rootKjøpBillett.getChildren().setAll(pane);
        }
    }