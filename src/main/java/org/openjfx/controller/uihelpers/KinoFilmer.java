package org.openjfx.controller.uihelpers;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.openjfx.base.*;

import java.util.ArrayList;
import java.util.Date;

public class KinoFilmer {

    /*public String filmNavn;
    public int klokkeslett;
    public String dag;
    public int dato;



    public KinoFilmer() {
        this.filmNavn = "";
        this.klokkeslett = 0;
        this.dag = "";
        this.dato = 0;
    }

    public KinoFilmer(String filmNavn, int klokkeslett, String dag, int dato) {
        this.filmNavn = filmNavn;
        this.klokkeslett = klokkeslett;
        this.dag = dag;
        this.dato = dato;
    }

    public String getFilmNavn() {
        return filmNavn;
    }

    public void setFilmNavn(String filmNavn) {
        this.filmNavn = filmNavn;
    }

    public int getKlokkeslett() {
        return klokkeslett;
    }

    public void setKlokkeslett(int klokkeslett) {
        this.klokkeslett = klokkeslett;
    }

    public String getDag() {
        return dag;
    }

    public void setDag(String dag) {
        this.dag = dag;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
}*/
    public ArrayList<Arrangement> kinoArrangementer = new ArrayList<>();

    public KinoFilmer() {
        kinofilmer();;
    }

    Kinosal kinosal = new Kinosal(100, kinoArrangementer, 4);

    // Oppretter en kontaktperson som er ansvarlig for kino- og teatervisninger
    Kontaktperson forestillingsAnsvarlig = new Kontaktperson("Aksel Ansvarlig", "22442314",
            "kontakt@kulturhuset.no", "kulturhuset.no", "Kulturhuset", "");

    public String toString() {
        return forestillingsAnsvarlig.getNavn();
    }

   // Oppretter kinofilmer:
    Date dato = new Date(2019, 07, 23, 18, 30);
    ForestillingsArrangement kinofilm = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Pulp Fiction", 110, dato, 100);

    Date dato2 = new Date(2019, 07, 25, 18, 00);
    ForestillingsArrangement kinofilm2 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "The Hateful Eight", 120, dato2, 100);

    Date dato3 = new Date(2019, 07, 28, 21, 00);
    ForestillingsArrangement kinofilm3 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Once Upon a Time in Hollywood", 150, dato3, 100);


    // Oppretter teaterforestilling:
    Date dato4 = new Date(2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Sweeney Todd", 200, dato4, 100);

    Date dato5 = new Date(2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling2 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Cats", 220, dato5, 100);

    Date dato6 = new Date(2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling3 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Les Miserables", 250, dato6, 100);


    public void kinofilmer() {
        kinoArrangementer.add(kinofilm);
        kinoArrangementer.add(kinofilm2);
        kinoArrangementer.add(kinofilm3);
    }

}
    /*
    @Override
    public void start(Stage stage) throws Exception {

        TableView<ObservableList> Kino = createTableView(kinoArrangementer);
        stage.setScene(new Scene(Kino));
        stage.show();
    }


    private ObservableList<ObservableList> buildData(String[] kinoArrangementer) {
        ObservableList<ObservableList> data = FXCollections.observableArrayList();


    private TableView<ObservableList<String>> createTableView(String[] kinoArrangementer) {
        TableView<ObservableList<String>> tableView = new TableView<>();
        tableView.setItems(buildData(kinoArrangementer));

        for (int i = 0; i < kinoArrangementer[0].length; i++) {
            final int curCol = i;
            final TableColumn<ObservableList<String>, String> column = new TableColumn<>(
                    "Col " + (curCol + 1)
            );
            column.setCellValueFactory(
                    param -> new ReadOnlyObjectWrapper<>(param.getValue().get(curCol))
            );
            tableView.getColumns().add(column);
        }

        return tableView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/