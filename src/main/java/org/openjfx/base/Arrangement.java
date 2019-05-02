package org.openjfx.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

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
        for(Billett enBillett : billetter){
            if(enBillett.getKjøper()==null){
                ledigBilletter ++;
            }
        }
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

