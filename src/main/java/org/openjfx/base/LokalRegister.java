package org.openjfx.base;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LokalRegister {

    public ArrayList<Arrangement> konsertArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> foredragsArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> kinoArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> teaterArrangementer = new ArrayList<>();

    Foredragssal foredragsal = new Foredragssal(100,foredragsArrangementer, 1);
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
    Date dato = new Date (2019, 07, 23, 18, 30);
    ForestillingsArrangement kinofilm = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Pulp Fiction", 110, dato, 100);

    Date dato2 = new Date (2019, 07, 25, 18, 00);
    ForestillingsArrangement kinofilm2 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "The Hateful Eight", 120, dato2, 100);

    Date dato3 = new Date (2019, 07, 28, 21, 00);
    ForestillingsArrangement kinofilm3 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Once Upon a Time in Hollywood", 150, dato3, 100);



    // Oppretter teaterforestilling:
    Date dato4 = new Date (2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Sweeney Todd", 200, dato4, 100);

    Date dato5 = new Date (2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling2 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Cats", 220, dato5, 100);

    Date dato6 = new Date (2019, 07, 23, 18, 30);
    ForestillingsArrangement teaterforestilling3 = new ForestillingsArrangement
            (forestillingsAnsvarlig, "Les Miserables", 250, dato6, 100);


    public void leggInnFilmer () {
        kinoArrangementer.add(kinofilm);
        kinoArrangementer.add(kinofilm2);
        kinoArrangementer.add(kinofilm3);
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
    public String visAlleKonsertArrangementer(){
        String arrangementer = "";
        for(Arrangement etArrangement : konsertArrangementer){
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }

    public String visAlleForedragsArrangementer(){
        String arrangementer = "";
        for(Arrangement etArrangement : foredragsArrangementer){
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }

    public String visAlleKinoArrangementer(){
        String arrangementer = "";
        for(Arrangement etArrangement : kinoArrangementer){
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }

    public String visAlleTeaterArrangementer(){
        String arrangementer = "";
        for(Arrangement etArrangement : teaterArrangementer){
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }




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