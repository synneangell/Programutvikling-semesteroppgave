package org.openjfx.base;

import org.openjfx.controller.uihelpers.InvalidBillettprisException;

import java.io.Serializable;
import java.util.ArrayList;

public class Arrangement implements Serializable {
    private Kontaktperson kontaktperson;
    private String arrangementNavn;
    private int billettpris;
    private String dato;
    private String klokkeslett;
    private int antallBilletter;
    TypeArrangement typeArrangement;

    ArrayList<Billett> billetter = new ArrayList<>();

    public Arrangement(Kontaktperson kontaktperson, String arrangementNavn, int billettpris, String dato, String klokkeslett, int antallBilletter, TypeArrangement typeArrangement) {
        this.kontaktperson = kontaktperson;
        this.arrangementNavn = arrangementNavn;
        this.billettpris = billettpris;
        this.dato = dato;
        this.antallBilletter = antallBilletter;
        this.klokkeslett = klokkeslett;
        this.typeArrangement = typeArrangement;
        for(int i = 0; i < antallBilletter; i++) {
            billetter.add(new Billett(null));
        }
    }

    public Kontaktperson getKontaktperson() {
        return kontaktperson;
    }

    public void setKontaktperson(Kontaktperson kontaktperson) {
        this.kontaktperson = kontaktperson;
    }

    public String getArrangementNavn() {
        return arrangementNavn;
    }

    public void setArrangementNavn(String arrangementNavn) {
        this.arrangementNavn = arrangementNavn;
    }

    public int getBillettpris() {
        return billettpris;
    }

    public void setBillettpris(int billettpris){
        this.billettpris = billettpris;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getKlokkeslett() {
        return klokkeslett;
    }

    public void setKlokkeslett(String klokkeslett) {
        this.klokkeslett = klokkeslett;
    }

    public int getAntallBilletter() {
        return antallBilletter;
    }

    public void setAntallBilletter(int antallBilletter) {
        this.antallBilletter = antallBilletter;
    }

    public String getTypeArrangement() {
        String type = "";
        if (typeArrangement == TypeArrangement.KINO) {
            type = "Kino";
        }

        if (typeArrangement == TypeArrangement.FOREDRAG) {
            type = "Foredrag";
        }

        if (typeArrangement == TypeArrangement.TEATER) {
            type = "Teater";
        }

        if (typeArrangement == TypeArrangement.KONSERT) {
            type = "Konsert";
        }
        return type;
    }

    public void setTypeArrangement(TypeArrangement typeArrangement) {
        this.typeArrangement = typeArrangement;
    }


    public void leggTilBillett(Kjøper enKjøper){
        for(Billett enBillett : billetter){
            if(enBillett.getKjøper() == null)
                enBillett.setKjøper(enKjøper);
            }
    }

    public int antallBilletterIgjen(){
        int teller = 0;
        for(Billett enBillett : billetter){
            if(enBillett.getKjøper() == null){
                teller++;
            }
        }
        return teller;
    }

    public String hentBillett(Kjøper enKjøper){
        String ut = "";
        for(Billett enBillett : billetter){
            if(enBillett.getKjøper() == enKjøper){
                ut = "Hei"+enBillett.toString() + getArrangementNavn();
            }
        }
        return ut;
    }

}

