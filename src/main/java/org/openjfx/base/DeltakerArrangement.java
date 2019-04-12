package org.openjfx.base;

import java.util.ArrayList;
        import java.util.Date;

public class DeltakerArrangement extends Arrangement {

    public DeltakerArrangement(Kontaktperson kontaktperson, String arrangementNavn, int billettpris, Dato dato, Klokkeslett klokkeslett, int antallBilletter, TypeArrangement typeArrangement) {
        super(kontaktperson, arrangementNavn, billettpris, dato, klokkeslett, antallBilletter, typeArrangement);
    }
}
