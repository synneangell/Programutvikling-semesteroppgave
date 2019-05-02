package org.openjfx.controller.uihelpers;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TrådLeserStarter {

    public static ArrayList<Object> startLeser(File markertFil) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);
        ArrayList<Object> resultat = null;
        Future<ArrayList<Object>> returnedValues = service.submit(new TrådLeser(markertFil));
        resultat = returnedValues.get();
        service.shutdown();
        return resultat;
    }
}
