package org.openjfx.Filbehandling;

import javafx.collections.ObservableList;
import org.openjfx.base.Arrangement;
import org.openjfx.base.Billett;
import org.openjfx.controller.uihelpers.InvalidBillettFormatException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class LeseFraFil {

    public abstract ArrayList<Object> leseFraFil(String filsti) throws InvalidBillettFormatException, IOException;
}
