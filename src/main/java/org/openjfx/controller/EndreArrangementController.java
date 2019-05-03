package org.openjfx.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.Filbehandling.SkriveCsvFil;
import org.openjfx.Filbehandling.SkriveJobjFil;
import org.openjfx.base.*;
import javafx.scene.input.KeyEvent;


public class EndreArrangementController {

    ObservableList<String> filtyper = FXCollections.observableArrayList(".jobj", ".csv");

    @FXML
    private ComboBox lagreTilFilBox;

    @FXML
    private AnchorPane rootEndreArrangement;

    @FXML
    private TableView<Arrangement> Tableview;

    @FXML
    private TableColumn<Arrangement, String> TypeColumn;

    @FXML
    private TableColumn<Arrangement, String> ArrangementNavnColumn;

    @FXML
    private TableColumn<Arrangement, String> KlokkeslettColumn;

    @FXML
    private TableColumn<Arrangement, String> DatoColumn;

    @FXML
    private TextField txtSøk;

    @FXML
    public void initialize() {
        //Oppretter tabellen med arrangementer her:
        TypeColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("typeArrangement"));
        ArrangementNavnColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementNavn"));
        KlokkeslettColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("klokkeslett"));
        DatoColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));
        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();
        Tableview.setItems(alleArrangementer.getArrangementer());

        //Gjør tabellen "Editable":
        Tableview.setEditable(true);
        ArrangementNavnColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        KlokkeslettColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DatoColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        lagreTilFilBox.setItems(filtyper);
        lagreTilFilBox.setValue(".csv");
    }


    @FXML
    private void SøkeHistorie (KeyEvent SH) {


    }


    @FXML
    void Lagre (ActionEvent event) throws IOException {
        String filtype = lagreTilFilBox.getValue().toString();
        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

        ArrayList<Billett> lagreBilletterTilFil = new ArrayList<>();

        for(Arrangement etArrangement : alleArrangementer.getArrangementer()){
            for(Billett enBillett : etArrangement.getBilletter()){
                if(enBillett.getKjøper() != null) {
                    lagreBilletterTilFil.add(enBillett);
                }
            }
        }

        if(filtype.equals(".csv")){
            SkriveCsvFil skriveTilCsvFil = new SkriveCsvFil();
            skriveTilCsvFil.skriveTilFil("billett.csv", lagreBilletterTilFil);
        }
        else if(filtype.equals(".jobj")){
            SkriveJobjFil skriveTilJobjFil = new SkriveJobjFil();
            skriveTilJobjFil.skriveTilFil("billett.jobj",lagreBilletterTilFil);
        }
    }

    public void endreNavnArrangement(TableColumn.CellEditEvent endretCelle) {
        Arrangement valgtArrangement = Tableview.getSelectionModel().getSelectedItem();
        valgtArrangement.setArrangementNavn(endretCelle.getNewValue().toString());
    }


    public void endreKlokkeslettArrangement(TableColumn.CellEditEvent endretCelle) {
        Arrangement valgtArrangement = Tableview.getSelectionModel().getSelectedItem();
        valgtArrangement.setKlokkeslett(endretCelle.getNewValue().toString());
    }

    public void endreDatoArrangement(TableColumn.CellEditEvent endretCelle) {
        Arrangement valgtArrangement = Tableview.getSelectionModel().getSelectedItem();
        valgtArrangement.setDato(endretCelle.getNewValue().toString());
    }

    public void slettArrangement(){
        ObservableList<Arrangement> valgtRad, arrangementer;
        arrangementer = Tableview.getItems();
        valgtRad = Tableview.getSelectionModel().getSelectedItems();
        for(Arrangement etArrangement : valgtRad){
            arrangementer.remove(etArrangement);

        }

    }

    private void avsluttProgram() {
        Stage stage = (Stage) Tableview.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void slettArrangement(ActionEvent event){
        slettArrangement();
    }

    @FXML
    private void Avslutt(ActionEvent event){
        avsluttProgram();
    }

    @FXML
    private void Tilbake(ActionEvent event) throws IOException {
        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("/org/openjfx/kulturhuset.fxml"));
        rootEndreArrangement.getChildren().setAll(pane3);
    }
}
