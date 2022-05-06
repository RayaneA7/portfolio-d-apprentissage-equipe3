module Mainapplication{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires transitive com.jfoenix;
    requires javafx.graphics;
    requires com.google.gson;
    requires org.bouncycastle.provider;


    opens Mainapplication  to javafx.fxml , javafx.graphics,com.google.gson;
    opens controleurs.authentification to javafx.fxml , javafx.graphics,com.google.gson;
    exports Mainapplication to javafx.graphics,javafx.fxml,com.google.gson ;
    exports controleurs.authentification to javafx.graphics,javafx.fxml,com.google.gson;
    exports controleurs.acceuil to javafx.fxml, javafx.graphics,com.google.gson;
    opens controleurs.acceuil to javafx.fxml, javafx.graphics,com.google.gson;
    exports models to javafx.fxml, javafx.graphics,com.google.gson;
    opens models to javafx.fxml, javafx.graphics,com.google.gson;
    exports References to javafx.fxml, javafx.graphics,com.google.gson;
    opens References to javafx.fxml, javafx.graphics,com.google.gson;
}