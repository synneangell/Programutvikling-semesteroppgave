package org.openjfx.controller.hjelpeklasser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.Filbehandling.ArrangementCsvLeser;
import org.openjfx.Filbehandling.BillettCsvLeser;
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

        return read();
    }

    private ObservableList<Object> read() throws InvalidFilDataException, IOException, InvalidBillettFormatException {

        ObservableList<Object> returVerdi = FXCollections.observableArrayList();

        if (markertFil != null) {
            AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

            String[] array = markertFil.getName().split("\\.");
            if(array.length > 1) {
                if (array[1].equals("csv")){
                    if(array[0].equals("billett")){
                        BillettCsvLeser lesBillettFraCsvFil = new BillettCsvLeser();
                        alleArrangementer.LeggBillettFraFilTilArrangement(lesBillettFraCsvFil.leseFraFil(markertFil.getPath()));
                        // returVerdi =
                    }
                    if(array[0].equals("arrangement")){
                        ArrangementCsvLeser lesArrangementFraCsvFil = new ArrangementCsvLeser();
                        alleArrangementer.gjørOmTilObservableList(lesArrangementFraCsvFil.leseFraFil(markertFil.getPath()));
                        //returVerdi = alleArrangementer.getArrangementer();
                    }
                }
                if (array[1].equals("jobj")){
                    if(array[0].equals("billett")){
                        LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                        alleArrangementer.LeggBillettFraFilTilArrangement(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                        //returVerdi = ??
                    }
                    if(array[0].equals("arrangement")){
                        LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                        alleArrangementer.gjørOmTilObservableList(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                        //returVerdi = ??
                    }
                }
            }
        } else {
            throw new InvalidFilDataException("Filen er ikke gyldig");
        }
        return returVerdi;
    }
}
