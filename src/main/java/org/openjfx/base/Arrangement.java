package org.openjfx.base;

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

    ArrayList<Billett> billetter = new ArrayList<>(antallBilletter);

    public Arrangement(Kontaktperson kontaktperson, String arrangementNavn, int billettpris, String dato, String klokkeslett, int antallBilletter, TypeArrangement typeArrangement) {
        this.kontaktperson = kontaktperson;
        this.arrangementNavn = arrangementNavn;
        this.billettpris = billettpris;
        this.dato = dato;
        this.antallBilletter = antallBilletter;
        this.klokkeslett = klokkeslett;
        this.typeArrangement = typeArrangement;
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

    public void setBillettpris(int billettpris) {
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
}

    /*

    public void leggTilBillett(Billett enBillett){
       //Må returnere en feilmelding dersom det ikke er plass til flere billetter
        billetter.add(enBillett);
    }

    private String slettBillett(int referansenummer){
        for (Billett enBillett : billetter){
            if(enBillett.getReferansenummer() == referansenummer){
                    //billetten er funnet og man sletter den fra alleBilletter arrayet.
                    billetter.remove(enBillett);
                    return "Billetten er slettet";
                }
            }
            return "Fant ikke referansenummer";
    }


}
 */
