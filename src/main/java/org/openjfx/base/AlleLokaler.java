package org.openjfx.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static org.openjfx.base.AlleArrangementer.*;

public class AlleLokaler {


    private static AlleLokaler instance;
    private ObservableList<Lokale> alleLokaler = null;

    Foredragssal foredragssal = null;
    Konsertsal konsertsal = null;
    Teatersal teatersal = null;
    Kinosal kinosal = null;


    public Foredragssal getForedragssal() {
        return foredragssal;
    }

    public void setForedragssal(Foredragssal foredragssal) {
        this.foredragssal = foredragssal;
    }

    public Konsertsal getKonsertsal() {
        return konsertsal;
    }

    public void setKonsertsal(Konsertsal konsertsal) {
        this.konsertsal = konsertsal;
    }

    public Teatersal getTeatersal() {
        return teatersal;
    }

    public void setTeatersal(Teatersal teatersal) {
        this.teatersal = teatersal;
    }

    public Kinosal getKinosal() {
        return kinosal;
    }

    public void setKinosal(Kinosal kinosal) {
        this.kinosal = kinosal;
    }

    protected AlleLokaler(){
        alleLokaler = FXCollections.observableArrayList();
        foredragssal = new Foredragssal(100,  1);
        konsertsal = new Konsertsal(400, 2);
        teatersal = new Teatersal(100, 3);
        kinosal = new Kinosal(100, 4);

        leggTilLokale(foredragssal);
        leggTilLokale(konsertsal);
        leggTilLokale(teatersal);
        leggTilLokale(kinosal);

        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();
        leggArrangementerILokaler(alleArrangementer.getArrangementer());
    }

    public ObservableList<Lokale> getLokaler(){
        return alleLokaler;
    }


    public static AlleLokaler getSingelton(){
        if(instance == null){
            instance = new AlleLokaler();
        }
        return instance;
    }


    public void leggTilLokale(Lokale etLokale){
        alleLokaler.add(etLokale);
    }


    public void leggArrangementerILokaler(ObservableList<Arrangement> arrangementer){
           for (Arrangement etArrangement : arrangementer){
            if(etArrangement.typeArrangement == TypeArrangement.KINO){
                kinosal.leggTilArrangement(etArrangement);
            }
            if(etArrangement.typeArrangement == TypeArrangement.TEATER){
                teatersal.leggTilArrangement(etArrangement);
            }
            if(etArrangement.typeArrangement == TypeArrangement.KONSERT){
                konsertsal.leggTilArrangement(etArrangement);
            }
            if(etArrangement.typeArrangement == TypeArrangement.FOREDRAG){
                foredragssal.leggTilArrangement(etArrangement);
            }
        }
    }

    public static int antallPlasser(Lokale etLokale){
        return antallPlasser(etLokale);
    }

}

