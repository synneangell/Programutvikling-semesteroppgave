package org.openjfx.base;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class Dato implements Serializable {
    private String dato;

    public Dato (String dato) {
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

}
