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
    }


    /*private String nyLinje = System.getProperty("Linje.separator");
    private OutputStreamWriter writer = null;
    private int nbrCols = 0;
    private int nbrRows = 0;*/

    /**
     * @param encoding encoding to use or null (=defualt)
     * Oppretter en CSV fil som man kan skrive data til
     * file - den filen man skriver data til
     */

    /*public void CSVSkriver(File file, String encoding) throws IOException {
        if (encoding == null){
            encoding = System.getProperty("file.encoding");
        }

        FileOutputStream fos = new FileOutputStream(file);
        writer = new OutputStreamWriter(fos, encoding);
    }

    public void SkriveHeader (String [] header) throws IOException {
        this.nbrCols = header.length;
        doWriteData(header);
    }


    public void skrivData(String [] data) throws IOException {
        doWriteData(data);
    }

    public void close() throws IOException {
        this.writer.close();
    }

    public void doWriteData(String[] values) throws IOException {
        for (int i = 0; i < values.length; i++){
            if (i > 0){
                this.writer.write(";");
            }

            if (values[i] != null){
                this.writer.write("\"");
                this.writer.write(this.toCsvValue(values[i]));
                this.writer.write("\"");
            }
        }
        this.writer.write(nyLinje);
        this.nbrRows++;
    }

    public String toCsvValue(String str) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            sb.append(c);

                switch(c){
                case '"':
                    sb.append('"');
                    break;
            }
        }

        return sb.toString();
    }


    private void lagreTilFil()  {

    }
    */
//}

    //new FileChooser().showSaveDialog(null);