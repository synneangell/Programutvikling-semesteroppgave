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
    void OnActionKjøpBillett (ActionEvent event) throws IOException {
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
    void OnActionBookLokale (ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("bookLokale.fxml"));

            Scene scene = new Scene(root);

            //stage.setScene(scene);
            //stage.show();
    }

    @FXML
    String OnActionVisArrangementer (ActionEvent event){
        return lblKHLabel.getText();

        }

     @FXML
     void btnKHDato(ActionEvent event){

     }

     @FXML
     void btnKHAlfabetisk(ActionEvent event){

     }
    }
