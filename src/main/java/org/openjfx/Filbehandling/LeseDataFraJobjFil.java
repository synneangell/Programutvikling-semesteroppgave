package org.openjfx.Filbehandling;

import org.openjfx.base.Arrangement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeseDataFraJobjFil extends LeseFraFil {


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
