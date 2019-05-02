package org.openjfx.controller.uihelpers;

import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TrådLeserStarter {

    public static ObservableList<Object> startLeser(File markertFil) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);
        ObservableList<Object> resultat = null;
        Future<ObservableList<Object>> returnedValues = service.submit(new TrådLeser(markertFil));
        resultat = returnedValues.get();
        service.shutdown();
        return resultat;
    }
}
