package org.openjfx.controller.hjelpeklasser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.Filbehandling.ArrangementCsvLeser;
import org.openjfx.Filbehandling.BillettCsvLeser;
import org.openjfx.Filbehandling.LeseFil;
import org.openjfx.Filbehandling.LeseJobjFil;
import org.openjfx.base.AlleArrangementer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class TrådLeser implements Callable<ObservableList<Object>> {

    File markertFil;

    public TrådLeser(File markertFil){
        this.markertFil = markertFil;
    }

    @Override
    public ObservableList<Object> call() throws InvalidBillettFormatException, IOException, InvalidFilDataException, InterruptedException {
        Thread.sleep(3000);
        return read();
    }

    private ObservableList<Object> read() throws InvalidFilDataException, IOException, InvalidBillettFormatException {

        ObservableList<Object> returVerdi = FXCollections.observableArrayList();

        if (markertFil != null) {
            AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

            String[] array = markertFil.getName().split("\\.");
            if(array.length > 1) {
                LeseFil filleser = null;
                if (array[1].equals("csv")){

                    if(array[0].equals("billett")){
                        BillettCsvLeser lesBillettFraCsvFil = new BillettCsvLeser();
                        filleser = new BillettCsvLeser();
                        alleArrangementer.LeggBillettFraFilTilArrangement(lesBillettFraCsvFil.leseFraFil(markertFil.getPath()));
                        returVerdi = FXCollections.observableArrayList(lesBillettFraCsvFil.leseFraFil(markertFil.getPath()));

                    }
                    if(array[0].equals("arrangement")){
                        ArrangementCsvLeser lesArrangementFraCsvFil = new ArrangementCsvLeser();
                        alleArrangementer.gjørOmTilObservableList(lesArrangementFraCsvFil.leseFraFil(markertFil.getPath()));
                        returVerdi = FXCollections.observableArrayList(lesArrangementFraCsvFil.leseFraFil(markertFil.getPath()));
                    }
                }
                if (array[1].equals("jobj")){
                    if(array[0].equals("billett")){
                        LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                        alleArrangementer.LeggBillettFraFilTilArrangement(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                        returVerdi = FXCollections.observableArrayList(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                    }
                    if(array[0].equals("arrangement")){
                        LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                        alleArrangementer.gjørOmTilObservableList(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                        returVerdi = FXCollections.observableArrayList(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                    }
                }
                if (filleser!=null)
                returVerdi = FXCollections.observableArrayList(filleser.leseFraFil(markertFil.getPath()));
            }
        } else {
            throw new InvalidFilDataException("Filen er ikke gyldig");
        }
        return returVerdi;
    }
}