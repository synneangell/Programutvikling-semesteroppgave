package org.openjfx.controller.uihelpers;

import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import org.openjfx.Filbehandling.LesArrangementFraCsvFil;
import org.openjfx.Filbehandling.LesBillettFraCsvFil;
import org.openjfx.Filbehandling.LeseDataFraJobjFil;
import org.openjfx.base.AlleArrangementer;
import org.openjfx.base.Arrangement;

import java.io.File;

public class Tråd extends Task<Void> {
    private Runnable runMeWhenDone;

    public Tråd(Runnable doneFunc) {
        this.runMeWhenDone = doneFunc;
    }

    @Override
    protected Void call() throws Exception {
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
                            LesBillettFraCsvFil lesBillettFraCsvFil = new LesBillettFraCsvFil();
                            //må legge inn billettene her til de ulike arrangementene sine arraylists
                            lesBillettFraCsvFil.leseFraFil(markertFil.getPath());


                        }
                        if(array[0].equals("arrangement")){
                            LesArrangementFraCsvFil lesArrangementFraCsvFil = new LesArrangementFraCsvFil();
                            alleArrangementer.gjørOmTilObservableList(lesArrangementFraCsvFil.leseFraFil(markertFil.getPath()));
                        }
                    }
                    if (array[1].equals("jobj")){
                        if(array[0].equals("billett")){
                            LeseDataFraJobjFil leseDataFraJobjFil = new LeseDataFraJobjFil();
                            //må legge inn billettene her til de ulike arrangementene sine arraylists

                            leseDataFraJobjFil.leseFraFil(markertFil.getPath());


                        }
                        if(array[0].equals("arrangement")){
                            LeseDataFraJobjFil leseDataFraJobjFil = new LeseDataFraJobjFil();
                            alleArrangementer.gjørOmTilObservableList(leseDataFraJobjFil.leseFraFil(markertFil.getPath()));
                        }
                    }

                }



            } else {
                String feilmelding = "Filen er ikke gyldig";
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
