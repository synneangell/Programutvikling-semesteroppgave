package org.openjfx.base;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeseDataFraCsvFil extends LeseDataFraFil {

    private void leseFraFil() throws IOException, ClassNotFoundException {

        String CsvFile = "navn.csv";
        String FieldDelimiter = ",";

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(CsvFile));

            String linje;
            while ((linje = br.readLine()) != null){
                String [] fields = linje.split(FieldDelimiter, -1);


            }
        } catch (Exception e){

        }



    }
    }
