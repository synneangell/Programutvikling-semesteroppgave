package org.openjfx.base;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Arrangement implements Comparator<Arrangement>, Comparable<Arrangement>, Serializable {
    private static final long serialVersionUID = 1;
    private Kontaktperson kontaktperson;
    private String arrangementNavn;
    private int billettpris;
    private Date tidspunkt;
    private int antallBilletter;
    TypeArrangement typeArrangement;
    ArrayList<Billett> billetter = new ArrayList<>(antallBilletter);

    public Arrangement (Kontaktperson kontaktperson, String arrangementNavn, int billettpris, Date tidspunkt, int antallBilletter, TypeArrangement typeArrangement){
        this.kontaktperson = kontaktperson;
        this.arrangementNavn = arrangementNavn;
        this.billettpris = billettpris;
        this.tidspunkt = tidspunkt;
        this.antallBilletter = antallBilletter;
        this.typeArrangement = typeArrangement;
        ArrayList<Billett> billetter = new ArrayList<>(antallBilletter);
    }

    public Kontaktperson getKontaktperson() {
        return kontaktperson;
    }

    public String getArrangementNavn() {
        return arrangementNavn;
    }

    public int getBillettpris() {
        return billettpris;
    }

    public Date getTidspunkt() {
        return tidspunkt;
    }

    public void setKontaktperson(Kontaktperson kontaktperson) {
        this.kontaktperson = kontaktperson;
    }

    public void setArrangementNavn(String arrangementNavn) {
        this.arrangementNavn = arrangementNavn;
    }

    public void setBillettpris(int billettpris) {
        this.billettpris = billettpris;
    }

    public void setTidspunkt(Date tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

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

    //TODO: Endre billett? Hva skal man kunne endre?
    private void endreBillett(){
    }


    public int compareTo(Arrangement arrangement) {
        return (this.arrangementNavn).compareTo(arrangement.arrangementNavn);

    }

    //TODO: Riktig måte for å sortere arrangementer etter dato/tidspunkt?
    @Override
    public int compare(Arrangement a1, Arrangement a2) {
        if (a1.getTidspunkt() == null || a2.getTidspunkt() == null)
            return 0;
        return a1.getTidspunkt().compareTo(a2.getTidspunkt());
    }

    //TODO: Lage program man kan skrive ut?
    public String program(Kontaktperson kontaktperson, String arrangementNavn, int billettPris, Date tidspunkt){
        return "";
    }

    @Override
    public String toString() {
        return arrangementNavn+" : kl. "+ new SimpleDateFormat("HH:mm, EEEEE dd. MMMMM YYYY").format(tidspunkt);
    }

    /*
    public String toString(){
        String ut = "Kontaktperson: "+kontaktperson+" Arrangementnavn: "+arrangementNavn+" Billettpris: "+billettpris+
                "Tidspunkt: "+tidspunkt+"\n";
        return ut;
    }*/
}
