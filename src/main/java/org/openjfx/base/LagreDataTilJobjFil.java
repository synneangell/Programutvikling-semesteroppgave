package org.openjfx.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LagreDataTilJobjFil extends LagreDataTilFil {

    private void lagreTilFil(Object o) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Kvittering.jobj"));

        objectOutputStream.writeObject(o);
    }
}
