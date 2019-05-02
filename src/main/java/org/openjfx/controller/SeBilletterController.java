package org.openjfx.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.base.*;

import java.io.IOException;

public class SeBilletterController {

    @FXML
    private AnchorPane rootSeBilletter;

    @FXML
    private Button btnAvslutt;


    @FXML
    private TableView<Arrangement> tableViewArrangementer;

    @FXML
    private TableColumn<Arrangement, String> ArrangementTypeColumn;

    @FXML
    private TableColumn<Arrangement, String> ArrangementNavnColumn;

    @FXML
    private TableColumn<Arrangement, String> KlokkeslettColumn;

    @FXML
    private TableColumn<Arrangement, String> DatoColumn;

    @FXML
    private TableView<Billett> tableViewBilletter;

    @FXML
    private TableColumn<Billett, Kjøper> KjøperNavnColumn;


    @FXML
    public void initialize() {
        //Tabellen lages her:
        ArrangementTypeColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("typeArrangement"));
        ArrangementNavnColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementNavn"));
        KlokkeslettColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("klokkeslett"));
        DatoColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));

        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

        tableViewArrangementer.setItems(alleArrangementer.getArrangementer());


        KjøperNavnColumn.setCellValueFactory(new PropertyValueFactory<Billett, Kjøper>("kjøper"));


        tableViewArrangementer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Arrangement>() {
            @Override
            public void changed(ObservableValue<? extends Arrangement> observableValue, Arrangement arrangement, Arrangement t1) {
                Arrangement valgtArrangement = tableViewArrangementer.getSelectionModel().getSelectedItem();
                tableViewBilletter.setItems(valgtArrangement.visBilletterTilArrangement());
            }
        });

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
        rootSeBilletter.getChildren().setAll(pane);
    }


    @FXML
    private void SøkEtterFil(ActionEvent event){


    }
  }

