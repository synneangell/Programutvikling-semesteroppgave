package org.openjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

public class KulturhusetController {

    @FXML
    private Label lblKHLabel;

    @FXML
    private Button btnKHKjøpBillett;

    @FXML
    private Button btnKHBookLokale;

    @FXML
    private Button btnKHVisArrangementer;

    @FXML
    private Button btnKHDato;

    @FXML
    private Button btnKHAlfabetisk;


    @FXML
    void KjøpBillett (ActionEvent event) throws IOException {
        System.out.println("metode kalt!");
        /*Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("kjøpBillett.fxml").openStream());
            //openStream trengs for å laste inn controlleren

            // Får tak i controlleren og overfører referanse
            KjøpBillettController controller = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace(); // FXML document should be available
            return;
        }*/
    }

    @FXML
    void BookLokale (ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("bookLokale.fxml"));

            Scene scene = new Scene(root);

            //stage.setScene(scene);
            //stage.show();
    }

    @FXML
    String VisArrangementer (ActionEvent event){
        return lblKHLabel.getText();
        //Her må det komme opp en kode med registrerte arrangementer,
        //må også fikse lagring for arrangementer som har blitt opprettet?

        }

     @FXML
     void Dato(ActionEvent event){

     }

     @FXML
     void Alfabetisk(ActionEvent event){

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

