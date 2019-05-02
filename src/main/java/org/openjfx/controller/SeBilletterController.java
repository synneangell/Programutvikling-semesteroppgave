package org.openjfx.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
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
    private TextField txtSøk;

    @FXML
    private Label lblAntallSolgt;

    @FXML
    private Label lblAntallLedige;


    @FXML
    public void initialize() {
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
                lblAntallLedige.setText(String.valueOf(valgtArrangement.ledigBilletter()));
                lblAntallSolgt.setText(String.valueOf(valgtArrangement.solgteBilletter()));
            }
        });

    }

    @FXML
    private void SøkeHistorie (KeyEvent SH) {

        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

            FilteredList<Arrangement> filter = new FilteredList<>(alleArrangementer.getArrangementer(), e->true);
            txtSøk.textProperty().addListener((Observable, oldValue, newValue) -> {
                filter.setPredicate(arrang -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String tekstFyll = newValue.toLowerCase();
                    if (arrang.getArrangementNavn().toLowerCase().indexOf(tekstFyll) != -1) {
                        return true;
                    }
                    if (arrang.getTypeArrangement().toLowerCase().indexOf(tekstFyll) != -1) {
                        return true;
                    }
                    if (arrang.getKlokkeslett().toLowerCase().indexOf(tekstFyll) != -1) {
                        return true;
                    }
                    if (arrang.getDato().toLowerCase().indexOf(tekstFyll) != -1) {
                        return true;
                    }
                    return false;
                });

                SortedList<Arrangement> sortedList = new SortedList<>(filter);
                sortedList.comparatorProperty().bind(tableViewArrangementer.comparatorProperty());
                tableViewArrangementer.setItems(sortedList);
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

