package org.openjfx.Filbehandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeseDataFraJobjFil extends LeseFraFil {

    @Override
    public ArrayList<Object> leseFraFil(String filsti) {
        ArrayList<Object> objekter = new ArrayList<>();

        try (FileInputStream fin = new FileInputStream(filsti);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            objekter = (ArrayList<Object>) oin.readObject();
        } catch(IOException e) {
            System.err.println("Could not read file. Cause: " + e.getCause());
        } catch(ClassNotFoundException e) {
            System.err.println("Could not convert Object");
        }
        return objekter;
    }
}
