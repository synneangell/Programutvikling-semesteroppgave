package org.openjfx.Base;

public class Arrangement {
    private Kontaktperson kontaktperson;
    private String arrangementNavn;
    private int billettpris;
    private Date tidspunkt;

    public Arrangement (Kontaktperson kontaktperson, String arrangementNavn, int billettpris, Date tidspunkt){
        this.kontaktperson = kontaktperson;


    }

    private String program(Kontaktperson kontaktperson, String arrangementNavn, int billettPris, Date tidspunkt);

}
