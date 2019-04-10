package org.openjfx.base;

import java.util.ArrayList;

public class BillettRegister {

    int referansenummer = 0;
    ArrayList<Billett> alleBilletter = new ArrayList<>();

    //Metode som både registrerer billett og genererer et referansenummer på billetten
    public void registrerBillett(Billett enBillett){
        alleBilletter.add(enBillett);
        genererReferansenummer(enBillett);
    }

    //Metoden som genererer referansenummeret
    private void genererReferansenummer(Billett enBillett){
        enBillett.setReferansenummer(referansenummer++);
    }

	//metoder for å vise antallSolgte og antallLedige billetter for hvert arrangement? Kommer dette inn her?

}
