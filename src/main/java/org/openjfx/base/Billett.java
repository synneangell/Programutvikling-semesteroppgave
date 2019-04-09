package org.openjfx.base;

import java.util.ArrayList;

public class Billett {
    private Kjøper kjøper;
    private Arrangement arrangement;
    private int referansenummer;

    public Billett(Kjøper kjøper, Arrangement arrangement){
        this.kjøper = kjøper;
        this.arrangement = arrangement;
    }

    public void setReferansenummer(int referansenummer) {
        this.referansenummer = referansenummer;
    }

    public int getReferansenummer() {
        return referansenummer;
    }

    //private int genererPlass(){}
    //private String formaterBillett(){}

}
