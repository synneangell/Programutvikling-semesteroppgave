package org.openjfx.Filbehandling;

import java.io.*;
import java.util.ArrayList;

public class SkriveJobjFil extends SkriveFil {

    public void skriveTilFil(String filsti, ArrayList<?> objekter) {
        try (
                FileOutputStream fos = new FileOutputStream(filsti);
                ObjectOutputStream out = new ObjectOutputStream(fos);
        ) {
            out.writeObject(objekter);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}