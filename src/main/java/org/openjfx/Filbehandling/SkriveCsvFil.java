package org.openjfx.Filbehandling;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SkriveCsvFil extends SkriveFil {

    @Override
    public void skriveTilFil(String filsti, ArrayList<?> objekter) throws IOException {

        List<String> data = new ArrayList<>();

        objekter.forEach(p -> data.add(p.toString()));

        Path file = Paths.get(filsti);
        Files.write(file, data, Charset.forName("UTF-8"));
    }
}

