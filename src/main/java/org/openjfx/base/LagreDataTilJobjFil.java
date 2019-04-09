package org.openjfx.base;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LagreDataTilJobjFil extends LagreDataTilFil {

    private void lagreTilFil(Object o) throws IOException {

        //Opprette et objekt?

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Kvittering.jobj"));

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