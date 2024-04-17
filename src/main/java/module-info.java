module com.example.wardrobemangementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.wardrobemanagementsystem to javafx.fxml;
    exports com.wardrobemanagementsystem;
    exports com.example;
    opens com.example to javafx.fxml;
    exports com.wardrobemanagementsystem.splash;
    opens com.wardrobemanagementsystem.splash to javafx.fxml;
}