package com.example.projetgithub;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Connect.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 568);
        stage.setTitle("Ecarrer");
        stage.setScene(scene);
            Image icon = new Image((getClass().getResourceAsStream("icons/ProjectName.png")));
        if(icon!=null)
        {
            System.out.printf("icon is not  null");
            stage.getIcons().add(icon);
        }
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}