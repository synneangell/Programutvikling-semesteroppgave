package org.openjfx.Filbehandling;

import org.openjfx.controller.hjelpeklasser.InvalidBillettFormatException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class LeseFil {

    public abstract ArrayList<Object> leseFraFil(String filsti) throws InvalidBillettFormatException, IOException;
}
