package org.openjfx.Filbehandling;

import org.openjfx.base.Billett;

import java.io.IOException;
import java.util.*;

public abstract class SkriveTilFil {

    public abstract void skriveTilFil(String filsti, Object o) throws IOException;

}
