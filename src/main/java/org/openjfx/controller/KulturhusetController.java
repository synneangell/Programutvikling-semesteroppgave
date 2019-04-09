package org.openjfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.openjfx.base.*;

import java.io.IOException;

public class KulturhusetController {

    //Skal man opprette disse i alle controllerne? Skal dette i en public void initialize?
    LokalRegister lokalregister = new LokalRegister();


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
    void kjøpBillett (ActionEvent event) {
        launchKjøpBillett();
    }

    @FXML
    void bookLokale (ActionEvent event) {
        launchBookLokale();
    }

    private void launchKjøpBillett() {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("/org/openjfx/kjøpBillett.fxml").openStream());

            // Får tak i controlleren og overfører referanse til person-objektet
            KjøpBillettController controller = fxmlLoader.getController();
            // controller.setPerson(myPerson); ???
        } catch (IOException e) {
            e.printStackTrace(); // FXML document should be available
            return;
        }

        Scene scene = new Scene(root);
        // add CSS etc. should be here
        Stage kjøpBillettStage = new Stage();
        kjøpBillettStage.setTitle("Kjøp billett");
        kjøpBillettStage.setScene(scene);

        // set modality - låser "parent" winduet mens dette vinduet er åpent
        kjøpBillettStage.initOwner(lblOversiktArrangementer.getScene().getWindow());  //får tak i vinduet
        kjøpBillettStage.initModality(Modality.WINDOW_MODAL);    //fryser hovedvinduet
        kjøpBillettStage.show();
    }

    private void launchBookLokale() {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("/org/openjfx/bookLokale.fxml").openStream());

            // Får tak i controlleren og overfører referanse til person-objektet
            BookLokaleController controller = fxmlLoader.getController();
            // controller.setPerson(myPerson); ??
        } catch (IOException e) {
            e.printStackTrace(); // FXML document should be available
            return;
        }

        Scene scene = new Scene(root);
        // add CSS etc. should be here
        Stage bookLokaleStage = new Stage();
        bookLokaleStage.setTitle("Book lokale");
        bookLokaleStage.setScene(scene);

        // set modality - låser "parent" winduet mens dette vinduet er åpent
        bookLokaleStage.initOwner(lblOversiktArrangementer.getScene().getWindow());  //får tak i vinduet
        bookLokaleStage.initModality(Modality.WINDOW_MODAL);    //fryser hovedvinduet
        bookLokaleStage.show();
    }
}


/**
 * Kode til knappene (kjøp billett og book lokale
 */

/*

 */


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

/**
 * Hvis jeg vil ha muligheten til å hente flere filer (må kobles til forskjellige knapper i så fall
 */


   /*
  public void Button1(ActionEvent actionEvent) {
     FileChooser fc = new FileChooser();

     //Denne over er alternativ. Her kan jeg sette inn linken til der hvor jeg vil at programmet skal åpne filen
     fc.setInitialDirectory(new File ("//Users//nikolasekiw//Documents")); //alternativ

     //Hvis jeg vil filtrere valgene brukeren får kan jeg bruke koden under, feks at det bare skal komme opp pdf filer
     //ExtentionFilter filtrerer hvilke filer som kan bli valgt med fileChooser
     //"PDF files" er teksten jeg vil skal vises i filechooser, "*.pdf" gjør at den kun viser alle pdf filer.
     fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));

     //Hvis jeg vil ha muligheten til å velte flere filer
     List<File> merkerteFiler = fc.showOpenMultipleDialog(null);

     if (merkerteFiler != null){
        for (int i = 0; i < merkerteFiler.size(); i++){
           listView.getItems().add(merkerteFiler.get(i).getAbsolutePath());
        }

     } else {
        System.out.println("Filen er ikke gyldig");
     }
  }
    */
