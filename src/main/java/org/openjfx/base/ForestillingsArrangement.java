package org.openjfx.base;

import java.io.Serializable;

public class ForestillingsArrangement extends Arrangement implements Serializable {

    public ForestillingsArrangement(Kontaktperson kontaktperson, String arrangementNavn, int billettpris, String dato, String klokkeslett, int antallBilletter, TypeArrangement typeArrangement) {
        super(kontaktperson, arrangementNavn, billettpris, dato, klokkeslett, antallBilletter, typeArrangement);
    }
}
