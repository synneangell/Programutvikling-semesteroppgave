package org.openjfx.Filbehandling;

import org.openjfx.Filbehandling.SkriveTilFil;

import java.io.*;

public class SkriveTilJobjFil extends SkriveTilFil {

    private void lagreTilFil(Object o) throws IOException {

        String filnavn = "Kvittering.jobj";

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filnavn));

            os.writeObject(o);
            os.close();

        } catch(FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Ferdig med å skrive til jobj fil!");

    }
}


//Må ha en klasse som jeg "serialiserer" fra, må implementere serializable et sted, but where??

