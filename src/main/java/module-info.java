module com.example.projetgithub {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires transitive com.jfoenix;
    // requires json.simple ;
    //requires json.simple;


    opens com.example.projetgithub to javafx.fxml;
    exports com.example.projetgithub;
}