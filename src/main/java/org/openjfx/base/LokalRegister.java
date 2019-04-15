package org.openjfx.base;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class LokalRegister {

    static ArrayList<Lokale> lokaler = new ArrayList<>();

    public static void leggTilLokaler(Lokale lokale) {
        lokaler.add(lokale);
    }

    public static int antallPlasser(Lokale etLokale){
        return etLokale.getPlasser();
    }



}