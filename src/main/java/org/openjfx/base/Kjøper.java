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

    @Override
    public String toString() {
        return getNavn() + "," + telefonNr + "," + email;
    }

}
