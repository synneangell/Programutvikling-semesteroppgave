package org.openjfx.controller.uihelpers;

import javafx.collections.ObservableList;
import org.openjfx.Filbehandling.ArrangementCsvLeser;
import org.openjfx.Filbehandling.BillettCsvLeser;
import org.openjfx.Filbehandling.LeseJobjFil;
import org.openjfx.base.AlleArrangementer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TrådLeser implements Callable<ObservableList<Object>> {

    File markertFil;

    public TrådLeser(File markertFil){
        this.markertFil = markertFil;
    }

    @Override
    public ObservableList<Object> call() throws InvalidBillettFormatException, IOException, InvalidFilData {

        //Metoder som skal kalles legges her. Run kalles på implisivt når man oppretter en tråd med denne klassen.
        //Pass på at returverditypen i call tilsvarer den typen som Callable er satt til!
        return read();
    }

     private ObservableList<Object> read() throws InvalidFilData, IOException, InvalidBillettFormatException {

        ArrayList<Object> returVerdi = new ArrayList<>();

        if (markertFil != null) {
            AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

            String[] array = markertFil.getName().split("\\.");
            if(array.length > 1) {
                if (array[1].equals("csv")){
                    if(array[0].equals("billett")){
                        BillettCsvLeser lesBillettFraCsvFil = new BillettCsvLeser();
                        returVerdi = lesBillettFraCsvFil.leseFraFil(markertFil.getPath());

                    }
                    if(array[0].equals("arrangement")){
                        ArrangementCsvLeser lesArrangementFraCsvFil = new ArrangementCsvLeser();
                        alleArrangementer.gjørOmTilObservableList(lesArrangementFraCsvFil.leseFraFil(markertFil.getPath()));
                        returVerdi = alleArrangementer.getArrangementer();
                    }
                }
                if (array[1].equals("jobj")){
                    if(array[0].equals("billett")){
                        LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                        returVerdi = leseDataFraJobjFil.leseFraFil(markertFil.getPath());

                    }
                    if(array[0].equals("arrangement")){
                        LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                        returVerdi = alleArrangementer.gjørOmTilArrayList(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                    }
                }
            }

        } else {
            throw new InvalidFilData("Filen er ikke gyldig");
        }

        return returVerdi;
    }
}
