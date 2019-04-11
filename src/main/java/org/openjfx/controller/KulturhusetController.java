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
    ObservableList<String> sorteringsValg = FXCollections.observableArrayList("Alfabetisk", "Etter tidspunkt");

    /*
    @FXML
    private Button btnKjøpBillett;

    @FXML
    private Button  btnBookLokale;

    @FXML
    private Button  btnVisArrangementer;
    */

    @FXML
    private Label  lblOversiktArrangementer;

    @FXML
    private ChoiceBox chboxSorter;

    @FXML
    private AnchorPane rootPane;



    //sette inn hide choicebox på en måte?

    @FXML
    void visAlleArrangementer (ActionEvent event) {
        lblOversiktArrangementer.setText (
                        "Kino: " + "\n" + lokalregister.visAlleKinoArrangementer() + "\n" +
                        "Teater: "+ "\n" + lokalregister.visAlleTeaterArrangementer() + "\n" +
                        "Konserter: "+ "\n" + lokalregister.visAlleKonsertArrangementer() + "\n" +
                        "Foredrag: "+ "\n" + lokalregister.visAlleForedragsArrangementer());
    }

    @FXML
    void kjøpBillett (ActionEvent event) throws IOException{
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
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/org/openjfx/bookLokale.fxml"));
        rootPane.getChildren().setAll(pane2);
    }
}
