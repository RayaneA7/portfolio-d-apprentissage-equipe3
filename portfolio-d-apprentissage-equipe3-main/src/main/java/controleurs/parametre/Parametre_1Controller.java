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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Parametre_1Controller implements Initializable {
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
    @FXML
    Button AccueilButton;
    @FXML
    Label AccueilLabel;
    @FXML
    Button ProjetButton;
    @FXML
    Label ProjetLabel;
    @FXML
    Button PortfolioButton;
    @FXML
    Button AideButton;
    @FXML
    Label AideLabel;
    @FXML
    Label PortfolioLabel;
    @FXML
    Button ParametresButton;
    @FXML
    Label ParametresLabel;
    /****************** ImageViews *************************/
    @FXML
    ImageView AccueilImage;
    @FXML
    ImageView ProjetsImage;
    @FXML
    ImageView PortfolioImage;
    @FXML
    ImageView ParametresIamge;
    @FXML
    ImageView AideImage;
    @FXML
    ImageView logOut ;
    @FXML
    Circle imagePersonnel ;
    @FXML
    ImageView imageTest;
    /*******************les lignes **********************/
    @FXML
    Line line1;
    @FXML
    Line line2;
    @FXML
    Line line3;
    @FXML
    Line line4;
    @FXML
    Line line5;
    /****************************************************************/

    String typeA="-fx-stroke:#305380 ;-fx-stroke-width:3";
    @FXML
    TextField studentNom;
    @FXML
    TextField studentPrenom;
    @FXML
    TextField studentBio;
    Utilisateur user;
    String studentFolder;
    Image AccueilImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/AccueilBut.png"));
    Image AccueilImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/AccueilBut1.png"));
    Image PortfolioImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/PortfolioBut.png"));
    Image PortfolioImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/PortfolioBut1.png"));
    Image ProjetImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/ProjetsBut.png"));
    Image ProjetImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/ProjetsBut1.png"));
    Image ParametresImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/ParametresBut.png"));
    Image ParametresImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/ParametresBut1.png"));
    Image AideImg = new Image(getClass().getResourceAsStream("/icons/Acceuil/AideBut.png"));
    Image AideImg1 = new Image(getClass().getResourceAsStream("/icons/Acceuil/AideBut1.png"));
    Stage stage ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************Image personnel*******************/
        if(AccueilMediateur.image!=null){
            imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));
        }
        /*****************************************/
        studentBio.setText(AccueilMediateur.utilisateur.donnes.getBioPersonnel());
        studentNom.setText(AccueilMediateur.utilisateur.donnes.getNom());
        studentPrenom.setText(AccueilMediateur.utilisateur.donnes.getPrenom());
        /***************************/
        passe_Button.setOnMouseClicked(e -> {
        AccueilMediateur.monPagination.setCurrentPageIndex(3);
        });
        Adress_Button.setOnMouseClicked(e -> {

            AccueilMediateur.monPagination.setCurrentPageIndex(4);
        });
        contact_Button.setOnMouseClicked(e ->{

            AccueilMediateur.monPagination.setCurrentPageIndex(5);
        });

       // try {
        studentNom.setPromptText(
                    //Utilisateur.deserialization(studentFolder).getDonnes().getNom()
                    "nom null");
         //  } catch (IOException e) {
          //     e.printStackTrace();
          //  }
        // try {
        studentPrenom.setPromptText(
                //Utilisateur.deserialization(studentFolder).getDonnes().getPrenom()
                "prenom null");
        //  } catch (IOException e) {
        //     e.printStackTrace();
        //  }
        studentBio.setPromptText("Bio null");
        //  } catch (IOException e) {
        //     e.printStackTrace();
        // }
        AccueilButton.setOnMouseClicked(e->{
            AccueilMediateur.monPagination.setCurrentPageIndex(0);
        });
     /***********
        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilLabel.setTextFill(Color.WHITE);
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });
        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilLabel.setTextFill(Color.BLACK);
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #b7b5b5");
        });

        ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetLabel.setTextFill(Color.WHITE);
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");

        });

        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetLabel.setTextFill(Color.BLACK);
            ProjetsImage.setImage(ProjetImg);
            line2.setStyle("-fx-stroke: #b7b5b5");
        });

        PortfolioButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: #f1c53c");
            PortfolioLabel.setTextFill(Color.WHITE);
            PortfolioImage.setImage(PortfolioImg1);
            line3.setStyle("-fx-stroke: #f1c53c");
        });

        PortfolioButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: F5F5F5");
            PortfolioLabel.setTextFill(Color.BLACK);
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #b7b5b5");
        });

        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresLabel.setTextFill(Color.WHITE);
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });

        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresLabel.setTextFill(Color.BLACK);
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #b7b5b5");
        });

        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideLabel.setTextFill(Color.WHITE);
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });

        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: F5F5F5");
            AideLabel.setTextFill(Color.BLACK);
            AideImage.setImage(AideImg);
            line5.setStyle("-fx-stroke: #b7b5b5");
        });
   }
         /*************/
 }
}