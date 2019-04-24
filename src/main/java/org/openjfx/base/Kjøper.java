package org.openjfx.base;

import java.io.Serializable;

public class Kjøper extends Person implements Serializable {
    private String telefonNr;
    private String email;

    public Kjøper(String navn, String telefonNr, String email) {
        super(navn);
        this.telefonNr = telefonNr;
        this.email = email;
    }

    public String getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nNavn: " + getNavn() + ", telefonnummer: "+telefonNr+", email: "+email+". ";
    }

}
