package org.openjfx.base;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class LokalRegister {

    //TODO: Må finne ut hvordan vi skal løse det med hvor arrangementene skal ligge?
    public ArrayList<Arrangement> alleArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> konsertArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> foredragsArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> kinoArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> teaterArrangementer = new ArrayList<>();

    public LokalRegister() {
        leggInnFilmer();
        leggInnTeaterforestilling();
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

    // Oppretter kinofilmer:
    Dato dato = new Dato(20,03,2019);
    Klokkeslett klokkeslett = new Klokkeslett(18,30);
    ForestillingsArrangement kinofilm = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Pulp Fiction", 110, dato, klokkeslett, 100, TypeArrangement.KINO);

    Dato dato2 = new Dato(20,03,2019);
    Klokkeslett klokkeslett2 = new Klokkeslett(18,30);
    ForestillingsArrangement kinofilm2 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "The Hateful Eight", 120, dato2, klokkeslett2,100, TypeArrangement.KINO);

    Dato dato3 = new Dato(20,03,2019);
    Klokkeslett klokkeslett3 = new Klokkeslett(18,30);
    ForestillingsArrangement kinofilm3 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Once Upon a Time in Hollywood", 150, dato3, klokkeslett3, 100, TypeArrangement.KINO);


    // Oppretter teaterforestilling:
    Dato dato4 = new Dato(20,03,2019);
    Klokkeslett klokkeslett4 = new Klokkeslett(18,30);
    ForestillingsArrangement teaterforestilling = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Sweeney Todd", 200, dato4, klokkeslett4, 100, TypeArrangement.TEATER);

    Dato dato5 = new Dato(2019, 07, 23);
    Klokkeslett klokkeslett5 = new Klokkeslett(18,30);
    ForestillingsArrangement teaterforestilling2 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Cats", 220, dato5, klokkeslett5, 100, TypeArrangement.TEATER);

    Dato dato6 = new Dato(2019, 07, 23);
    Klokkeslett klokkeslett6 = new Klokkeslett(18,30);
    ForestillingsArrangement teaterforestilling3 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Les Miserables", 250, dato6, klokkeslett6, 100, TypeArrangement.TEATER);


    public void leggInnFilmer() {
        kinoArrangementer.add(kinofilm);
        kinoArrangementer.add(kinofilm2);
        kinoArrangementer.add(kinofilm3);
    }

    public void registrerKinoArrangement(Arrangement etArrangement) {
        kinoArrangementer.add(etArrangement);
    }

    public void leggInnTeaterforestilling() {
        teaterArrangementer.add(teaterforestilling);
        teaterArrangementer.add(teaterforestilling2);
        teaterArrangementer.add(teaterforestilling3);
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
    //TODO: Må ha med klokkeslett her også dersom det skal med
    public ArrayList ArrayTilString(ArrayList<Arrangement> arraylist) {
        ArrayList<String> navnOgTidArrangementer = new ArrayList<>();
        for (int i = 0; i < arraylist.size(); i++) {
            navnOgTidArrangementer.add(arraylist.get(i).getArrangementNavn() + ": " + arraylist.get(i).getKlokkeslett()+" den "+arraylist.get(i).getDato());
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