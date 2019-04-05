package org.openjfx.base;


import java.util.ArrayList;

class Film {
    public String tittel;
    public int billettPris;

    public Film (String tittel, int billettPris) {
        this.tittel = tittel;
        this.billettPris = billettPris;
    }
}
public class KinoFilmer {
    public ArrayList<Film> register = new ArrayList<>();

    public KinoFilmer() {
        Film film1 = new Film("Pulp Fiction", 120);
        Film film2 = new Film("The Hateful Eight", 110);
        Film film3 = new Film("Kill Bill 1", 150);
        Film film4 = new Film("Kill Bill 2", 150);
        Film film5 = new Film("Kill Bill 3", 150);

        register.add(film1);
        register.add(film2);
        register.add(film3);
        register.add(film4);
        register.add(film5);
    }


}
