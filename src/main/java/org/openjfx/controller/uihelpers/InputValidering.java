package org.openjfx.controller.uihelpers;

import javafx.scene.control.TextField;

/*  Feltene som må valideres i bookLokale.fxml:
    private String telefonNr;
    private String emailAdresse;
    private String nettside;
    private String virksomhet;
    private String opplysninger;

    public Deltaker(
    String navn, String egenskap)

    private String arrangementNavn;
    private int billettpris;
    private Date tidspunkt;


 */

/*public class InputValidering {

    public static int validerKunTekst(TextField input, String tekst){
        boolean numeric = true;
        numeric = tekst.matches("-?\\d+(\\.\\d+)?");
        if (numeric) {
            return -1;
        }
        return 0;
    }

    public static int validerKunTall(TextField input, String tall) *//* throws InvalidTallException *//* {
        try {
            int innTall = Integer.parseInt(tall);
            if (innTall > 0) {
                return 0;
            } else {
                return -3;
            }
        } catch (NumberFormatException e) {
            return -3;
        }

    }

}*/
/*
    public static int validerEmail (TextField input, String email) throws InvalidEmailException {
        String[] splitStrAlpha = email.split("@");
        if (splitStrAlpha.length != 2){
            throw new InvalidEmailException (email + " er ikke en gyldig email-adresse.");
            return -4;
        }
        return 0;
    }

*/