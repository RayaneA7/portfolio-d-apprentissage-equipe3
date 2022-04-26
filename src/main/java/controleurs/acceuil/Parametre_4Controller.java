package controleurs.acceuil;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        info_Button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ligne_info.setStyle(typeA);
                ligne_info.setVisible(true);
                ligne_contact.setVisible(false);
                ligne_adress.setVisible(false);
                ligne_passe.setVisible(false);

            }
        });
        passe_Button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ligne_info.setVisible(false);
                ligne_contact.setVisible(false);
                ligne_adress.setVisible(false);
                ligne_passe.setStyle(typeA);
                ligne_passe.setVisible(true);

            }
        });
        Adress_Button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ligne_info.setVisible(false);
                ligne_contact.setVisible(false);
                ligne_adress.setStyle(typeA);
                ligne_adress.setVisible(true);

                ligne_passe.setVisible(false);
            }
        });
        contact_Button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ligne_info.setVisible(false);
                ligne_contact.setStyle(typeA);
                ligne_contact.setVisible(true);

                ligne_adress.setVisible(false);
                ligne_passe.setVisible(false);
            }
        });
        info_Button.setOnAction(e ->{
            try {
                SwitchScene(e);} catch (IOException ex){
                ex.printStackTrace();} });
        passe_Button.setOnAction(e ->{
            try {
                SwitchScene2(e);} catch (IOException ex){
                ex.printStackTrace();} });
        Adress_Button.setOnAction(e ->{
            try {
                SwitchScene3(e);} catch (IOException ex){
                ex.printStackTrace();} });
        contact_Button.setOnAction(e ->{
            try {
                SwitchScene4(e);} catch (IOException ex){
                ex.printStackTrace();} });


    }
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
}
