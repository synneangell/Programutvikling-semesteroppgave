package org.openjfx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import java.io.IOException;

public class KulturhusetController {

    @FXML
    private Label lblKHLabel;


    @FXML
    void btnKHKjøpBillett (ActionEvent event) throws IOException {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            root = fxmlLoader.load(getClass().getResource("KjøpBillett.fxml").openStream());
            //openStream trengs for å laste inn controlleren

            // Får tak i controlleren og overfører referanse til person-objektet
            KjøpBillettController controller = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace(); // FXML document should be available
            return;
        }
    }

    @FXML
    void btnKHBookLokale (ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("bookLokale.fxml"));

            Scene scene = new Scene(root);

            //stage.setScene(scene);
            //stage.show();
    }

    @FXML
    String btnKHVisArrangementer (ActionEvent event){
        return lblKHLabel.getText();

        }
    }
