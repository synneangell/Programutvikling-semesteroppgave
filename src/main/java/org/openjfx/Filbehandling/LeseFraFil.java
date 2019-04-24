package org.openjfx.Filbehandling;

import org.openjfx.base.Arrangement;
import org.openjfx.base.Billett;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;

import java.io.IOException;
import java.util.List;

public abstract class LeseFraFil {

    public abstract List<Billett> leseFraFil(String filsti) throws InvalidBillettFormatException, IOException;
    //public abstract List<Arrangement> leseFraFi
}
