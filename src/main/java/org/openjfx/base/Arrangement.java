package org.openjfx.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Arrangement implements Comparator<Arrangement>, Comparable<Arrangement> {
    private Kontaktperson kontaktperson;
    private String arrangementNavn;
    private int billettpris;
    private Date tidspunkt;
    private int antallBilletter;

    //Må dennne settes i konstruktøren?
    ArrayList<Billett> billetter = new ArrayList<>(antallBilletter);

    public Arrangement (Kontaktperson kontaktperson, String arrangementNavn, int billettpris, Date tidspunkt, int antallBilletter){
        this.kontaktperson = kontaktperson;
        this.arrangementNavn = arrangementNavn;
        this.billettpris = billettpris;
        this.tidspunkt = tidspunkt;
        this.antallBilletter = antallBilletter;
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

    //Endre billett? Hva skal man kunne endre?
    private void endreBillett(){
    }


    public int compareTo(Arrangement arrangement) {
        return (this.arrangementNavn).compareTo(arrangement.arrangementNavn);

    }

    //Sortere arrangmenter etter dato?
    @Override
    public int compare(Arrangement a1, Arrangement a2) {
        if (a1.getTidspunkt() == null || a2.getTidspunkt() == null)
            return 0;
        return a1.getTidspunkt().compareTo(a2.getTidspunkt());
    }

    public String program(Kontaktperson kontaktperson, String arrangementNavn, int billettPris, Date tidspunkt){
        return "";
    }

    public String toString() {
        return arrangementNavn+" "+ new SimpleDateFormat("dd.MM.YYYY HH:mm").format(tidspunkt);
    }



    public String toString(){
        String ut = "Kontaktperson: "+kontaktperson+" Arrangementnavn: "+arrangementNavn+" Billettpris: "+billettpris+
                "Tidspunkt: "+tidspunkt+"\n";
        return ut;
    }
}
