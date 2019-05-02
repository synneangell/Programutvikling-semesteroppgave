package org.openjfx.base;

import java.io.Serializable;
import java.util.ArrayList;

public class Billett implements Serializable {
    private Kjøper kjøper;
    private int arrangementID;

    public Billett(Kjøper kjøper, int arrangementID){
        this.arrangementID = arrangementID;
        this.kjøper = kjøper;
    }

    public Kjøper getKjøper() {
        return kjøper;
    }

    public void setKjøper(Kjøper kjøper) {
        this.kjøper = kjøper;
    }


    public int getArrangementID() {
        return arrangementID;
    }

    public void setArrangementID(int arrangementID) {
        this.arrangementID = arrangementID;
    }

    public String toString(){
        return kjøper.toString()+","+arrangementID;
    }

}
