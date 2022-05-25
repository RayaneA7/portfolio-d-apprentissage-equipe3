package controleurs.parametre;

import controleurs.acceuil.AccueilMediateur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.*;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class Parametre_1Controller implements Initializable {
    @FXML
    private AnchorPane monAnchorBio;

    @FXML
    private AnchorPane monAnchorPrenom;

    @FXML
    private AnchorPane monAnchorNom;

    @FXML
    private AnchorPane monAnchorConfirmation;
    @FXML
    private Circle monImage;

    @FXML
    private ImageView SupprimePhoto;

    @FXML
    private ImageView AjoutePhoto;
    /**********************************************************************************/
    public static TextField monPrenom;

    public static TextField monNom;

    public static TextArea monBio;

    public static Label confirmationLabel;

    private File file;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        monBio = new TextArea();
        monBio.setWrapText(true);
        monBio.setPrefSize(130, 100);
        monAnchorBio.getChildren().add(monBio);
        monNom = new TextField();
        monNom.setPrefSize(160, 30);
        monAnchorNom.getChildren().add(monNom);
        monPrenom = new TextField();
        monPrenom.setPrefSize(160, 30);
        monAnchorPrenom.getChildren().add(monPrenom);
        monPrenom.requestFocus();
        confirmationLabel = new Label();
        confirmationLabel.setPrefSize(350, 30);
        confirmationLabel.setStyle("-fx-text-fill :#19c62a ; -fx-font-family : Open Sans ; -fx-font-size : 16");
        confirmationLabel.setOpacity(0);
        confirmationLabel.setText("Informations Personnels modifiés avec succés");
        monAnchorConfirmation.getChildren().add(confirmationLabel);
        /******************************************/
        monBio.setText(AccueilMediateur.utilisateur.donnes.getBioPersonnel());
        monNom.setText(AccueilMediateur.utilisateur.donnes.getNom());
        monPrenom.setText(AccueilMediateur.utilisateur.donnes.getPrenom());
        monImage.setFill(new ImagePattern(AccueilMediateur.image));
        /**************Suppresion et ajoute de la photo personnels********************/
        AjoutePhoto.setOnMouseClicked(e -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choisir une photo de profile");
            chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG Files", "*.png")
                    , new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg")
                    , new FileChooser.ExtensionFilter("GIF Files", "*.gif")
                    , new FileChooser.ExtensionFilter("BMP Files", "*.bmp")
            );
            file = chooser.showOpenDialog(null);
            System.out.println(getClass());
            FileInputStream input = null;
            /*******************************/
            if(file!=null){
                try {
                    input = new FileInputStream(file);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                Image image = new Image(input);
                monImage.setFill(new ImagePattern(image));
              //  AccueilMediateur.image=image;
                try {
                    input.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                /*******le changement de l'image dans le fichier ImagePersonnels***********/
                OutputStream output = null;
                try {
                    System.out.println("welcome");
                    output = new BufferedOutputStream(new FileOutputStream("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/ImagePersonnel.png"));
                    System.out.println("welcome1");
                    Files.copy(Path.of(file.getPath()), output);
                    System.out.println("welcome2");
                    output.close();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                    System.out.println("welcome3");
                }
                /**********************************************/
            }
        });
        /**********************************************************/
        /*****************suppression de la photo personnel*********/
        SupprimePhoto.setOnMouseClicked(event->{
            OutputStream output = null;
            file =new File("DonnesUtilisateurs/Etudiant/ImagePersonnel.png");
            try {
                output = new BufferedOutputStream(new FileOutputStream("DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/ImagePersonnel.png"));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                Files.copy(Path.of(file.getPath()), output);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            InputStream input=null;
            try {
                input = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            Image image = new Image(input);
            monImage.setFill(new ImagePattern(image));
            AccueilMediateur.image=image;
            try {
                input.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        });
    }
    /************************************************/
 static void  ModifierInfo(){
               System.out.println("modification des info personnels ");
               String nom =AccueilMediateur.utilisateur.donnes.getNom();
               String prenom =AccueilMediateur.utilisateur.donnes.getPrenom();
               String bio =AccueilMediateur.utilisateur.donnes.getBioPersonnel();
               if(!nom.equals(monNom.getText()) || !prenom.equals(monPrenom.getText()) || ! bio.equals(monBio.getText())) {
                   AccueilMediateur.utilisateur.donnes.setBioPersonnel(monBio.getText());
                   AccueilMediateur.utilisateur.donnes.setNom(monNom.getText());
                   AccueilMediateur.utilisateur.donnes.setPrenom(monPrenom.getText());
                   confirmationLabel.setText("Informations Personnels modifiés avec succés !");
                   Parametre_Controller.ModifierInformations();
               }
               else
               {
                   confirmationLabel.setText("Vous n'avez modifiés aucun champ ! ");
               }
               AccueilMediateur.commutateur.TraiterAlert(confirmationLabel);
   }

}