package org.openjfx.controller.uihelpers;

public class SjekkOmGyldig {

    public static String sjekkGyldigEmail(String email) throws InvalidEmailException {
        String[] splitStrAlpha = email.split("@");
        if (splitStrAlpha.length != 2) {
            throw new InvalidEmailException(email + "er ikke en gyldig email-adresse.");
        }
        return email;
    }

    public static int sjekkGyldigTlfNr(String telefonNr) throws NumberFormatException {
        try {
            int innTall = Integer.parseInt(telefonNr);
            if (innTall > 0) {
                return 0;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
        return 0;
    }

    public static boolean sjekkGyldigNavn(String navn) throws InvalidInputException {
        boolean numeric = true;
        numeric = navn.matches("-?\\d+(\\.\\d+)?");
        if (numeric) {
            throw new InvalidInputException("Det må stå tekst og ikke tall.");
        }
        return numeric;
    }

    public static int sjekkGyldigBillettPris(int billettPris) throws InvalidPriceException {
            if(billettPris > 0){
                throw new InvalidPriceException(billettPris + "Det må være skrevet inn tall.");
    }
            return billettPris;
    }

    //TODO: må lage en try/catch under alle disse metodene sånn at programmet ikke skal krasje og brukeren kan fortsette å skrive inn
    // etter at feilmeldingen kommer opp i en boks (alert - dette må også fikses).

 /*   try {


    } catch (IOException e){

    }*/

}
