package org.openjfx.Filbehandling;

import org.openjfx.base.Billett;
import org.openjfx.base.Kjøper;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BillettCsvLeser extends LeseFil {
    @Override
    public ArrayList<Object> leseFraFil(String filsti) throws InvalidBillettFormatException, IOException{
       ArrayList<Object> billett = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(filsti));
            String line = null; // leser første linje

            // leser resten og lager billetter for hver linje
            while ((line = reader.readLine()) != null) {
                billett.add(parseBillett(line));
                throw new InvalidBillettFormatException("Billetten er ikke formatert riktig");
            }

        } catch (IOException e) {
            System.out.println("");

        } finally {
            if(reader != null) {
                reader.close();
            }
        }
        return billett;
    }

    private static Billett parseBillett(String line) throws InvalidBillettFormatException {
        // Deler opp stringen i tre deler ved bruk av ";"
        String[] split = line.split(",");
        if(split.length != 4) {
            throw new InvalidBillettFormatException("Må bruke semikolon ; til å separere de tre datafeltene");
        }

        String name = split[0];
        String telefonNr = split[1];
        String email = split[2];
        String id = split[3];


        return new Billett(new Kjøper(name, telefonNr, email), id);
    }
}
