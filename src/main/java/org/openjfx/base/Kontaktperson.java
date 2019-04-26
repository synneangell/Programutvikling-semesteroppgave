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

    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public void setEmailAdresse(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    public String getNettside() {
        return nettside;
    }

    public void setNettside(String nettside) {
        this.nettside = nettside;
    }

    public String getVirksomhet() {
        return virksomhet;
    }

    public void setVirksomhet(String virksomhet) {
        this.virksomhet = virksomhet;
    }

    public String getOpplysninger() {
        return opplysninger;
    }

    public void setOpplysninger(String opplysninger) {
        this.opplysninger = opplysninger;
    }
}
