package org.openjfx.Filbehandling;

import org.openjfx.controller.uihelpers.InvalidBillettFormatException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class LeseFil {

    public abstract ArrayList<?> leseFraFil(String filsti) throws InvalidBillettFormatException, IOException;
}
