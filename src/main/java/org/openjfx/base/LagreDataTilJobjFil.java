package org.openjfx.base;

import java.io.*;

public class LagreDataTilJobjFil extends LagreDataTilFil {

    private void lagreTilFil(Object o) throws IOException {

        //Opprette et objekt?

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

