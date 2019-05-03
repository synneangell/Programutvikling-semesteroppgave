package org.openjfx.base;

import java.io.Serializable;

public class Billett implements Serializable {
    public Kjøper getKjøper() {
        return kjøper;
    }

    public void setKjøper(Kjøper kjøper) {
        this.kjøper = kjøper;
    }

    public String getArrangementNavn() {
        return arrangementNavn;
    }

    public String getArrangementDato() {
        return arrangementDato;
    }

    public String getArrangementKlokkeslett() {
        return arrangementKlokkeslett;
    }

    private Kjøper kjøper;
    private String arrangementNavn;
    private String arrangementDato;
    private String arrangementKlokkeslett;

    public Billett(Kjøper kjøper, String arrangementNavn, String arrangementDato, String arrangementKlokkeslett){
        this.arrangementNavn = arrangementNavn;
        this.arrangementDato = arrangementDato;
        this.arrangementKlokkeslett = arrangementKlokkeslett;
        this.kjøper = kjøper;
    }

    public String toString(){
        return kjøper.toString()+","+arrangementNavn+","+arrangementDato+","+arrangementKlokkeslett;
    }
}
