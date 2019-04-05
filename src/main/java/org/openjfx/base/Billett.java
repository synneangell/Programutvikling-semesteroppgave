package org.openjfx.base;

public class Billett {
    private Kjøper kjøper;
    private Arrangement arrangement;

    public Billett(Kjøper kjøper, Arrangement arrangement){
        this.kjøper = kjøper;
        this.arrangement = arrangement;
    }

    public String toString(){
        String ut = "Kjøper: "+kjøper+" Arrangement: "+arrangement+"\n";
        return ut;
    }


    //private int genererPlass(){}
    //private String formaterBillett(){}

}
