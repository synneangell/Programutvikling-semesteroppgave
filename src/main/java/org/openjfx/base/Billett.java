package org.openjfx.base;

import java.io.Serializable;

public class Billett implements Serializable {
    private Kjøper kjøper;
    private String arrangementID;

    public Billett(Kjøper kjøper, String arrangementID){
        this.arrangementID = arrangementID;
        this.kjøper = kjøper;
    }

    public Kjøper getKjøper() {
        return kjøper;
    }

    public void setKjøper(Kjøper kjøper) {
        this.kjøper = kjøper;
    }


    public String getArrangementID() {
        return arrangementID;
    }

    public void setArrangementID(String arrangementID) {
        this.arrangementID = arrangementID;
    }

    public String toString(){
        return kjøper.toString()+","+arrangementID;
    }
}
