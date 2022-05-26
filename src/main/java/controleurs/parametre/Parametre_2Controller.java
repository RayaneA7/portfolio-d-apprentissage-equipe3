package controleurs.parametre;

import controleurs.acceuil.AccueilMediateur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class Parametre_2Controller implements Initializable {
    static TextField monAncienEmail;
    static TextField monNouveauEmail;
    static Label ModificationLabel;
    static Label ErreurEmail;
    /************************************/
    @FXML
    private AnchorPane monAnchorEmailActuel;

    @FXML
    private AnchorPane monAnchorNouveauEmail;

    @FXML
    private AnchorPane monAnchorErreur;

    @FXML
    private AnchorPane monAnchorConfirmation ;
    /***********************************/
    static int indexstudent ;
    static boolean result=false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        monAncienEmail =new TextField();
        monAncienEmail.setPrefSize(200,30);
        monAnchorEmailActuel.getChildren().add(monAncienEmail);

        monNouveauEmail =new TextField();
        monNouveauEmail.setPrefSize(200,30);
        monAnchorNouveauEmail.getChildren().add(monNouveauEmail);

        ErreurEmail =new Label();
        ErreurEmail.setPrefSize(270,20);
        ErreurEmail.setStyle("-fx-text-fill : red ;-fx-font-size :12;-fx-font-family : Open Sans");
        monAnchorErreur.getChildren().add(ErreurEmail);
        ErreurEmail.setOpacity(0);

        ModificationLabel =new Label("Email modifié avec succés ! ");
        ModificationLabel.setStyle("-fx-text-fill :#19c62a ; -fx-font-family : Open Sans ; -fx-font-size : 16");
        ModificationLabel.setPrefSize(300,30);
        ModificationLabel.setOpacity(0);
        monAnchorConfirmation.getChildren().add(ModificationLabel);
        /******************************/
        monAncienEmail.setText(AccueilMediateur.utilisateur.donnes.getEmail());
    }
     static void ModifierEmail() throws IOException {

        if (verifierEmail(monNouveauEmail.getText()) == 1) {
            String header = "Confirmation";
            String content = "Cliquez sur OK pour confirmer que vous voulez modifier votre Email";
            CustomDialog dialog = new CustomDialog(header, content);
            dialog.openDialog();
            dialog.buttonOk.setOnAction(e -> {
                try {
                    monAncienEmail.setText(monNouveauEmail.getText());
                    Parametre_Controller.loginUtilisateurs.getList().get(indexstudent).setEmail(monNouveauEmail.getText());
                    AccueilMediateur.utilisateur.donnes.setEmail(monNouveauEmail.getText());
                    AccueilMediateur.commutateur.TraiterAlert(ModificationLabel);
                    monNouveauEmail.clear();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                dialog.closeDialog();
                Parametre_Controller.ModifierInformations();
            });
            dialog.buttonCancel.setOnAction(e -> {
                dialog.closeDialog();
            });

        }
    }
    static int verifierEmail(String email) throws IOException {
        int index =1;
        String erreur=" Entrez votre nouveau Email !" ;
        if(email!="") {
            if (email.endsWith("@gmail.com") || email.endsWith("@esi.dz") || email.endsWith("@outlook.com") || email.endsWith("@yahoo.com")) {
                if (verifyEmailSyntax(email) == false) {
                    index = 0;
                    erreur = "Ce email est incorrect !";
                } else {
                    int i = 0;
                    int stop = 0;
                    while (i < Parametre_Controller.loginUtilisateurs.getList().size() && stop != 1) {
                        if(AccueilMediateur.utilisateur.donnes.getEmail().equals(monNouveauEmail.getText())){
                            erreur="Ce Email est le méme que celui que vous avez !";
                            stop=1;
                            index=0;
                        }
                        else {
                            if ((Parametre_Controller.loginUtilisateurs.getList().get(i).getEmail().equals(email))
                            && (Parametre_Controller.loginUtilisateurs.getList().get(i).getEmail().equals(AccueilMediateur.utilisateur.donnes.getEmail())==false)) {
                                stop = 1;
                                index = 0;
                                erreur = "Ce email appartient déja à un étudiant !";
                            }
                            else if(Parametre_Controller.loginUtilisateurs.getList().get(i).getEmail().equals(AccueilMediateur.utilisateur.donnes.getEmail())){
                                indexstudent=i;
                            }
                        }
                        i++;
                    }
                }
            } else {
                erreur = "Ce email est incorrect !";
                index = 0;
            }
        }
        else{index=0;}
        if(index==0){
            ErreurEmail.setText(erreur);
            AccueilMediateur.commutateur.TraiterAlert(ErreurEmail);
        }
        return index;
    }
    static boolean verifyEmailSyntax(String info){
        int i=0;
        int index=0;
        int index1=0;
        int index2=0;
        int index3=0;
        Character ch=info.charAt(i);
        while (ch!='@' &&i<info.length()-1) {
            if (Character.isUpperCase(ch)) {
                index = 1;
            }
            if (Character.isLowerCase(ch)) {
                index1=1;
            }
            if (Character.isDigit(ch)) {
                index2=1;
            }
            if(!Character.isDigit(ch)&&!Character.isAlphabetic(ch))
            {
                index3=1;
            }
            i++;
            ch = info.charAt(i);
        }
        int totalIndex= index3+index1+index2+index;
        if(totalIndex>=2)
        {
            return true;
        }
        else{
            return false;
        }
    }


}
