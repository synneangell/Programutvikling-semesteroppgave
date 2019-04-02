package org.openjfx.Base;

public class Deltaker extends Person {
    private String egenskap;

    public Deltaker(String navn, String deltaker) {
        super(navn);
        this.egenskap = egenskap;
    }

    public String getEgenskap() {
        return egenskap;
    }

    public void setEgenskap(String egenskap) {
        this.egenskap = egenskap;
    }
}
