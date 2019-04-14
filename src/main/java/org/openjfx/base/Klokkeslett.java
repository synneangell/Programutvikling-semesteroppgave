package org.openjfx.base;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class Klokkeslett implements Serializable {
    private String klokkeslett;

    public Klokkeslett (String klokkeslett) {
        this.klokkeslett = klokkeslett;
    }

    public String getKlokkeslett() {
        return klokkeslett;
    }

    public void setKlokkeslett(String klokkeslett) {
        this.klokkeslett = klokkeslett;
    }

}