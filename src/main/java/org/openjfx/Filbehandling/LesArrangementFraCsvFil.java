package org.openjfx.Filbehandling;

import org.openjfx.base.*;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LesArrangementFraCsvFil extends LeseFraFil {

    @Override
    public ArrayList<?> leseFraFil(String filsti) throws InvalidBillettFormatException, IOException {
        ArrayList<Arrangement> arrangement = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(filsti));
            String line = null; // leser første linje

            // leser resten og lager billetter for hver linje
            while ((line = reader.readLine()) != null) {
                arrangement.add(parseArrangement(line));
                throw new InvalidBillettFormatException("Billetten er ikke formatert riktig");
            }

        } catch (IOException e) {
            System.out.println("");

        } finally {
            if(reader != null) {
                reader.close();
            }
        }
        return arrangement;
    }

    private static Arrangement parseArrangement(String line) throws InvalidBillettFormatException {
        // Deler opp stringen i tre deler ved bruk av ";"
        String[] split = line.split(",");
        if(split.length != 11) {
            throw new InvalidBillettFormatException("Må bruke semikolon ; til å separere de tre datafeltene");
        }

        //TODO: fikse slik at programmet også leser inn hvilket type arrangement hører til bookingen
        String navn = split[0];
        String telefonNr = split[1];
        String emailAdresse = split[2];
        String nettside = split[3];
        String virksomhet = split[4];
        String opplysninger = split[5];
        String arrangementNavn = split[6];
        int billettpris = parseNummer(split[7], "Billettprisen må være et nummer");
        String dato = split[8];
        String klokkeslett = split[9];
        int antallBilletter = parseNummer(split[10], "AntallBilletter må være et nummer");
        //TypeArrangement typeArrangement = split[11];


        //TODO: fikse feilen, skjønner ikke helt hva som er feil her.
        //return new Arrangement((new Kontaktperson (navn, telefonNr, emailAdresse, nettside, virksomhet, opplysninger))
        //    arrangementNavn, billettpris, dato, klokkeslett, antallBilletter);
        return null;
    }

    private static int parseNummer (String str, String errorMelding) throws InvalidBillettFormatException {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new InvalidBillettFormatException(errorMelding);
        }
        return number;
    }
}
