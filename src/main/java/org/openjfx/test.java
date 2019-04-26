package org.openjfx;

import org.openjfx.Filbehandling.LesBillettFraCsvFil;
import org.openjfx.Filbehandling.LeseFraFil;
import org.openjfx.Filbehandling.SkriveTilCsvFil;
import org.openjfx.Filbehandling.SkriveTilFil;
import org.openjfx.base.*;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;

import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException, InvalidBillettFormatException {
        Kjøper kjøper = new Kjøper("Nikola","12345678","test@test.no");
        Billett billett = new Billett(kjøper);
        SkriveTilCsvFil skriveTilCsvFil = new SkriveTilCsvFil();
        skriveTilCsvFil.skriveTilFil("kvittering.csv", billett);
        System.out.println("Hei");
    }
}
