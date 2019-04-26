package org.openjfx.Filbehandling;

import org.openjfx.Filbehandling.SkriveTilFil;

import java.io.*;
import java.util.ArrayList;

public class SkriveTilJobjFil extends SkriveTilFil {

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


