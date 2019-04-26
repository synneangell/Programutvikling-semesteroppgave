package org.openjfx.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

import static org.openjfx.base.AlleArrangementer.*;

public class AlleLokaler {


    private static AlleLokaler instance;
    private ObservableList<Lokale> alleLokaler = null;

    Lokale foredragssal = null;
    Lokale konsertsal = null;
    Lokale teatersal = null;
    Lokale kinosal = null;


    public Lokale getForedragssal() {
        return foredragssal;
    }

    public void setForedragssal(Lokale foredragssal) {
        this.foredragssal = foredragssal;
    }

    public Lokale getKonsertsal() {
        return konsertsal;
    }

    public void setKonsertsal(Lokale konsertsal) {
        this.konsertsal = konsertsal;
    }

    public Lokale getTeatersal() {
        return teatersal;
    }

    public void setTeatersal(Lokale teatersal) {
        this.teatersal = teatersal;
    }

    public Lokale getKinosal() {
        return kinosal;
    }

    public void setKinosal(Lokale kinosal) {
        this.kinosal = kinosal;
    }

    protected AlleLokaler(){
        alleLokaler = FXCollections.observableArrayList();
        foredragssal = new Lokale(100,  1);
        konsertsal = new Lokale(400, 2);
        teatersal = new Lokale(100, 3);
        kinosal = new Lokale(100, 4);

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

