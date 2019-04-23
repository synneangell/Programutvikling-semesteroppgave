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


        public void skrivBillett(List<Billett> billetter, String path) throws IOException {
            PrintWriter writer = null;

            try {
                writer = new PrintWriter(path, "UTF-8");

                for (Billett enBillett : billetter) {
                    writer.println(enBillett);
                }
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }


            List<String> data = new ArrayList<>();

            billetter.forEach(p -> data.add(p.toString()));

            Path file = Paths.get(path);
            Files.write(file, data, Charset.forName("UTF-8"));
        }

    @Override
    public void skriveTilFil(String filsti, Object o) {


    }
}