package org.openjfx.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Arrangement implements Serializable {
    private Kontaktperson kontaktperson;
    private String arrangementNavn;
    private int billettpris;
    private Dato dato;
    private Klokkeslett klokkeslett;
    private int antallBilletter;
    TypeArrangement typeArrangement;

    //Må dennne settes i konstruktøren?
    ArrayList<Billett> billetter = new ArrayList<>(antallBilletter);

    public Arrangement (Kontaktperson kontaktperson, String arrangementNavn, int billettpris, Dato dato, Klokkeslett klokkeslett, int antallBilletter, TypeArrangement typeArrangement){
        this.kontaktperson = kontaktperson;
        this.arrangementNavn = arrangementNavn;
        this.billettpris = billettpris;
        this.dato = dato;
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

    public Dato getDato() {
        return dato;
    }

    public Klokkeslett getKlokkeslett() {
        return klokkeslett;
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

    public void setDato(Dato dato) {
        this.dato = dato;
    }

    public void setKlokketslett(Klokkeslett klokkeslett) {
        this.klokkeslett = klokkeslett;
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

    /*
    public int compareTo(Arrangement arrangement) {
        return (this.arrangementNavn).compareTo(arrangement.arrangementNavn);

    }

    //Sortere arrangementer etter dato?
    @Override
    public int compare(Arrangement a1, Arrangement a2) {
        if (a1.getTidspunkt() == null || a2.getTidspunkt() == null)
            return 0;
        return a1.getTidspunkt().compareTo(a2.getTidspunkt());
    }   */

    public String program(Kontaktperson kontaktperson, String arrangementNavn, int billettPris, Date tidspunkt){
        return "";
    }

    @Override
    public String toString() {
        return arrangementNavn+" : kl."+klokkeslett+" den "+dato;
    }

    /*
    public String toString(){
        String ut = "Kontaktperson: "+kontaktperson+" Arrangementnavn: "+arrangementNavn+" Billettpris: "+billettpris+
                "Tidspunkt: "+tidspunkt+"\n";
        return ut;
    }*/
}
