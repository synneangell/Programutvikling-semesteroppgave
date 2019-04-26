package org.openjfx;

import org.openjfx.Filbehandling.*;
import org.openjfx.base.*;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;

import java.io.IOException;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) throws IOException, InvalidBillettFormatException {

        Kontaktperson forestillingsAnsvarlig = new Kontaktperson("Aksel Ansvarlig", "22442314",
                "kontakt@kulturhuset.no", "kulturhuset.no", "Kulturhuset", "");


        //Oppretter noen forestillinger som skal ligge inne i systemet
        Arrangement kinofilm = new Arrangement
                (forestillingsAnsvarlig, "Pulp Fiction", 110, "22/03/2019", "18:30", 100, TypeArrangement.KINO);


        ArrayList <Arrangement> arrangementer = new ArrayList<>();
        arrangementer.add(kinofilm);

        /*
        SkriveTilCsvFil skriveTilCsvFil = new SkriveTilCsvFil();
        skriveTilCsvFil.skriveTilFil("arrangement.csv", arrangementer);

        LesArrangementFraCsvFil lesArrangementFraCsvFil = new LesArrangementFraCsvFil();
        System.out.println(lesArrangementFraCsvFil.leseFraFil("arrangement.csv"));

        */

        SkriveTilJobjFil skriveTilJobjFil = new SkriveTilJobjFil();
        skriveTilJobjFil.skriveTilFil("arrangement.jobj", arrangementer);

        LeseDataFraJobjFil leseDataFraJobjFil = new LeseDataFraJobjFil();
        System.out.println(leseDataFraJobjFil.leseFraFil("arrangement.jobj"));



    }

}
