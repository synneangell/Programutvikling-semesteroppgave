package org.openjfx.Filbehandling;

import org.openjfx.base.Arrangement;
import org.openjfx.base.Billett;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LesBillettFraCsvFil extends LeseFraFil {
    @Override
    public void leseFraFil(String filsti) {
       /* ArrayList<Billett> persons = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(path));
            String line = null; // read first line

            // read the rest and create Persons for each line
            while((line=reader.readLine()) != null) {
                persons.add(parsePerson(line));
            }
        } finally {
            if(reader != null) {
                reader.close();
            }
        }

        return persons;
    }

    private static Billett parseBillett(String line) throws InvalidPersonFormatException {
        // split line string into three using the separator ";"
        String[] split = line.split(";");
        if(split.length != 3) {
            throw new InvalidPersonFormatException("Must use semicolon ; to separate the three data fields");
        }

        String name = split[0];
        int age = parseNumber(split[1], "Age (second field) is not a number");
        int id = parseNumber(split[2], "Id (third field) is not a number");

        return new Billett();
    }

    private static int parseNumber(String str, String errorMessage) throws InvalidPersonFormatException{
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new InvalidPersonFormatException(errorMessage);


        return number; */
    }
}
