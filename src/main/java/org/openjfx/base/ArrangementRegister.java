package org.openjfx.base;

import java.util.ArrayList;

public class ArrangementRegister {

    public ArrayList<Arrangement> alleArrangementer = new ArrayList<>();

    public ArrayList<Arrangement> konsertArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> foredragsArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> kinoArrangementer = new ArrayList<>();
    public ArrayList<Arrangement> teaterArrangementer = new ArrayList<>();


    public void registrerArrangement(Arrangement etArrangement) {
        alleArrangementer.add(etArrangement);
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

    private String visAlleArrangementer() {
        String arrangementer = "";
        for (Arrangement etArrangement : alleArrangementer) {
            arrangementer += etArrangement + "\n";
        }
        return arrangementer;
    }

}

 /*  METODER FOR Å VISE KONSERT-ARRANGEMENT, FOREDRAGS OSV...

    private String visAlleKonsertArrangementer(){
        String arrangementer = "";
        for(Arrangement etArrangement : konsertArrangementer){
            arrangementer += etArrangement + "\n";
        }
    }

    //egne metoder for å vise arrangementer kun i kinosal/teatersal/foredragssal/konsertsal?
    private String visAlleForedragsArrangementer(){
        String arrangementer = "";
        for(Arrangement etArrangement : foredragsArrangementer){
            arrangementer += etArrangement + "\n";
        }
    }

    private String visAlleKinoArrangementer(){
        String arrangementer = "";
        for(Arrangement etArrangement : kinoArrangementer){
            arrangementer += etArrangement + "\n";
        }
    }

    private String visAlleTeaterArrangementer(){
        String arrangementer = "";
        for(Arrangement etArrangement : teaterArrangementer){
            arrangementer += etArrangement + "\n";
        }
    } */

    //metoder for å slette/endre arrangementer?


