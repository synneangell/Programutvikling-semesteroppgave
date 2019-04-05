package org.openjfx.base;

import java.util.Comparator;
import java.util.Date;

public class Arrangement implements Comparator<Arrangement>, Comparable<Arrangement> {
    private Kontaktperson kontaktperson;
    private String arrangementNavn;
    private int billettpris;
    private Date tidspunkt;

    public Arrangement (Kontaktperson kontaktperson, String arrangementNavn, int billettpris, Date tidspunkt){
        this.kontaktperson = kontaktperson;
        this.arrangementNavn = arrangementNavn;
        this.billettpris = billettpris;
        this.tidspunkt = tidspunkt;
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


}
