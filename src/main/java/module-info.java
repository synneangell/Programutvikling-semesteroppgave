module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;

    opens org.openjfx.controller to javafx.fxml;
    exports org.openjfx.controller;

    opens org.openjfx.base to javafx.fxml;
    exports org.openjfx.base;

}