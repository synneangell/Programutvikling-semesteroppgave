package org.openjfx.base;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LokalRegister {

    ArrangementRegister arrangementregister = new ArrangementRegister();

    Foredragssal foredragsal = new Foredragssal(100, arrangementregister.foredragsArrangementer, 1);
    Konsertsal konsertsal = new Konsertsal(400, arrangementregister.konsertArrangementer, 2);
    Teatersal teatersal = new Teatersal(100, arrangementregister.teaterArrangementer, 3);
    Kinosal kinosal = new Kinosal(100, arrangementregister.kinoArrangementer, 4);

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
    }

}