package com.example.projetgithub;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class SignUp2 implements Initializable {
    @FXML
    private TextField monNumeroTelephone;
    @FXML
    private TextField monFacebook;
    @FXML
    private TextField monGithub;
    @FXML
    private TextField monLinkedln;
    @FXML
    private ImageView myHelp ;

    public void PreviousPage(ActionEvent actionEvent) {
        Connect.pagination.setCurrentPageIndex(Connect.pagination.getCurrentPageIndex() - 1);
    }
    public void ValiderUrl(TextField text){

    }
    public void NextPage(ActionEvent actionEvent) {
        Connect.user.contacts.setCountFacebook(monFacebook.getText());
        Connect.user.contacts.setCountGithub(monGithub.getText());
        Connect.user.contacts.setCountLinkedln(monLinkedln.getText());
        Connect.user.contacts.setNbTelephone(Long.parseLong(monNumeroTelephone.getText()));
        System.out.println(monFacebook.getText());
        System.out.println(monGithub.getText());
        System.out.println(monLinkedln.getText());
        System.out.println(monNumeroTelephone.getText());
        /******Serialisation******/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventHandler<MouseEvent> event =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myHelp.setOpacity(1);
            }
        };
        myHelp.setOnMouseEntered(event);
        EventHandler<MouseEvent > event1 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                myHelp.setOpacity(0.5);
            }
        };
        myHelp.setOnMouseExited(event1);
        myHelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }
}
