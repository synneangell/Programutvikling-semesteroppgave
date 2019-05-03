package org.openjfx.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class AlleArrangementer {

    private static AlleArrangementer instance;
    private ObservableList <Arrangement> alleArrangementer = null;


    protected AlleArrangementer(){
        alleArrangementer = FXCollections.observableArrayList();
    }

    public ObservableList<Arrangement> getArrangementer(){
        return alleArrangementer;
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

    public ArrayList<Arrangement> gjørOmTilArrayList(ObservableList <Arrangement> observableList){
        ArrayList<Arrangement> arrangementer = new ArrayList<>();
        for(Arrangement etArrangement : observableList){
            arrangementer.add(etArrangement);
        }
        return arrangementer;
    }

    public void gjørOmTilObservableList(ArrayList <Object> arrayList){
        for(Object etArrangement : arrayList){
            leggTilArrangement((Arrangement) etArrangement);
        }
    }

    public ArrayList <Billett> gjørOmBilletterTilArrayList(ObservableList <Billett> observableList){
        ArrayList <Billett> billetter = new ArrayList<>();
        for(Billett enBillett : observableList){
            billetter.add(enBillett);
        }
        return billetter;
    }

    public void LeggBillettFraFilTilArrangement(ArrayList<Object> billetter){
        AlleArrangementer alleArrangementer = AlleArrangementer.getSingelton();

        for(Arrangement etArrangement : alleArrangementer.getArrangementer()) {
            for(Object enBillett : billetter) {
                if(((Billett)enBillett).getArrangementNavn().equals(etArrangement.getArrangementNavn()) &&
                ((Billett)enBillett).getArrangementDato().equals(etArrangement.getDato()) &&
                (((Billett)enBillett).getArrangementKlokkeslett().equals(etArrangement.getKlokkeslett()))) {
                    etArrangement.leggTilBillettFraFil((Billett) enBillett);
                }
            }
        }
    }
}

