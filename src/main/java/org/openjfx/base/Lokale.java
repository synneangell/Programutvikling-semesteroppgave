package org.openjfx.base;

import java.util.ArrayList;

public class Lokale {
    private int plasser;
    private int id;
    ArrayList <Arrangement> arrangementer;

    Lokale (int plasser, int id) {
        this.plasser = plasser;
        this.id = id;
        arrangementer = new ArrayList<>();
    }


    public void leggTilArrangement(Arrangement etArrangement){
        arrangementer.add(etArrangement);
    }

    public int getId() {
        return id;
    }

    public int getPlasser() {
        return plasser;
    }

    public ArrayList<Arrangement> hentArrangementer(){
        return arrangementer;
    }
}