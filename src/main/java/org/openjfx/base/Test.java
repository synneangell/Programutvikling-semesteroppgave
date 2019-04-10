package org.openjfx.base;

import java.util.Date;

public class Test {

    Date dato1 = new Date (2019,10,3);
    Kontaktperson forestillingsAnsvarlig = new Kontaktperson("Aksel Ansvarlig", "22442314", "kontakt@kulturhuset.no", "kulturhuset.no", "Kulturhuset", "");
    ForestillingsArrangement kinofilm1 = new ForestillingsArrangement(forestillingsAnsvarlig,"Pulp fiction", 299, dato1, 100);
    LokalRegister lokalRegister = new LokalRegister();

    public void leggTilFilmer() {
        lokalRegister.kinoArrangementer.add(kinofilm1);
    }
}
