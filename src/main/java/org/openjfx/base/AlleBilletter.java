package org.openjfx.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class AlleBilletter {

    private static AlleBilletter instance;
    private ObservableList<Billett> alleBilletter = null;


    protected AlleBilletter(){
        alleBilletter = FXCollections.observableArrayList();

    }

    public ObservableList<Billett> getBilletter(){
        return alleBilletter;
    }


    public void gjørOmTilObservableList(ArrayList<Object> arrayList){
        for(Object enBillett : arrayList){
            leggTilBillett((Billett) enBillett);
        }
    }

    public static AlleBilletter getSingelton(){
        if(instance == null){
            instance = new AlleBilletter();
        }
        return instance;
    }


    public void leggTilBillett(Billett enBillett){
        alleBilletter.add(enBillett);
    }

    public Billett getArrangement(Billett enBillett){
        return enBillett;
    }

    public ArrayList<Billett> gjørOmBilletterTilArrayList(ObservableList<Billett> observableList){
        ArrayList<Billett> billetter = new ArrayList<>();
        for(Billett enBillett : observableList){
            billetter.add(enBillett);
        }
        return billetter;
    }



}

