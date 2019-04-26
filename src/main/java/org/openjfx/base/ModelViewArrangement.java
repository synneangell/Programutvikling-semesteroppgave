package org.openjfx.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.Filbehandling.LeseDataFraJobjFil;

import static org.openjfx.base.LokalRegister.antallPlasser;
import static org.openjfx.base.LokalRegister.leggTilLokaler;

public class ModelViewArrangement {

    public ModelViewArrangement(){
        leggTilLokaler(foredragssal);
        leggTilLokaler(konsertsal);
        leggTilLokaler(teatersal);
        leggTilLokaler(kinosal);
    }

    public static ObservableList<Arrangement> getArrangementer(){
        // Oppretter en kontaktperson som er ansvarlig for kino- og teatervisninger
        Kontaktperson forestillingsAnsvarlig = new Kontaktperson("Aksel Ansvarlig", "22442314",
                "kontakt@kulturhuset.no", "kulturhuset.no", "Kulturhuset", "");


        //Oppretter noen forestillinger som skal ligge inne i systemet
        Arrangement kinofilm = new Arrangement
                (forestillingsAnsvarlig, "Pulp Fiction", 110, "22/03/2019", "18:30", 100, TypeArrangement.KINO);

        Arrangement kinofilm2 = new Arrangement
                (forestillingsAnsvarlig, "The Hateful Eight", 120, "22/03/2019", "18:30",100, TypeArrangement.KINO);

        Arrangement kinofilm3 = new Arrangement
                (forestillingsAnsvarlig, "Once Upon a Time in Hollywood", 150, "22/03/2019", "18:30", 100, TypeArrangement.KINO);


        // Oppretter teaterforestilling:
        Arrangement teaterforestilling = new Arrangement
                (forestillingsAnsvarlig, "Sweeney Todd", 200, "22/03/2019", "18:30", 100, TypeArrangement.TEATER);

        Arrangement teaterforestilling2 = new Arrangement
                (forestillingsAnsvarlig, "Cats", 220, "22/03/2019", "18:30", 100, TypeArrangement.TEATER);

        Arrangement teaterforestilling3 = new Arrangement
                (forestillingsAnsvarlig, "Les Miserables", 250, "22/03/2019", "18:30", 100, TypeArrangement.TEATER);


        //Oppretter her arraylisten som inneholder alle arrangementer
        ObservableList<Arrangement> arrangementer = FXCollections.observableArrayList();
        arrangementer.add(kinofilm);
        arrangementer.add(kinofilm2);
        arrangementer.add(kinofilm3);
        arrangementer.add(teaterforestilling);
        arrangementer.add(teaterforestilling2);
        arrangementer.add(teaterforestilling3);

        return arrangementer;
    }

    static Foredragssal foredragssal = new Foredragssal(100,  1);
    static Konsertsal konsertsal = new Konsertsal(400, 2);
    static Teatersal teatersal = new Teatersal(100, 3);
    static Kinosal kinosal = new Kinosal(100, 4);

    public static void leggArrangementerILokaler(){
        for(Arrangement etArrangement : getArrangementer()){
            if(etArrangement.typeArrangement == TypeArrangement.KINO){
                kinosal.leggTilArrangement(etArrangement);
            }
            if(etArrangement.typeArrangement == TypeArrangement.TEATER){
                teatersal.leggTilArrangement(etArrangement);
            }
            if(etArrangement.typeArrangement == TypeArrangement.KONSERT){
                konsertsal.leggTilArrangement(etArrangement);
            }
            if(etArrangement.typeArrangement == TypeArrangement.FOREDRAG){
                foredragssal.leggTilArrangement(etArrangement);
            }
        }
    }

    public static int antallPlasserKonsertsal(){
        return antallPlasser(konsertsal);
    }

    public static int antallPlasserForedragssal(){
        return antallPlasser(foredragssal);
    }



}
