package org.openjfx.base;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class LokalRegister {

    ArrayList<Lokale> lokaler = new ArrayList<>();

    public void leggTilLokaler(Lokale lokale) {
        lokaler.add(lokale);
    }

    public int antallPlasser(Lokale etLokale){
        return etLokale.getPlasser();
    }



}