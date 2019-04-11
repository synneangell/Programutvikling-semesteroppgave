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
import org.openjfx.base.Arrangement;
import org.openjfx.base.ForestillingsArrangement;
import org.openjfx.base.Kinosal;
import org.openjfx.base.Kontaktperson;

import java.util.ArrayList;
import java.util.Date;

public class TableViewVisArrangementer {
    private SimpleStringProperty kinofilmer;
    private Date dato;

    public TableViewVisArrangementer (String kinofilmer, Date dato) {
        this.kinofilmer = new SimpleStringProperty(kinofilmer);
        this.dato = dato;
    }

    public String getKinofilmer() {
        return kinofilmer.get();
    }

    public SimpleStringProperty kinofilmerProperty() {
        return kinofilmer;
    }

    public void setKinofilmer(String kinofilmer) {
        this.kinofilmer.set(kinofilmer);
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
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