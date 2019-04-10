package org.openjfx.Filbehandling;

import java.io.*;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeseDataFraCsvFil extends LeseFraFil {

    public void leseFraFil(String filsti){

        String CsvFile = "Kinofilmer.csv";
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

/*
    List<Person> persons = null;

        try {
                persons = PersonReader.readPersons("Kinofilmer.csv");
                } catch (IOException e) {
                System.err.println("Could not read the requested file. Cause: " + e.getCause());
                } catch (InvalidPersonFormatException e) {
                System.err.println("The data is not formatted correctly. Message: " + e.getMessage());
                }

                if(persons == null) { // some error has occurred
                System.exit(1);
                }

                System.out.println(persons);
                }

                }
*/