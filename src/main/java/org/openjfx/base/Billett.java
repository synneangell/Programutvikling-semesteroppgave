package org.openjfx.base;

import java.io.Serializable;

public class Billett implements Serializable {
    private Kjøper kjøper;

    public Billett(Kjøper kjøper){
        this.kjøper = kjøper;
    }

    public Kjøper getKjøper() {
        return kjøper;
    }

    public void setKjøper(Kjøper kjøper) {
        this.kjøper = kjøper;
    }

    public String toString(){
        return kjøper.toString();
    }
}
