package org.openjfx.Filbehandling;

import org.openjfx.base.Billett;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SkriveTilCsvFil extends SkriveTilFil {

        @Override
        public void skrivTilFil(String path, Object o) throws IOException {
            List<String> data = new ArrayList<>();

            people.forEach(p -> data.add(p.toString()));

            Path file = Paths.get(path);
            Files.write(file, data, Charset.forName("UTF-8"));

        }
}
