package org.openjfx.controller.uihelpers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SjekkOmGyldig {

    public static boolean sjekkGyldigEmail(String email) throws InvalidEmailException {
        String[] splitStrAlpha = email.split("@");
        if (splitStrAlpha.length != 2) {
            throw new InvalidEmailException(email + "er ikke en gyldig email-adresse. ");
        }
        return true;
    }

    public static boolean sjekkGyldigTlfNr(String telefonNr) throws InvalidTelefonnummerException {
        boolean telefonnummer = true;
        telefonnummer = telefonNr.matches("^[0-9]{8}$");
        if (!telefonnummer) {
            throw new InvalidTelefonnummerException("Telefonnummeret må bestå av 8 siffer. ");
        }
        return true;
    }

    public static boolean sjekkKunBokstaver(String tekst) throws InvalidTekstException {
        boolean numeric = true;
        numeric = tekst.matches("-?\\d+(\\.\\d+)?");
        if (numeric) {
            throw new InvalidTekstException("Det må stå tekst og ikke tall.");
        }
        return true;
    }

    public static boolean sjekkGyldigBillettpris(String InnBillettpris) throws InvalidBillettprisException {
        try {
            int billettpris = Integer.parseInt(InnBillettpris);
            if (billettpris < 0) {
                throw new InvalidBillettprisException(billettpris + "Det må være skrevet inn tall. ");
            }
        }
        catch(NumberFormatException e){
            throw new InvalidBillettprisException("Det må være skrevet inn tall. ");
        }
        return true;
    }

    //TODO: Hvordan sikre at datoer som har vært ikke kan velges??

    public static boolean sjekkGyldigDato(String innDato) throws InvalidDatoException {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        String[] datoNåArray = dateFormat.format(date).split("/");
        String[] datoArray = innDato.split("/");

        try {
            int dagNå = Integer.parseInt(datoNåArray[0]);
            int månedNå = Integer.parseInt(datoNåArray[1]);
            int årNå = Integer.parseInt(datoNåArray[2]);
            int innDag = Integer.parseInt(datoArray[0]);
            int innMåned = Integer.parseInt(datoArray[1]);
            int innÅr = Integer.parseInt(datoArray[2]);

            System.out.println(dagNå);
            System.out.println(månedNå);
            System.out.println(årNå);

            System.out.println(innDag);
            System.out.println(innMåned);
            System.out.println(innÅr);

            if (datoArray.length != 2) {
                throw new InvalidDatoException("Ikke gyldig format for dato.");
            } else if (årNå > innÅr) {
                throw new InvalidDatoException("Dato må være frem i tid.");
            } else if (årNå == innÅr && månedNå > innMåned) {
                throw new InvalidDatoException("Dato må være frem i tid.");
            } else if (årNå == innÅr && månedNå == innMåned && dagNå > innDag) {
                throw new InvalidDatoException("Dato må være frem i tid.");
            }
        }
        catch (NumberFormatException e){
            throw new InvalidDatoException("Dato må være skrevet med tall");
        }
        return true;
    }

    /*  dato = innDato.matches("^[0-3][0-9][/][0-1][0-9][/][2][0-9][1-9][0-9]$");
        if (!dato) {
            throw new InvalidDatoException(feilmelding);
        }
        return true; */

    public static boolean sjekkGyldigKlokkeslett(String innKlokkeslett) throws InvalidKlokkeslettException {

        boolean klokkeslett = true;
        klokkeslett = innKlokkeslett.matches("^[0-2][0-9][:][0-5][0-9]$");
        if (!klokkeslett) {
            throw new InvalidKlokkeslettException("Ikke gyldig klokkeslett. Må skrives: tt:mm");
        }
        return true;
    }

    public static boolean sjekkGyldigNettsideAdresse(String nettsideAdresse) throws InvalidNettsideAdresseException {
        String[] splitNettside = nettsideAdresse.split("\\.");
        if (splitNettside.length > 2) {
            throw new InvalidNettsideAdresseException(nettsideAdresse + "er ikke en gyldig nettsideadresse. ");
        }
        return true;
    }
}