package org.openjfx.base;

public class Kjøper extends Person {
    private String telefonNr;

    public Kjøper(String navn, String telefonNr) {
        super(navn);
        this.telefonNr = telefonNr;
    }

    public String getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }
}
