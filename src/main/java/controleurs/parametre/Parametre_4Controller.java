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
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import models.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class Parametre_4Controller implements Initializable {
    @FXML
    private AnchorPane monAnchor1;

    @FXML
    private AnchorPane monAnchor2;

    @FXML
    private AnchorPane monAncho3;

    @FXML
    private AnchorPane monAnchor4;

    @FXML
    private AnchorPane monAnchorConfirmation;
    /************************************/
    static TextField monNumeroTelephone ;
    static TextField monCountGithub ;
    static TextField monCountFacebook;
    static TextField monCountLinkedln;
    static Label ErreurNbTelephone ;
    static Label ConfirmeModification ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        monNumeroTelephone =new TextField();
        monNumeroTelephone.setPrefSize(347,30);
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String input = change.getText();
            if (input.matches("[0-9]*")){
                return change;
            }
            return null;
        };
        monNumeroTelephone.setTextFormatter(new TextFormatter<String>(integerFilter));
        monAnchor1.getChildren().add(monNumeroTelephone);

        monCountFacebook =new TextField();
        monCountFacebook.setPrefSize(347,30);
        monAnchor2.getChildren().add(monCountFacebook);

        monCountGithub =new TextField();
        monCountGithub.setPrefSize(347,30);
        monAncho3.getChildren().add(monCountGithub);

        monCountLinkedln =new TextField();
        monCountLinkedln.setPrefSize(347,30);
        monAnchor4.getChildren().add(monCountLinkedln);
        /*******************************************************/
        ConfirmeModification =new Label();
        ConfirmeModification.setPrefSize(350,30);
        ConfirmeModification.setStyle("-fx-text-fill :#19c62a ; -fx-font-family : Open Sans ; -fx-font-size : 16");
        ConfirmeModification.setText("Informations Personnels modifiées avec succés !");
        ConfirmeModification.setOpacity(0);
        monAnchorConfirmation.getChildren().add(ConfirmeModification);
        /********************************************/
        if(AccueilMediateur.utilisateur.contacts.getNbTelephone()!=0) {
            monNumeroTelephone.setText(String.valueOf(AccueilMediateur.utilisateur.contacts.getNbTelephone()));
        }
        monCountFacebook.setText(AccueilMediateur.utilisateur.contacts.getCountFacebook());
        monCountGithub.setText(AccueilMediateur.utilisateur.contacts.getCountGithub());
        monCountLinkedln.setText(AccueilMediateur.utilisateur.contacts.getCountLinkedln());
    }
    static void  ModifierContacts(){
        System.out.println("modification des info personnels ");
        long Nbtelephone =AccueilMediateur.utilisateur.contacts.getNbTelephone();
        String countfacbook =AccueilMediateur.utilisateur.contacts.getCountFacebook();
        String countgithub =AccueilMediateur.utilisateur.contacts.getCountGithub();
        String countlindeln=AccueilMediateur.utilisateur.contacts.getCountLinkedln();
        if(monNumeroTelephone.getText()==""){monNumeroTelephone.setText("0");}
        if(Nbtelephone!=Long.parseLong(monNumeroTelephone.getText()) || !countfacbook.equals(monCountGithub.getText()) || !countgithub.equals(monCountGithub.getText())|| ! countlindeln.equals(monCountLinkedln.getText())) {
            AccueilMediateur.utilisateur.contacts.setNbTelephone(Long.parseLong(monNumeroTelephone.getText()));
            AccueilMediateur.utilisateur.contacts.setCountFacebook(monCountFacebook.getText());
            AccueilMediateur.utilisateur.contacts.setCountGithub(monCountGithub.getText());
            AccueilMediateur.utilisateur.contacts.setCountLinkedln(monCountLinkedln.getText());
            ConfirmeModification.setText("Contacts modifiés avec succés !");
            Parametre_Controller.ModifierInformations();//la serialisation
        }
        else
        {
            ConfirmeModification.setText("Vous n'avez modifiés aucun champ ! ");
        }
        AccueilMediateur.commutateur.TraiterAlert(ConfirmeModification);
    }
}
