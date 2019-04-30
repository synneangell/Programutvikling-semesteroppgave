package org.openjfx.Filbehandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeseJobjFil extends LeseFil {

    @Override
    public ArrayList<?> leseFraFil(String filsti) {
        ArrayList<Object> objekter = new ArrayList<>();

        try (FileInputStream fin = new FileInputStream(filsti);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            Object loadedObject = oin.readObject();
            objekter.add(loadedObject);
        } catch(IOException e) {
            System.err.println("Could not read file. Cause: " + e.getCause());
        } catch(ClassNotFoundException e) {
            System.err.println("Could not convert Object");
        }
        return objekter;
    }
}
