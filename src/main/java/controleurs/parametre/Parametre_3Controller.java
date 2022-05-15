package controleurs.parametre;

import controleurs.acceuil.AccueilMediateur;
import hashage.GenererHashage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import models.LoginUser;
import models.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class Parametre_3Controller implements Initializable {
    static Label ErreurMotPasseActuel;
    static Label ErreurNouveauMotPasse;
    static Label ErreurConfirmation;
    static Label ConfirmeModification;
    /*****************checkers*************************/
    @FXML
    CheckBox check1;
    @FXML
    CheckBox check2;
    @FXML
    CheckBox check3;
    /*************les mots de passe ***********************/
    @FXML
    private AnchorPane monAnchorpane1;
    @FXML
    private AnchorPane monAnchorpane2;
    @FXML
    private AnchorPane monAnchorpane3;
    /*************AnchorErreurs*****************************/
    @FXML
    private AnchorPane monAnchor1;

    @FXML
    private AnchorPane monAnchor2;

    @FXML
    private AnchorPane monAnchor3;
    @FXML
    private AnchorPane monAnchor4;
    /*****************************************************/
    static TextField motPasseActuel;
    static TextField nouveauMotPasse;
    static TextField motPasseConfirmation;
    static final int NbChminPassword=10 ;
    static boolean result = false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        motPasseActuel = new PasswordField();
        motPasseConfirmation = new PasswordField();
        nouveauMotPasse = new PasswordField();
        motPasseActuel.setPrefSize(200, 30);
        motPasseConfirmation.setPrefSize(200, 30);
        nouveauMotPasse.setPrefSize(200, 30);
        monAnchorpane1.getChildren().add(motPasseActuel);
        monAnchorpane2.getChildren().add(nouveauMotPasse);
        monAnchorpane3.getChildren().add(motPasseConfirmation);
        /*******************************************************************/
        Tooltip tool =new Tooltip();
        tool.setText("il doit contenir au moins 10 caractéres,un caractére majuscule, un minuscule,un chiffre et un caractére non-alphanumérique");
        tool.setFont(Font.font("Open Sans"));
        tool.setWrapText(true);
        tool.setMaxWidth(190);
        tool.setShowDelay(Duration.ZERO);
        Image image =new Image(getClass().getResourceAsStream("/icons/Inscription/Ecareer2.png"));
        ImageView view =new ImageView(image);
        view.setFitHeight(30);
        view.setFitWidth(30);
        tool.setGraphic(view);
        nouveauMotPasse.setTooltip(tool);
        /***********************************/
        check1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                String word;
                if (check1.isSelected()) {
                    word = motPasseActuel.getText();
                    motPasseActuel = new TextField();
                    motPasseActuel.setText(word);
                    motPasseActuel.setPrefSize(200, 30);
                    monAnchorpane1.getChildren().add(motPasseActuel);
                } else {
                    word = motPasseActuel.getText();
                    motPasseActuel = new PasswordField();
                    motPasseActuel.setText(word);
                    motPasseActuel.setPrefSize(200, 30);
                    monAnchorpane1.getChildren().add(motPasseActuel);
                }
            }
        });
        check2.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                String word;
                if (check2.isSelected()) {
                    word = nouveauMotPasse.getText();
                    nouveauMotPasse = new TextField();
                    nouveauMotPasse.setPrefSize(200, 30);
                    nouveauMotPasse.setText(word);
                    monAnchorpane2.getChildren().add(nouveauMotPasse);
                } else {
                    word = nouveauMotPasse.getText();
                    nouveauMotPasse = new PasswordField();
                    nouveauMotPasse.setPrefSize(200, 30);
                    monAnchorpane2.getChildren().add(nouveauMotPasse);
                    nouveauMotPasse.setText(word);
                }
            }
        });
        check3.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                String word;
                if (check3.isSelected()) {
                    word = motPasseConfirmation.getText();
                    motPasseConfirmation = new TextField();
                    motPasseConfirmation.setPrefSize(200, 30);
                    motPasseConfirmation.setText(word);
                    monAnchorpane3.getChildren().add(motPasseConfirmation);
                } else {
                    word = motPasseConfirmation.getText();
                    motPasseConfirmation = new PasswordField();
                    motPasseConfirmation.setPrefSize(200, 30);
                    motPasseConfirmation.setText(word);
                    monAnchorpane3.getChildren().add(motPasseConfirmation);
                }
            }
        });
        /******************************l'ajouter des labels des erreurs à leurs anchorpanes******************/
        ErreurMotPasseActuel = new Label();
        ErreurMotPasseActuel.setPrefSize(267, 20);
        ErreurMotPasseActuel.setStyle("-fx-text-fill : red ;-fx-font-size :12;-fx-font-family : Open Sans");
        monAnchor1.getChildren().add(ErreurMotPasseActuel);
        ErreurMotPasseActuel.setOpacity(0);

        ErreurNouveauMotPasse = new Label();
        ErreurNouveauMotPasse.setPrefSize(267, 20);
        ErreurNouveauMotPasse.setStyle("-fx-text-fill : red ;-fx-font-size :12;-fx-font-family : Open Sans");
        monAnchor2.getChildren().add(ErreurNouveauMotPasse);
        ErreurNouveauMotPasse.setOpacity(0);

        ErreurConfirmation = new Label();
        ErreurConfirmation.setPrefSize(267, 20);
        ErreurConfirmation.setStyle("-fx-text-fill : red ;-fx-font-size :12;-fx-font-family : Open Sans");
        monAnchor3.getChildren().add(ErreurConfirmation);
        ErreurConfirmation.setOpacity(0);
        ConfirmeModification = new Label();
        ConfirmeModification.setPrefSize(300, 30);
        ConfirmeModification.setStyle("-fx-text-fill :#19c62a ; -fx-font-family : Open Sans ; -fx-font-size : 16");
        monAnchor4.getChildren().add(ConfirmeModification);
        ConfirmeModification.setText("Mot de passe modifié avec succées ");
        ConfirmeModification.setOpacity(0);

    }
   /******************************************************************************************/
    static void ModifierPassword() throws NoSuchAlgorithmException, IOException {
        if (motPasseActuel.getText() == "") {
            ErreurMotPasseActuel.setText("Entrez votre ancien mot de passe !");
            AccueilMediateur.commutateur.TraiterAlert(ErreurMotPasseActuel);
        } else {
            AtomicReference<GenererHashage> hashage = new AtomicReference<>(new GenererHashage(motPasseActuel.getText()));
            if (hashage.get().RécupereHashage().equals(AccueilMediateur.utilisateur.donnes.getMotdePasse())) {
                if (nouveauMotPasse.getText() == "") {
                    ErreurNouveauMotPasse.setText("Entrez votre nouveau mot de passe !");
                    AccueilMediateur.commutateur.TraiterAlert(ErreurNouveauMotPasse);
                } else {
                    if(VerifierPasswordSyntax(nouveauMotPasse.getText())==0){
                       ErreurNouveauMotPasse.setText("Mot de passe failble !");
                       AccueilMediateur.commutateur.TraiterAlert(ErreurNouveauMotPasse);
                    }else {
                        if (nouveauMotPasse.getText().equals(motPasseActuel.getText())) {
                            ErreurNouveauMotPasse.setText("ce mot de passe est le méme que vous avez déja !");
                            AccueilMediateur.commutateur.TraiterAlert(ErreurNouveauMotPasse);
                        } else {
                            if (motPasseConfirmation.getText().equals(nouveauMotPasse.getText())) {
                                /*************fin*******************/
                                /***********************************/
                                int indexStudent = -1;
                                int stop = 0;
                                String email = AccueilMediateur.utilisateur.donnes.getEmail();
                                String motpasse = AccueilMediateur.utilisateur.donnes.getMotdePasse();
                                String matricule = AccueilMediateur.utilisateur.donnes.getMatricule();
                                LoginUser user = new LoginUser(motpasse, email, matricule);
                                while (indexStudent < Parametre_Controller.loginUtilisateurs.getList().size() && stop != 1) {
                                    indexStudent++;
                                    if (user.equals(Parametre_Controller.loginUtilisateurs.getList().get(indexStudent))) {
                                        stop = 1;
                                        System.out.println("utilisateur trouvé");
                                    }
                                }
                                    String header = "Confirmation";
                                    String content = "Cliquez sur OK pour confirmer que vous voulez modifier votre Mot de passe";
                                    CustomDialog dialog = new CustomDialog(header, content);
                                    dialog.openDialog();
                                    int finalIndexStudent = indexStudent;
                                    dialog.buttonOk.setOnAction(e -> {
                                            hashage.set(new GenererHashage(nouveauMotPasse.getText()));
                                        try {
                                            Parametre_Controller.loginUtilisateurs.getList().get(finalIndexStudent).setMotPasse(hashage.get().RécupereHashage());
                                        } catch (IOException ex) {
                                            ex.printStackTrace();
                                        } catch (NoSuchAlgorithmException ex) {
                                            ex.printStackTrace();
                                        }
                                        try {
                                            AccueilMediateur.utilisateur.donnes.setMotdePasse(hashage.get().RécupereHashage());
                                        } catch (NoSuchAlgorithmException ex) {
                                            ex.printStackTrace();
                                        }
                                        AccueilMediateur.commutateur.TraiterAlert(ConfirmeModification);
                                        motPasseConfirmation.clear();
                                        nouveauMotPasse.clear();
                                        motPasseActuel.clear();
                                        dialog.closeDialog();
                                        Parametre_Controller.ModifierInformations();
                                    });
                                    dialog.buttonCancel.setOnMouseClicked(e -> {
                                        dialog.closeDialog();
                                    });
                                /*********************************/
                            } else {
                                ErreurConfirmation.setText("Reentrez votre mot de passe de Confirmation !");
                                AccueilMediateur.commutateur.TraiterAlert(ErreurConfirmation);
                            }
                        }
                    }
                }
            } else {
                ErreurMotPasseActuel.setText(" Mot de passe incorrect !");
                AccueilMediateur.commutateur.TraiterAlert(ErreurMotPasseActuel);
            }
        }
    }

     static int VerifierPasswordSyntax(String monMotdePasse ){
         int i=0;
         int index=0;
         int index1=0;
         int index2=0;
         int index3=0;
         Character ch=' ';
         while (i<monMotdePasse.length()) {
             ch = monMotdePasse.charAt(i);
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
         if(monMotdePasse.length()>=NbChminPassword){
           int totalIndex=index+index1+index2+index3;
            if(totalIndex==4){
              return 1;
            }else{
              return 0;
            }
         }
         else {
             return 0;
         }
    }

}
