package com.example.projetgithub;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUp implements Initializable {
    @FXML
    JFXButton myButton ;
    @FXML
    Button myAide ;
    @FXML
    HBox myHbox ;
    private Parent root;
    private Stage stage;
    private Event event ;
    public void obtenirAide(ActionEvent actionEvent) {
       // myButton.setButtonType(JFXButton.ButtonType.RAISED);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventHandler<MouseEvent > event =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               myAide.setOpacity(1);
            }
        };
        myAide.setOnMouseClicked(event);
    }
    public void NextPage(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                // String css = this.getClass().getResource("styleCss1.css").toExternalForm();
                //scene.getStylesheets().add(css);
                stage.setScene(scene);
                stage.show();
                stage.setHeight(500);
                stage.setWidth(1000);
    }

    public void Colorate(ActionEvent actionEvent) {
    }

    public void PreviousPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUp.fxml" ));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        // String css = this.getClass().getResource("styleCss1.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        stage.setHeight(700);
        stage.setWidth(1000);
    }
}

