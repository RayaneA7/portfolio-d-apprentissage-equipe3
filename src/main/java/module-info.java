module Mainapplication{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires transitive com.jfoenix;
    requires javafx.graphics;
    requires com.google.gson;


    opens Mainapplication  to javafx.fxml , javafx.graphics,com.google.gson;
    opens controleurs.authentification to javafx.fxml , javafx.graphics,com.google.gson;
    exports Mainapplication to javafx.graphics,javafx.fxml,com.google.gson ;
    exports controleurs.authentification to javafx.graphics,javafx.fxml,com.google.gson;
    exports controleurs.acceuil to javafx.fxml, javafx.graphics,com.google.gson;
    opens controleurs.acceuil to javafx.fxml, javafx.graphics,com.google.gson;
    exports controleurs.portfolio to javafx.fxml, javafx.graphics,com.google.gson;
    opens controleurs.portfolio to javafx.fxml, javafx.graphics,com.google.gson;
    exports modele to javafx.fxml, javafx.graphics,com.google.gson;
    opens modele to javafx.fxml, javafx.graphics,com.google.gson;
}