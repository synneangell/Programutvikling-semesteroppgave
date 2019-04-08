package org.openjfx.base;

public class Kjøper extends Person {
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

    /*@Override
    public String toString() {
        String ut = "Navn"
    }*/

}
