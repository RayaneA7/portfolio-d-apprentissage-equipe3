package com.example.projetgithub;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


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
    /*******************************/
    @FXML
    Line monLigneNom ;
    @FXML
    Line monLignePrenom ;
    @FXML
    Line monLigneMatricule ;
    /*****les Anchorpanes***************************/
    @FXML
    AnchorPane monAnchorpane ;
    @FXML
    AnchorPane monAnchorpane1 ;
    /*********les alerts************************************/
    @FXML
    Label erreurNom;
    @FXML
    Label erreurPrenom;
    @FXML
    Label erreurMatricule;
    @FXML
    Label erreurNiveauEtude ;
    @FXML
    Label erreurSexe ;
    @FXML
    Label erreurDateNaissance;
    @FXML
    TextField newNiveauEtude ;
    /********************/
    private Parent root;
    private Stage stage;
    private Event event ;
    private int ageMinimal=18;
    private int dureeErreur=3000;

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
                MenuItem item= monNiveauEtude.getItems().get(5);
                item.setOnAction(event32 -> {
                 monNiveauEtude.setText(newNiveauEtude.getText());
                });
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

        String typeB="-fx-stroke:#F1C53C ;-fx-stroke-width:3 ";
        String typeA="-fx-stroke:#666666 ;-fx-stroke-width:3 ";
        monAnchorpane.setOnMouseEntered(event4 -> {
            monNom.setOnMouseClicked(event5->{
                monLigneNom.setStyle(typeB);
                monLignePrenom.setStyle(typeA);
            });
            monPrenom.setOnMouseClicked(event6->{
                monLigneNom.setStyle(typeA);
                monLignePrenom.setStyle(typeB);
            });
        });
        monAnchorpane.setOnMouseExited(event4 -> {
            monLigneNom.setStyle(typeA);
            monLignePrenom.setStyle(typeA);
        });
        monAnchorpane1.setOnMouseEntered(event5-> monMatricule.setOnMouseClicked(event4-> monLigneMatricule.setStyle(typeB)));
        monAnchorpane1.setOnMouseExited(event4 -> monLigneMatricule.setStyle(typeA));
    }
     /***************************************************************************************/
    /***************************************************************************************/
    public int VerifierDate(){
        int result=0;
        if(monDateNaissance.getEditor().getText().length()!=0) {
            String word = monDateNaissance.getEditor().getText().substring(5);
            int yearNaissance = Integer.valueOf(word);
            // System.out.println("age naissance est "+yearNaissance);
            // DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            int yearActuel = now.getYear();
            System.out.println("actaul naissance est " + yearActuel);
            if ((yearActuel - yearNaissance) >= ageMinimal) {
                result = 1;
            }
        }
        else
        {
            TraiterAlert(erreurDateNaissance);
        }
      return result;
    }
    public int VerifierNom(){
        if(monNom.getText()=="")
        {
            TraiterAlert(erreurNom);
            return 0;
        }
        else
        {
          return 1 ;
        }
    }
    public int VerifierPreNom(){
        if(monPrenom.getText()=="")
            {
                TraiterAlert(erreurPrenom);
                return 0;
            }
            else
            {
                return 1 ;
        }
    }
    public int VerifierMatricule(){
        if(monMatricule.getText()=="")
        {
            TraiterAlert(erreurMatricule);
            return 0;
        }
        else
        {
            return 1 ;
        }
    }
    public int VerifierSexe(){
        if(monSexe.getText().equals("Sexe"))
        {
          TraiterAlert(erreurSexe);
          return 0;
        }
        else
        {
            return 1;
        }
    }
    public int VerifierNiveauEtude(){
        if(monNiveauEtude.getText().equals("Niveau d'étude"))
        {
            TraiterAlert(erreurNiveauEtude);
            return 0;
        }
        else
        {
            return 1;
        }
    }
    public void TraiterAlert(Node node)
    {
        Timer timer =new Timer();
        TimerTask task =new RealiserAlert(node, timer);
        node.setOpacity(1);
        timer.schedule(task,dureeErreur);
    }
    public void NextPage(ActionEvent event) throws IOException {
        //afficher();
        /**********************************/
        /***vérification de la validité de nom,prenom,matricule,date de naissance niveau d'étude*******/
        /*****************************/

        if(VerifierDate()+VerifierPreNom()+VerifierNom()+VerifierMatricule()+VerifierNiveauEtude()+VerifierSexe()==6)
        {
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
    }

    public void PreviousPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Connect.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setResizable(false);
        stage.show();
       // Connect.pagination.setCurrentPageIndex(Connect.pagination.getCurrentPageIndex()-1);
       // System.out.println("welcome in controller 0 return");
    }
}

