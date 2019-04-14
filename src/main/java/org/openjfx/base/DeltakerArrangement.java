package org.openjfx.base;

import java.io.Serializable;

public class DeltakerArrangement extends Arrangement implements Serializable {
    private Deltaker deltaker;

    public DeltakerArrangement(Kontaktperson kontaktperson, Deltaker deltaker, String arrangementNavn, int billettpris, String dato, String klokkeslett, int antallBilletter, TypeArrangement typeArrangement) {
        super(kontaktperson, arrangementNavn, billettpris, dato, klokkeslett, antallBilletter, typeArrangement);
        this.deltaker = deltaker;
    }
}
