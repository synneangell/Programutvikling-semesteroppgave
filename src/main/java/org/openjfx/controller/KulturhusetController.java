package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.openjfx.base.Arrangement;
import org.openjfx.base.LokalRegister;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KulturhusetController implements Initializable {

    //Skal man opprette disse i alle controllerne? Skal dette i en public void initialize?
    LokalRegister lokalRegister = new LokalRegister();
    ObservableList<String> sorteringsValg = FXCollections.observableArrayList("Alfabetisk", "Etter tidspunkt");


    ObservableList<Arrangement> kinoprogram = FXCollections.observableArrayList(lokalRegister.kinoArrangementer);

    @FXML
    private Label  lblOversiktArrangementer;

    // Table View - tabellen:
    @FXML
    private TableView <Arrangement> tvVisArrangementer;

    @FXML
    private TableColumn<Arrangement, String> ArrangementColumn;

    @FXML
    private TableColumn<Arrangement, String> KlokkeslettColumn;

    @FXML
    private TableColumn<Arrangement, String> DatoColumn;



    @FXML
    private ChoiceBox chboxSorter;

    //sette inn hide choicebox på en måte?

    /*@FXML
    void visAlleArrangementer (ActionEvent event) {
        lblOversiktArrangementer.setText (
                        "Kino: " + "\n" + lokalRegister.visAlleKinoArrangementer() + "\n" +
                        "Teater: "+ "\n" + lokalRegister.visAlleTeaterArrangementer() + "\n" +
                        "Konserter: "+ "\n" + lokalRegister.visAlleKonsertArrangementer() + "\n" +
                        "Foredrag: "+ "\n" + lokalRegister.visAlleForedragsArrangementer());
    }*/

    @FXML
    void kjøpBillett (ActionEvent event) {
        launchKjøpBillett();
    }

    @FXML
    void bookLokale (ActionEvent event) {
        launchBookLokale();
    }

    private void launchKjøpBillett() {


    }

    private void launchBookLokale() {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/kjøpBillett.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void visAlleArrangementer (ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(("FXMLDocument.fxml")));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene((tableViewScene));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Setter opp kolonnene i Table View - tabellen
        ArrangementColumn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementNavn"));
        KlokkeslettColumn.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("Klokkeslett"));
        DatoColumn.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("dato"));

        tvVisArrangementer.setItems(getArrangement());
    }

    public ObservableList<Arrangement> getArrangement() {

        ObservableList<Arrangement> arrangement = FXCollections.observableArrayList();
        return arrangement;

    }
}

/**
 *  Kode som skal plasseres i controlleren til kjøpbillett og booklokale som laster opp en fil fra maskinen
 */
   /*

   //Denne koden må både i kjøpbillett og book lokale. I tillegg til dette må det lages kode som håndterer filtypene i base mappen.
   //Jeg har laget klassene, men de er langt i fra ferdige.

      public void Button1(ActionEvent actionEvent) {
     FileChooser fc = new FileChooser();

     //Denne under er alternativ. Her kan jeg sette inn linken til der hvor jeg vil at programmet skal åpne filen
     fc.setInitialDirectory(new File ("//Users//nikolasekiw//Documents")); //alternativ

     //Hvis jeg vil filtrere valgene brukeren får kan jeg bruke koden under, feks at det bare skal komme opp pdf filer
     //ExtentionFilter filtrerer hvilke filer som kan bli valgt med fileChooser
     //"PDF files" er teksten jeg vil skal vises i filechooser, "*.pdf" gjør at den kun viser alle pdf filer.
     fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));

     File merkertFil = fc.showOpenDialog(null);

     if (merkertFil != null){
        listView.getItems().add(merkertFil.getName());
     } else {
        System.out.println("Filen er ikke gyldig");
     }
  }
    */
