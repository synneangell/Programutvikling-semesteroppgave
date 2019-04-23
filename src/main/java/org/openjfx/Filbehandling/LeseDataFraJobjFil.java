package org.openjfx.Filbehandling;

import org.openjfx.base.Arrangement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeseDataFraJobjFil extends LeseFraFil {

//TODO: mulig det er nødvendig å koble dette her opp mot filechooser i controller klassen?

    @Override
    public void leseFraFil(String filsti) {
        try (FileInputStream fin = new FileInputStream(filsti);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            Object loadedObject = oin.readObject();
            System.out.println("Objekt fra jobj fil:\n" + loadedObject);
        } catch(IOException e) {
            System.err.println("Could not read file. Cause: " + e.getCause());
        } catch(ClassNotFoundException e) {
            System.err.println("Could not convert Object");
        }
    }
}
