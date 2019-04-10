package org.openjfx.controller.uihelpers;
import javafx.beans.property.SimpleStringProperty;


public class TableView {

    public class Visninger {
                private final SimpleStringProperty visning = new SimpleStringProperty("");
                private final SimpleStringProperty klokkeslett = new SimpleStringProperty("");
                private final SimpleStringProperty dag = new SimpleStringProperty("");
                private final SimpleStringProperty dato = new SimpleStringProperty("");


        public Visninger() {
                    this("", "", "", "");
                }

        public Visninger(String visning, String klokkeslett, String dag, String dato) {
            setVisning(visning);
            setKlokkeslett(klokkeslett);
            setDag(dag);
            setDato(dato);
        }

        public String getVisning() {
            return visning.get();
        }

        public void setVisning(String visning1) {
            visning.set(visning1);
        }


        public String getKlokkeslett() {
            return klokkeslett.get();
        }

        public void setKlokkeslett(String klSlett) {
            klokkeslett.set(klSlett);
        }


        public String getDag() {
            return dag.get();
        }

        public void setDag(String dag1) {
            dag.set(dag1);
        }


        public String getDato() {
            return dato.get();
        }

        public void setDato(String dato1) {
            dato.set(dato1);
        }


    }
}