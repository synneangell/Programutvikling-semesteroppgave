package org.openjfx.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LagreDataTilCsvFil extends LagreDataTilFil {

    private void lagreTilFil(Object o) throws IOException  {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Kvittering.csv"));

        objectOutputStream.writeObject(o);
    }
}

