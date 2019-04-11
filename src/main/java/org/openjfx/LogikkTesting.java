package org.openjfx;

import org.openjfx.Filbehandling.LeseDataFraJobjFil;
import org.openjfx.Filbehandling.SkriveTilJobjFil;
import org.openjfx.base.Arrangement;
import org.openjfx.base.Billett;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogikkTesting {
    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        String input = "2019-01-04 10:20";



        System.out.println(date);

    }
}
