package org.openjfx.controller.uihelpers;


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

        boolean dato = true;
        dato = innDato.matches("^[0-3][0-9][/][0-1][0-9][/][2][0-9][1-9][0-9]$");
        if (!dato) {
            throw new InvalidDatoException("Ikke gyldig dato. Må skrives: dd/mm/åååå");
        }
        return true;
    }

    public static boolean sjekkGyldigKlokkeslett(String innKlokkeslett) throws InvalidKlokkeslettException {

        boolean klokkeslett = true;
        klokkeslett = innKlokkeslett.matches("^[0-2][0-9][:][0-5][0-9]$");
        if (!klokkeslett) {
            throw new InvalidKlokkeslettException("Ikke gyldig klokkeslett. Må skrives: tt:mm");
        }
        return true;
    }

    public static boolean sjekkGyldigNettsideAdresse(String nettsideAdresse) throws InvalidNettsideAdresseException {
        String[] splitNettside = nettsideAdresse.split(".");
        if (splitNettside.length > 2) {
            throw new InvalidNettsideAdresseException(nettsideAdresse + "er ikke en gyldig nettsideadresse. ");
        }
        return true;
    }
}