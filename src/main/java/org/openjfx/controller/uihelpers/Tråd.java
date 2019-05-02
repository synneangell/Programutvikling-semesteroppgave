package org.openjfx.controller.uihelpers;

import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import org.openjfx.Filbehandling.ArrangementCsvLeser;
import org.openjfx.Filbehandling.BillettCsvLeser;
import org.openjfx.Filbehandling.LeseJobjFil;

import java.io.File;
import java.io.IOException;
import org.openjfx.base.AlleArrangementer;

public class Tråd extends Task<Void> {
    private Runnable runMeWhenDone;

    public Tråd(Runnable doneFunc) {
        this.runMeWhenDone = doneFunc;
    }

    @Override
    protected Void call() throws InvalidFilData, InvalidBillettFormatException, IOException {
        // emulerer en "stor" jobb på 3 sekunder...
        try {

            FileChooser fc = new FileChooser();

            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JOBJ og CSV filer", "*.csv", "*.jobj"));

            File markertFil = fc.showOpenDialog(null);
            if (markertFil != null) {
                AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

                String[] array = markertFil.getName().split("\\.");
                if(array.length > 1) {
                    if (array[1].equals("csv")){
                        if(array[0].equals("billett")){
                            BillettCsvLeser lesBillettFraCsvFil = new BillettCsvLeser();
                            lesBillettFraCsvFil.leseFraFil(markertFil.getPath());

                        }
                        if(array[0].equals("arrangement")){
                            ArrangementCsvLeser lesArrangementFraCsvFil = new ArrangementCsvLeser();
                            alleArrangementer.gjørOmTilObservableList(lesArrangementFraCsvFil.leseFraFil(markertFil.getPath()));
                        }
                    }
                    if (array[1].equals("jobj")){
                        if(array[0].equals("billett")){
                            LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                            leseDataFraJobjFil.leseFraFil(markertFil.getPath());

                        }
                        if(array[0].equals("arrangement")){
                            LeseJobjFil leseDataFraJobjFil = new LeseJobjFil();
                            alleArrangementer.gjørOmTilObservableList(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                        }
                    }
                }

            } else {
                throw new InvalidFilData("Filen er ikke gyldig");
            }
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // gjør ikke noe her, men hvis hvis du er i en løkke
            // burde løkkes stoppes med break hvis isCancelled() er true...
        }
        return null;
    }

    // succeeded kjører i main-UI tråden, og UI elementer kan manipuleres her
    @Override
    protected void succeeded() {
        runMeWhenDone.run();
    }
}
