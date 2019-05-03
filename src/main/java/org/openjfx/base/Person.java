package org.openjfx.base;

public class Person  {
    private String navn;

    public Person(){}

    public Person (String navn){
        this.navn = navn;
    }

    public String getNavn(){
        return navn;
    }
}
