package org.openjfx.base;

public class Person  {
    private String navn;


    public Person (String navn){
        this.navn = navn;
    }

    public String getNavn(){
        return navn;
    }

    public void setNavn(String navn){
        this.navn = navn;
    }
}
