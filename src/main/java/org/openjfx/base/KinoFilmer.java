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


    public String kjøpKinovisning(String navn, String telefonNr, String email, String tittel){
        // sjekk om filmen har visning
        String resultat = "";
        boolean funnet = false;
        for (Film enFilm : register){
            if(enFilm.tittel.equals(tittel)){
                // filmen funnet
                funnet=true;
                if(enFilm.tittel==null){
                    // den finnes
                    // opprett personobjekt og lenk det inn i filmen
                    Kjøper enKjøper = new Kjøper(navn, telefonNr, email);
                    enFilm.tittel = tittel;
                    resultat += "Film: " + tittel + "\n";
                    resultat += "Pris per billett er " + enFilm.billettPris + " kr";
                }
                else{
                    resultat += "Feil";
                }
            }
        }
        return resultat;
    }


}
