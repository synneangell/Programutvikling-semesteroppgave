package org.openjfx.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private ArrayList<Billett> billetter = new ArrayList<>();

    public Arrangement(Kontaktperson kontaktperson, String arrangementNavn, int billettpris, String dato, String klokkeslett, int antallBilletter, TypeArrangement typeArrangement) {
        this.kontaktperson = kontaktperson;
        this.arrangementNavn = arrangementNavn;
        this.billettpris = billettpris;
        this.dato = dato;
        this.klokkeslett = klokkeslett;
        this.typeArrangement = typeArrangement;
        this.antallBilletter = antallBilletter;
        for(int i = 0; i < antallBilletter; i++) {
            billetter.add(new Billett(null, arrangementNavn, dato, klokkeslett));
        }
    }

    public ArrayList<Billett> getBilletter() {
        return billetter;
    }

    public String getArrangementNavn() {
        return arrangementNavn;
    }

    public void setArrangementNavn(String arrangementNavn) {
        this.arrangementNavn = arrangementNavn;
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

    public String leggTilBillett(Kjøper enKjøper, int antallBilletter) {
        String ut ="";

        for (int i = 0; i < antallBilletter; i++) {
            for (int j = 0; j < billetter.size(); j++) {
                if (billetter.get(i).getKjøper() == null) {
                    billetter.get(i).setKjøper(enKjøper);
                    ut = "Vellykket kjøp!";
                }
            }
        }
        return ut;
    }

    public void leggTilBillettFraFil(Billett enBillett){
        billetter.add(enBillett);
    }


    public int ledigBilletter(){
        int ledigBilletter = 0;
        ledigBilletter = getAntallBilletter()-solgteBilletter();
        return ledigBilletter;
    }

    public int solgteBilletter(){
        int solgteBilletter = 0;
        for(Billett enBillett : billetter){
            if(enBillett.getKjøper()!=null){
                solgteBilletter ++;
            }
        }
        return solgteBilletter;
    }

    public ObservableList<Billett> visBilletterTilArrangement(){
        ObservableList<Billett> billetterObservableList = FXCollections.observableArrayList();
        for(Billett enBillett : billetter){
            if(enBillett.getKjøper() != null) {
                billetterObservableList.add(enBillett);
            }
        }
        return billetterObservableList;
    }

    public String toString (){
        return kontaktperson.getNavn()+","+kontaktperson.getTelefonNr()+","+kontaktperson.getEmailAdresse()+","
                +kontaktperson.getNettside()+","+kontaktperson.getVirksomhet()+","+kontaktperson.getOpplysninger()+","+
                arrangementNavn+","+billettpris+","+dato+","+klokkeslett+","+antallBilletter+","+typeArrangement;
    }
}

