package org.openjfx.base;

import java.io.Serializable;
import java.util.ArrayList;

public class Billett implements Serializable {
    private static final long serialVersionUID = 1;
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

    //TODO: trenger vi disse metodene?
    //private int genererPlass(){}
    //private String formaterBillett(){}

}
