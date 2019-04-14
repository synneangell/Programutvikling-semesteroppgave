package org.openjfx.base;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class LokalRegister {

    public ArrayList<Arrangement> alleArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> konsertArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> foredragsArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> kinoArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> teaterArrangementer = new ArrayList<>();

    public LokalRegister() {
        leggInnArrangementer();
        fyllAlleArrangementerArray();
    }

    Foredragssal foredragsal = new Foredragssal(100, foredragsArrangementer, 1);
    Konsertsal konsertsal = new Konsertsal(400, konsertArrangementer, 2);
    Teatersal teatersal = new Teatersal(100, teaterArrangementer, 3);
    Kinosal kinosal = new Kinosal(100, kinoArrangementer, 4);

    // Oppretter en kontaktperson som er ansvarlig for kino- og teatervisninger
    Kontaktperson forestillingsAnsvarlig = new Kontaktperson("Aksel Ansvarlig", "22442314",
            "kontakt@kulturhuset.no", "kulturhuset.no", "Kulturhuset", "");

    public String toString() {
        return forestillingsAnsvarlig.getNavn();
    }

    //TODO: må spørre igjen om hvorfor det kommer strek over dato (duplicated?)

    // Oppretter kinofilmer:
    Date dato = new Date(2019, 07, 23, 18, 30);
    ForestillingsArrangement kinofilm = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Pulp Fiction", 110, dato, 100, TypeArrangement.KINO);

    Date dato2 = new Date(2019, 07, 25, 18, 00);
    ForestillingsArrangement kinofilm2 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "The Hateful Eight", 120, dato2, 100, TypeArrangement.KINO);

    Date dato3 = new Date(2019, 07, 28, 21, 00);
    ForestillingsArrangement kinofilm3 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Once Upon a Time in Hollywood", 150, dato3, 100, TypeArrangement.KINO);


    // Oppretter teaterforestilling:
    Date dato4 = new Date(2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Sweeney Todd", 200, dato4, 100, TypeArrangement.TEATER);

    Date dato5 = new Date(2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling2 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Cats", 220, dato5, 100, TypeArrangement.TEATER);

    Date dato6 = new Date(2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling3 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Les Miserables", 250, dato6, 100, TypeArrangement.TEATER);


    public void leggInnArrangementer() {
        teaterArrangementer.add(teaterforestilling);
        teaterArrangementer.add(teaterforestilling2);
        teaterArrangementer.add(teaterforestilling3);
        kinoArrangementer.add(kinofilm);
        kinoArrangementer.add(kinofilm2);
        kinoArrangementer.add(kinofilm3);

    }

    //TODO: kan man finne antall solgte og antall billetter igjen slik?
    public int antallSolgte(Arrangement etArrangement){

        int teller = 0;
        for(Billett enBillett:etArrangement.billetter){
            if(!etArrangement.billetter.contains(null)){
                teller++;
                return teller;
            }
        }
        return teller;
    }

    public int antallBilletterIgjen(Arrangement etArrangement){

        int teller = 0;
        for(Billett enBillett:etArrangement.billetter){
            if(etArrangement.billetter.contains(null)){
                teller++;
                return teller;
            }
        }
        return teller;
    }


   //TODO: Se om vi trenger fyllAlleArrangementerArray, eller skal dette gjøres fra starten av fra fil?

    public void fyllAlleArrangementerArray(){
        for(Arrangement etArrangement : kinoArrangementer){
            alleArrangementer.add(etArrangement);
        }
        for(Arrangement etArrangement : teaterArrangementer){
            alleArrangementer.add(etArrangement);
        }
        for(Arrangement etArrangement : foredragsArrangementer){
            alleArrangementer.add(etArrangement);
        }
        for(Arrangement etArrangement : kinoArrangementer){
            alleArrangementer.add(etArrangement);
        }
    }

    public void registrerKinoArrangement(Arrangement etArrangement) {
        kinoArrangementer.add(etArrangement);
    }

    public void registrerTeaterArrangement(Arrangement etArrangement) {
        teaterArrangementer.add(etArrangement);
    }

    public void registrerForedragsArrangement(Arrangement etArrangement) {
        foredragsArrangementer.add(etArrangement);
    }

    public void registrerKonsertArrangement(Arrangement etArrangement) {
        konsertArrangementer.add(etArrangement);
    }

    //egne metoder for å vise arrangementer kun i kinosal/teatersal/foredragssal/konsertsal
    public String visAlleKonsertArrangementer() {
        String arrangementer = "";
        for (Arrangement etArrangement : konsertArrangementer) {
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }

    public String visAlleForedragsArrangementer() {
        String arrangementer = "";
        for (Arrangement etArrangement : foredragsArrangementer) {
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }

    public String visAlleKinoArrangementer() {
        String arrangementer = "";
        for (Arrangement etArrangement : kinoArrangementer) {
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }

    public String visAlleTeaterArrangementer() {
        String arrangementer = "";
        for (Arrangement etArrangement : teaterArrangementer) {
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }

    //Metoden som formaterer arraylisten med arrangementer til string, som igjen brukes i combobox menyen i GUIet
    public ArrayList ArrayTilString(ArrayList<Arrangement> arraylist) {
        ArrayList<String> navnOgTidArrangementer = new ArrayList<>();
        for (int i = 0; i < arraylist.size(); i++) {
            navnOgTidArrangementer.add(arraylist.get(i).getArrangementNavn() + ": " +arraylist.get(i).getTidspunkt());
        }
        return navnOgTidArrangementer;
    }

    ArrayList stringKinoArrangementer = ArrayTilString(kinoArrangementer);

    //metoder for å slette/endre arrangementer?



 /*   Har vi bruk for dette?

    ArrayList<Lokale> lokaler = new ArrayList<>();

    public void leggTilLokaler(Lokale lokale) {
        lokaler.add(lokale);
    }

    public Lokale hentLokale(int lokalId){
        for (Lokale lokale: lokaler) {
            if (lokale.getId() == lokalId){
                return lokale;
            }
        }
        return null;
    }*/

}