package controleurs.parametre;

import controleurs.acceuil.AccueilMediateur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import models.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Parametre_4Controller implements Initializable {
    @FXML
    Line ligne_info;
    @FXML
    Line ligne_passe;
    @FXML
    Line ligne_adress;
    @FXML
    Line ligne_contact;
    //---------------------------------
    @FXML
    Button info_Button;
    @FXML
    Button passe_Button;
    @FXML
    Button Adress_Button;
    @FXML
    Button contact_Button;
    String typeA="-fx-stroke:#305380 ;-fx-stroke-width:3";
    @FXML
    TextField studentPhone;
    @FXML
    TextField studentFB;
    @FXML
    TextField studentGithub;
    @FXML
    TextField studentLinkedIn;

    Utilisateur user;
    String studentFolder;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        info_Button.setOnMouseClicked(e -> {
            AccueilMediateur.monPagination.setCurrentPageIndex(2);
        });
        passe_Button.setOnMouseClicked(e -> {
            AccueilMediateur.monPagination.setCurrentPageIndex(3);
        });
        Adress_Button.setOnMouseClicked(e -> {
            AccueilMediateur.monPagination.setCurrentPageIndex(4);
        });
        /*************************************
        //try {
        studentPhone.setPromptText(
              // String.valueOf(Utilisateur.deserialization(studentFolder).getContacts().getNbTelephone()));
           "Phone null");
        //  } catch (IOException e) {
        //     e.printStackTrace();
        //  }
        //try {
        studentFB.setPromptText(
              // Utilisateur.deserialization(studentFolder).getContacts().getCountFacebook());
                "FB null");
        //  } catch (IOException e) {
        //     e.printStackTrace();
        //  }
        //try {
        studentGithub.setPromptText(
              //  Utilisateur.deserialization(studentFolder).getContacts().getCountGithub());
                "Github null");
        //  } catch (IOException e) {
        //     e.printStackTrace();
        //  }
      //  try {

        studentLinkedIn.setPromptText(
                //Utilisateur.deserialization(studentFolder).getContacts().getCountLinkedln() );
                 "LinkedIn null");
        //} catch (IOException ioException) {
        //    ioException.printStackTrace();
       // }
        // "LinkedIn null");



    }
    /*********
    public void SwitchScene (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Parametre_1View.fxml"));
        Stage stage = (Stage)info_Button.getScene().getWindow();
        stage.setScene(new Scene(root,850,600));
    }
    public void SwitchScene2 (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Parametre_2View.fxml"));
        Stage stage = (Stage)passe_Button.getScene().getWindow();
        stage.setScene(new Scene(root,850,600));
    }
    public void SwitchScene3 (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Parametre_3View.fxml"));
        Stage stage = (Stage)Adress_Button.getScene().getWindow();
        stage.setScene(new Scene(root,850,600));
    }
    public void SwitchScene4 (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Paarametre_4.fxml"));
        Stage stage = (Stage)contact_Button.getScene().getWindow();
        stage.setScene(new Scene(root,850,600));
    }
     /*******************/
 }
}
