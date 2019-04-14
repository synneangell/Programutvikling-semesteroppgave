package org.openjfx.base;

import java.io.Serializable;

public class Deltaker extends Person implements Serializable {
    private String egenskap;

    public Deltaker(String navn, String egenskap) {
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
