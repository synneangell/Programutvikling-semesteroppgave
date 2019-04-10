package org.openjfx.Filbehandling;

import java.io.*;
import java.io.IOException;

public class LeseDataFraCsvFil extends LeseFraFil {

    public void leseFraFil(String filsti){

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
