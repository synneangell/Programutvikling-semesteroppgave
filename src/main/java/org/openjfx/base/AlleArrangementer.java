package org.openjfx.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class AlleArrangementer {

    private static AlleArrangementer instance;
    private ObservableList<Arrangement> alleArrangementer = null;


    protected AlleArrangementer(){
        alleArrangementer = FXCollections.observableArrayList();


        //TODO: fjerne disse før levering!
        Kontaktperson forestillingsAnsvarlig = new Kontaktperson("Aksel Ansvarlig", "22442314",
                "kontakt@kulturhuset.no", "kulturhuset.no", "Kulturhuset", "");


        //Oppretter noen forestillinger som skal ligge inne i systemet
        Arrangement kinofilm = new Arrangement
                (forestillingsAnsvarlig, "Pulp Fiction", 110, "22/03/2019",
                        "18:30", 100, TypeArrangement.KINO);

        Arrangement kinofilm2 = new Arrangement
                (forestillingsAnsvarlig, "The Hateful Eight", 120, "24/03/2019",
                        "18:30",100, TypeArrangement.KINO);

        Arrangement kinofilm3 = new Arrangement
                (forestillingsAnsvarlig, "Once Upon a Time in Hollywood", 150, "22/03/2019",
                        "20:30", 100, TypeArrangement.KINO);


        // Oppretter teaterforestilling:
        Arrangement teaterforestilling = new Arrangement
                (forestillingsAnsvarlig, "Sweeney Todd", 200, "25/03/2019",
                        "18:30", 100, TypeArrangement.TEATER);

        Arrangement teaterforestilling2 = new Arrangement
                (forestillingsAnsvarlig, "Cats", 220, "26/03/2019",
                        "18:30", 100, TypeArrangement.TEATER);

        Arrangement teaterforestilling3 = new Arrangement
                (forestillingsAnsvarlig, "Les Miserables", 250, "27/03/2019",
                        "18:30", 100, TypeArrangement.TEATER);

        alleArrangementer.add(kinofilm);
        alleArrangementer.add(kinofilm2);
        alleArrangementer.add(kinofilm3);
        alleArrangementer.add(teaterforestilling);
        alleArrangementer.add(teaterforestilling2);
        alleArrangementer.add(teaterforestilling3);
    }

    public ObservableList<Arrangement> getArrangementer(){
        return alleArrangementer;
    }

    public ArrayList<Arrangement> gjørOmTilArrayList(ObservableList<Arrangement> observableList){
        ArrayList<Arrangement> arrangementer = new ArrayList<>();
        for(Arrangement etArrangement : observableList){
            arrangementer.add(etArrangement);
        }
        return arrangementer;
    }

    public void gjørOmTilObservableList(ArrayList<Object> arrayList){
        for(Object etArrangement : arrayList){
            leggTilArrangement((Arrangement) etArrangement);
        }
    }

    public static AlleArrangementer getSingelton(){
        if(instance == null){
            instance = new AlleArrangementer();
        }
        return instance;
    }

    public void leggTilArrangement(Arrangement etArrangement){
            alleArrangementer.add(etArrangement);
    }

    public Arrangement getArrangement(Arrangement etArrangement){
        return etArrangement;
    }

    public ArrayList<Billett> gjørOmBilletterTilArrayList(ObservableList<Billett> observableList){
        ArrayList<Billett> billetter = new ArrayList<>();
        for(Billett enBillett : observableList){
            billetter.add(enBillett);
        }
        return billetter;
    }
}

