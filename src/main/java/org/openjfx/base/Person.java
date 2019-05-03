package org.openjfx.base;

import java.io.Serializable;

public class Person implements Serializable {
    private String navn;

    public Person(){}

    public Person (String navn){
        this.navn = navn;
    }

    public String getNavn(){
        return navn;
    }
}
