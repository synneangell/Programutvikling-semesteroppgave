package org.openjfx.base;

import java.util.ArrayList;

public class ArrangementRegister {

    ArrayList<Arrangement> arrangementer  = new ArrayList<>();


    private void registrerArrangement(Arrangement etArrangement){
        arrangementer.add(etArrangement);
    }

    private void visAlleArrangementer(){}

    //egne metoder for å vise arrangementer kun i kinosal/teatersal/foredragssal/konsertsal?
    private void visKinoArrangementer(){

    }

    //metoder for å slette/endre arrangementer?

}
