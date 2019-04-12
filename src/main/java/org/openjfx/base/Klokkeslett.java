package org.openjfx.base;

import javafx.beans.property.SimpleIntegerProperty;

public class Klokkeslett {
    private SimpleIntegerProperty minutt, time;

    private Klokkeslett (int minutt, int time) {
        this.minutt = new SimpleIntegerProperty (minutt);
        this.time = new SimpleIntegerProperty (time);
    }

    public int getMinutt() {
        return minutt.get();
    }

    public SimpleIntegerProperty minuttProperty() {
        return minutt;
    }

    public void setMinutt(int minutt) {
        this.minutt.set(minutt);
    }

    public int getTime() {
        return time.get();
    }

    public SimpleIntegerProperty timeProperty() {
        return time;
    }

    public void setTime(int time) {
        this.time.set(time);
    }

    public String toString () {
        String utKlokkeslett = minutt + ":" + time; // format: mm:tt
        return utKlokkeslett;
    }
}