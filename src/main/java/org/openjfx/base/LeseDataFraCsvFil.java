package org.openjfx.base;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeseDataFraCsvFil extends LeseDataFraFil {

    private void leseFraFil() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("BillettKvittering.csv"));

        Object o = (Object)objectInputStream.readObject();
        System.out.println(o);
    }
    }
