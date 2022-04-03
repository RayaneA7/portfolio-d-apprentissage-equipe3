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
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class SignUp implements Initializable {
    @FXML
    TextField monNom;
    @FXML
    TextField monPrenom;
    @FXML
    MenuButton monSexe ;
    @FXML
    DatePicker monDateNaissance;
    @FXML
    MenuButton monNiveauEtude;
    @FXML
    TextField monMatricule;
    @FXML
    ImageView myHelp ;
    /********************/
    private Parent root;
    private Stage stage;
    private Event event ;
    int ageMinimal=18;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EventHandler<MouseEvent > event =new EventHandler<MouseEvent>() {
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
        /*************traitement des actions*****************/
        myHelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        /**********************************************/
        EventHandler<MouseEvent> event2 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(int i=0;i<3;i++)
                {
                    MenuItem item= monNiveauEtude.getItems().get(i);
                    item.setOnAction(new EventHandler<>() {
                        @Override
                        public void handle(ActionEvent event) {
                         monNiveauEtude.setText(item.getText());
                        }
                    });
                }
                Menu menu = (Menu) monNiveauEtude.getItems().get(3);
                for(int i=0;i<menu.getItems().size();i++)
                {
                   MenuItem item =menu.getItems().get(i);
                    item.setOnAction(new EventHandler<>() {
                        @Override
                        public void handle(ActionEvent event) {
                            monNiveauEtude.setText(item.getText());
                        }
                    });
                }
                Menu menu1 = (Menu) monNiveauEtude.getItems().get(4);
                for(int i=0;i<menu1.getItems().size();i++)
                {
                    MenuItem item =menu1.getItems().get(i);
                    item.setOnAction(new EventHandler<>() {
                        @Override
                        public void handle(ActionEvent event) {
                            monNiveauEtude.setText(item.getText());
                        }
                    });
                }
            }
        };
        monNiveauEtude.setOnMouseClicked(event2);
        /****************************/
        EventHandler<MouseEvent> event3 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(int i=0;i<monSexe.getItems().size();i++)
                {
                    MenuItem item= monSexe.getItems().get(i);
                    item.setOnAction(new EventHandler<>() {
                        @Override
                        public void handle(ActionEvent event) {
                            monSexe.setText(item.getText());
                        }
                    });
                }
            }
        };
        monSexe.setOnMouseClicked(event3);
    }

    /**************************************************************************/
    public boolean VerifierDate(){
        boolean result=false;
        if(monDateNaissance.getEditor().getText().length()!=0) {
            String word = monDateNaissance.getEditor().getText().substring(5);
            int yearNaissance = Integer.valueOf(word);
            // System.out.println("age naissance est "+yearNaissance);
            // DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            int yearActuel = now.getYear();
            System.out.println("actaul naissance est " + yearActuel);
            if ((yearActuel - yearNaissance) >= ageMinimal) {
                result = true;
            }
            System.out.println(result);
        }
      return result;
    }
    /****************/

    public void NextPage(ActionEvent event) throws IOException {
        //afficher();
        /**********************************/
        /***vérification de la validité de nom,prenom,matricule,date de naissance niveau d'étude*******/
        /*****************************/
        if(monPrenom.getText()==""||monNom.getText()==""||monMatricule.getText()==""||VerifierDate()==false||monNiveauEtude.getText().equals("Niveau d'étude"))
        {
            Tooltip tip =new Tooltip();
            tip.setText("ce champ ne doit pas étre vide");
            tip.setShowDuration(Duration.seconds(5));
            tip.setHideDelay(Duration.seconds(0));
            monNom.setTooltip(tip);
            System.out.println("ce champ ne doit pas étre vide");
        }
        else {
            Connect.user.donnes.setPrenom(monPrenom.getText());
            Connect.user.donnes.setNom(monNom.getText());
            Connect.user.donnes.setMatricule(monMatricule.getText());
            Sex sex ;
            if(monSexe.getText().equalsIgnoreCase("Male"))
            {
                sex=Sex.MALE;
            }
            else{
                sex= Sex.FEMELLE;
            }
            Connect.user.donnes.setSex(sex);
            Connect.user.donnes.setDatenaissance(monDateNaissance.getEditor().getText());
            Connect.user.donnes.setNiveauEtude(monNiveauEtude.getText());
            Connect.pagination.setCurrentPageIndex(Connect.pagination.getCurrentPageIndex()+1);
        }
        //System.out.println(monNom.getText());
        //Connect.user.donnes.setPrenom(monPrenom.getText());
        //Connect.user.donnes.setNom(monNom.getText());
    }

    public void PreviousPage(ActionEvent event) throws IOException {
        Connect.pagination.setCurrentPageIndex(Connect.pagination.getCurrentPageIndex()-1);
       // System.out.println("welcome in controller 0 return");
    }
}

