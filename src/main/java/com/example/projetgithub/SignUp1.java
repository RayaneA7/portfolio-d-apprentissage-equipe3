package com.example.projetgithub;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUp1 implements Initializable {
    @FXML
    private TextField monEmail ;
    @FXML
    private PasswordField monMotdePasse ;
    @FXML
    private PasswordField monConfirmation ;
    @FXML
    private ImageView myHelp ;
    /********Ligne*******/
    @FXML
    private Line monLigne1;
    @FXML
    private Line monLigne2;
    @FXML
    private Line monLigne3;
    @FXML
    private Line monLigne4;
    @FXML
    private Line monLigne5;
    /***********************/
    private int NbChMinEmail = 5;
    private int NbChminPassword=12;
    private boolean validatePassword =false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /********************/
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
        /**************traitment des actions**********************/
        myHelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        /*************************************/
        String typeB="-fx-stroke:#19C62A ;-fx-stroke-width:4 ";
        String typeA="-fx-stroke:#EFEFEF ;-fx-stroke-width:4 ";
        EventHandler<KeyEvent> event2 = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int i=0;
                int index=0;
                int index1=0;
                int index2=0;
                int index3=0;
                Character ch=' ';
                while (i<monMotdePasse.getText().length()) {
                    ch = monMotdePasse.getText().charAt(i);
                    if (Character.isUpperCase(ch)) {
                        index = 1;
                    }
                    if (Character.isLowerCase(ch)) {
                        index1=1;
                    }
                    if (Character.isDigit(ch)) {
                        index2 = 1;
                    }
                    if(Character.isLetterOrDigit(ch)==false){
                        index3=1;
                    }
                    i++;
                }
               // System.out.println("le nombre des caractéres est :"+monMotdePasse.getText().length());
                int index4=0;
                if(monMotdePasse.getText().length()>=NbChminPassword)
                { index4=1;}
                int totalIndex=index+index1+index2+index3+index4;
                switch (totalIndex)
                {
                    case 0:
                        monLigne1.setStyle(typeA);
                        monLigne2.setStyle(typeA);
                        monLigne3.setStyle(typeA);
                        monLigne4.setStyle(typeA);
                        monLigne5.setStyle(typeA);
                        break;

                    case 1:
                        monLigne1.setStyle(typeB);
                        monLigne2.setStyle(typeA);
                        monLigne3.setStyle(typeA);
                        monLigne4.setStyle(typeA);
                        monLigne5.setStyle(typeA);
                        break;
                    case 2:
                        monLigne1.setStyle(typeB);
                        monLigne2.setStyle(typeB);
                        monLigne3.setStyle(typeA);
                        monLigne4.setStyle(typeA);
                        monLigne5.setStyle(typeA);
                        break;
                    case 3:
                        monLigne1.setStyle(typeB);
                        monLigne2.setStyle(typeB);
                        monLigne3.setStyle(typeB);
                        monLigne4.setStyle(typeA);
                        monLigne5.setStyle(typeA);
                        break;
                    case 4:
                        monLigne1.setStyle(typeB);
                        monLigne2.setStyle(typeB);
                        monLigne3.setStyle(typeB);
                        monLigne4.setStyle(typeB);
                        monLigne5.setStyle(typeA);
                        break;
                    case 5:
                        monLigne1.setStyle(typeB);
                        monLigne2.setStyle(typeB);
                        monLigne3.setStyle(typeB);
                        monLigne4.setStyle(typeB);
                        monLigne5.setStyle(typeB);
                        validatePassword=true;
                        break;
                }

            }
        };
        monMotdePasse.setOnKeyPressed(event2);
    }
 /******************************************************************/
    public void PreviousPage(ActionEvent actionEvent) {
        System.out.println("welcome in controller 1 back");
        Connect.pagination.setCurrentPageIndex(Connect.pagination.getCurrentPageIndex()-1);
    }
    public void afficher(){
        System.out.println("Nom :"+Connect.user.donnes.getNom());
        System.out.println("Prenom :"+Connect.user.donnes.getPrenom());
        System.out.println("date de naissance :"+Connect.user.donnes.getDatenaissance());
        System.out.println("Niveau d'étude :"+Connect.user.donnes.getNiveauEtude());
        System.out.println("Sexe :"+Connect.user.donnes.getSex());
        System.out.println("matricule :"+Connect.user.donnes.getMatricule());
        System.out.println("Email :"+Connect.user.donnes.getEmail());
        System.out.println("mot de passe :"+Connect.user.donnes.getMotdePasse());
        System.out.println("/**************************************************************/");
    }
    public void NextPage(ActionEvent actionEvent) {

        if(validatePassword==true&&verifyEmail(monEmail.getText())==true&&monMotdePasse.getText().equals(monConfirmation.getText())) {
            Connect.user.donnes.setEmail(monEmail.getText());
            Connect.user.donnes.setMotdePasse(monMotdePasse.getText());
            afficher();
            Connect.pagination.setCurrentPageIndex(Connect.pagination.getCurrentPageIndex() + 1);
        }
        else
        {

        }
    }
    public boolean verifyEmail(String mail) {
        char ch = ' ';
        int NbChar = 0;
        while (ch != '@'&& NbChar <mail.length()) {
            ch = mail.charAt(NbChar);
            NbChar++;
        }

        if (((NbChar - 1) >= NbChMinEmail)&&verifyEmailSyntax(mail)==true) {
            return true;
        }
        else
        {return false;}
      /*  } else if((NbChar-1)<NbChMinEmail) {
            /*Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Email Length problem");
            alert.setContentText("Email address have to composed at least of 8C Characters");
            alert.setWidth(300);
            alert.show();
            return false;
        }
        else{
            Alert alert1=new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Syntax Error");
            alert1.setContentText("Please verify your address syntax");
            alert1.show();
            return false;
        }*/
    }
    public boolean verifyEmailSyntax(String info){
        int i=0;
        int index=0;
        int index1=0;
        int index2=0;
        int index3=0;
        Character ch=info.charAt(i);
        while (ch!='@') {
            if (Character.isUpperCase(ch)) {
                index = 1;
            }
            if (Character.isLowerCase(ch)) {
                index1=1;
            }
            if (Character.isDigit(ch)) {
                index2=1;
            }
            i++;
            ch = info.charAt(i);
        }
        int index4=0;
        if(info.endsWith("@gmail.com")||info.endsWith("@esi.dz")||info.endsWith("@outlook.com")||info.endsWith("@yahoo.com")){index4=1;}
        int totalIndex= index4+index1+index2+index;
        if(totalIndex>=2)
        {
            return true;
        }
        else{
            return false;
        }
    }
}
