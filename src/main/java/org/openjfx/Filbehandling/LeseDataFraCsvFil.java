package org.openjfx.Filbehandling;

import org.openjfx.base.Arrangement;
import org.openjfx.base.Billett;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeseDataFraCsvFil extends LeseFraFil {
    @Override
    public void leseFraFil(String filsti) {

    }

   /* public static List<Billett> readObject(Billett enBillett, String path) throws IOException {
        ArrayList<Billett> object = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(path));
            String line = null; // read first line

            // read the rest and create Persons for each line
            while((line=reader.readLine()) != null) {
                enBillett.add(parseBillett(line));
            }
        } finally {
            if(reader != null) {
                reader.close();
            }
        }

        return enBillett;
    }


    private static Billett parseBillett(String line) throws InvalidPersonFormatException {
        // split line string into three using the separator ";"
        String[] split = line.split(";");
        if(split.length != 3) {
           // throw new InvalidPersonFormatException("Must use semicolon ; to separate the three data fields");
        }

        String name = split[0];
        int age = parseNumber(split[1], "Age (second field) is not a number");
        int id = parseNumber(split[2], "Id (third field) is not a number");

        return new Billett(Kjøper, Arrangement);
    }

    private static int parseNumber(String str, String errorMessage) throws InvalidPersonFormatException  {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            //throw new InvalidPersonFormatException(errorMessage);
        }

        return number;
    }





    public void leseFraFil(String filsti){

        String CsvFile = "/Users/martine/Documents/GitHub/Programutvikling-semesteroppgave/Kinofilmer.csv";
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

    List<Person> persons = null;

        try {
                persons = PersonReader.readPersons("Data.csv");
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

}