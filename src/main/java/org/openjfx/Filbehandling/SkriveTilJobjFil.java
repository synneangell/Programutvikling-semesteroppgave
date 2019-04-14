package org.openjfx.Filbehandling;

import org.openjfx.Filbehandling.SkriveTilFil;

import java.io.*;

public class SkriveTilJobjFil extends SkriveTilFil {

    public void skriveTilFil(String filsti, Object obj) {
        try (
                FileOutputStream fos = new FileOutputStream(filsti);
                ObjectOutputStream out = new ObjectOutputStream(fos);
        ) {
            out.writeObject(obj);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}


