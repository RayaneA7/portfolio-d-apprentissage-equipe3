module com.example.projetgithub {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires transitive com.jfoenix;
    requires javafx.graphics;
    requires com.google.gson;


    opens com.example.projetgithub to javafx.fxml;
    exports com.example.projetgithub;
}
