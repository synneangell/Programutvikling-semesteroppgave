package org.openjfx.base;

import java.io.Serializable;

public class Kontaktperson extends Person implements Serializable {
    private String telefonNr;
    private String emailAdresse;
    private String nettside;
    private String virksomhet;
    private String opplysninger;


    public Kontaktperson(String navn, String telefonNr, String emailAdresse, String nettside, String virksomhet, String opplysninger){
        super(navn);
        this.telefonNr = telefonNr;
        this.emailAdresse = emailAdresse;
        this.nettside = nettside;
        this.virksomhet = virksomhet;
        this.opplysninger = opplysninger;
    }

    public String getTelefonNr() {
        return telefonNr;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public String getNettside() {
        return nettside;
    }

    public String getVirksomhet() {
        return virksomhet;
    }

    public String getOpplysninger() {
        return opplysninger;
    }
}
