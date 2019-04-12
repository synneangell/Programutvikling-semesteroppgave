package org.openjfx.base;

import javafx.beans.property.SimpleIntegerProperty;

public class Dato {
    private SimpleIntegerProperty dag, måned, år;

    public Dato (int dag, int måned, int år) {
        this.dag = new SimpleIntegerProperty (dag);
        this.måned = new SimpleIntegerProperty (måned);
        this.år = new SimpleIntegerProperty (år);
    }

    public int getDag() {
        return dag.get();
    }

    public SimpleIntegerProperty dagProperty() {
        return dag;
    }

    public void setDag(int dag) {
        this.dag.set(dag);
    }

    public int getMåned() {
        return måned.get();
    }

    public SimpleIntegerProperty månedProperty() {
        return måned;
    }

    public void setMåned(int måned) {
        this.måned.set(måned);
    }

    public int getÅr() {
        return år.get();
    }

    public SimpleIntegerProperty årProperty() {
        return år;
    }

    public void setÅr(int år) {
        this.år.set(år);
    }


    public String toString() {
        String utDato = dag + "."+måned+ "." + år; // Format: dd.mmmmm.YYYY (dag.måned.årstall)
        return utDato;
    }
}
