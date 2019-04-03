package org.openjfx.base;

import java.util.ArrayList;
import java.util.Date;

public class DeltakerArrangement extends Arrangement {

    ArrayList<Deltaker> deltakereArrangement = new ArrayList<>();

    public DeltakerArrangement(Kontaktperson kontaktperson, String arrangementNavn, int billettpris, Date tidspunkt) {
        super(kontaktperson, arrangementNavn, billettpris, tidspunkt);
    }
}
