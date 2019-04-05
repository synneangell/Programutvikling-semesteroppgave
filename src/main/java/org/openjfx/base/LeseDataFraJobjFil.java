package org.openjfx.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeseDataFraJobjFil extends LeseDataFraFil {


    private void leseFraFil() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("BillettKvittering.jobj"));

        Object o = (Object)objectInputStream.readObject();
        System.out.println(o); //Her skal det ikke stå system out, har ikke funnet ut av det enda.
}
}
