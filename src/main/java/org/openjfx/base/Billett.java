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

    public void setArrangementNavn(String arrangementNavn) {
        this.arrangementNavn = arrangementNavn;
    }

    public String getArrangementDato() {
        return arrangementDato;
    }

    public void setArrangementDato(String arrangementDato) {
        this.arrangementDato = arrangementDato;
    }

    public String getArrangementKlokkeslett() {
        return arrangementKlokkeslett;
    }

    public void setArrangementKlokkeslett(String arrangementKlokkeslett) {
        this.arrangementKlokkeslett = arrangementKlokkeslett;
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
