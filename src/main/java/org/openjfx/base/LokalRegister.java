package org.openjfx.base;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LokalRegister {

    public ArrayList<Arrangement> konsertArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> foredragsArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> kinoArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> teaterArrangementer = new ArrayList<>();

    Foredragssal foredragsal = new Foredragssal(100,foredragsArrangementer, 1);
    Konsertsal konsertsal = new Konsertsal(400, konsertArrangementer, 2);
    Teatersal teatersal = new Teatersal(100, teaterArrangementer, 3);
    Kinosal kinosal = new Kinosal(100, kinoArrangementer, 4);

    ForestillingsArrangement kinoArrangement = new ForestillingsArrangement<>();


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

    //egne metoder for å vise arrangementer kun i kinosal/teatersal/foredragssal/konsertsal?
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