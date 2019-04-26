package org.openjfx.base;

import java.util.ArrayList;

public class AlleBilletter {

    ArrayList<Billett> alleBilletter = new ArrayList<>();

    //Metode for å få ut alle billettene i systemet
    public ArrayList<Billett> hentAlleBilletter(){
        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();
        for(Arrangement etArrangement : alleArrangementer.getArrangementer()){
            for(Billett enBillett : etArrangement.billetter){
                alleBilletter.add(enBillett);
            }
        }
       return alleBilletter;
    }
}

