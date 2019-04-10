package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.openjfx.base.*;

import java.io.IOException;

public class KulturhusetController {

    //Skal man opprette disse i alle controllerne? Skal dette i en public void initialize?
    LokalRegister lokalregister = new LokalRegister();

    public void initialize() {
        lokalregister.leggInnFilmer();
    }

    /*
    @FXML
    private Button btnKjøpBillett;

    @FXML
    private Button  btnBookLokale;

    @FXML
    private Button  btnVisArrangementer;
    */

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label  lblOversiktArrangementer;

    ObservableList<String> sorteringsValg = FXCollections.observableArrayList("Alfabetisk", "Etter tidspunkt");

    @FXML
    void visAlleArrangementer (ActionEvent event) {
        lblOversiktArrangementer.setText("Foredrag: "+lokalregister.visAlleForedragsArrangementer() +
                                        "Kino: "+lokalregister.visAlleKinoArrangementer() +
                                        "Konserter: "+lokalregister.visAlleKonsertArrangementer() +
                                        "Teater: "+lokalregister.visAlleTeaterArrangementer());

        ChoiceBox<String> sorter = new ChoiceBox<>();
        sorter.setItems(sorteringsValg);
    }

    @FXML
    void kjøpBillett (ActionEvent event) throws IOException {
        launchKjøpBillett();
    }

    @FXML
    void bookLokale (ActionEvent event) throws IOException {
        launchBookLokale();
    }

    private void launchKjøpBillett() throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/kjøpBillett.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    private void launchBookLokale() throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/bookLokale.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
