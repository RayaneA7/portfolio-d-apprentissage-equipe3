package controleurs.parametre;

import controleurs.acceuil.AccueilMediateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

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
    public Circle monImage;

    @FXML
    private ImageView SupprimePhoto;

    @FXML
    private ImageView AjoutePhoto;
    @FXML
    private Button TelechargementButton;
    @FXML
    private Label TelechargementConfirmation;
    Image Img1 = new Image(getClass().getResourceAsStream("/icons/parametre/UpdateCompetence.png"));
    Image Img = new Image(getClass().getResourceAsStream("/icons/parametre/UpdateCompetence1.png"));
    /**********************************************************************************/
    public static TextField monPrenom;

    public static TextField monNom;

    public static TextArea monBio;

    public static Label confirmationLabel;

    private File file=null ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        monBio = new TextArea();
        monBio.setWrapText(true);
        monBio.setPrefSize(140, 70);
        monAnchorBio.getChildren().add(monBio);
        monNom = new TextField();
        monNom.setPrefSize(110, 30);
        monAnchorNom.getChildren().add(monNom);
        monPrenom = new TextField();
        monPrenom.setPrefSize(110, 30);
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
        if(AccueilMediateur.image!=null) {
            monImage.setFill(new ImagePattern(AccueilMediateur.image));
        }
        /**************Suppresion et ajoute de la photo personnels********************/
        AjoutePhoto.setOnMouseClicked(e -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choisir une photo de profile");
            chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG Files", "*.png")
                  //  , new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg")
                  //  , new FileChooser.ExtensionFilter("GIF Files", "*.gif")
                  //  , new FileChooser.ExtensionFilter("BMP Files", "*.bmp")
            );
            file = chooser.showOpenDialog(null);
            System.out.println(getClass());
            FileInputStream input = null;
            /********************************************/
            if(file!=null){
                try {
                    input = new FileInputStream(file);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                Image image = new Image(input);
                monImage.setFill(new ImagePattern(image));
                Parametre_Controller.imagePersonnel.setFill(new ImagePattern(image));
                AccueilMediateur.image=image;//on mettre la nouvelle image personnels
                try {
                    input.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                /*******le changement de l'image dans le fichier ImagePersonnels******************/
                OutputStream output = null;
                try {
                    System.out.println("welcome");
                    output = new BufferedOutputStream(new FileOutputStream(AccueilMediateur.StudentDirectory+"/DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/ImagePersonnel.png"));
                    System.out.println("welcome1");
                    Files.copy(Path.of(file.getPath()), output);
                    System.out.println("welcome2");
                    output.close();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                    System.out.println("welcome3");
                }
                /********************Rechargement de la page****************************************/
                FXMLLoader loader1;
                loader1 = new FXMLLoader(getClass().getResource("/views/Parametre_View.fxml"));
                try {
                    System.out.println(AccueilMediateur.memory.size());
                    AccueilMediateur.memory.remove(2);
                   AccueilMediateur.memory.add(2,loader1.load());
                   System.out.println(AccueilMediateur.memory.size());
                   AccueilMediateur.commutateur.AllerParametres(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                /**********************************************/
            }
        });
        /**********************Telechargement des compétences************************************/
        Tooltip tipInformation =new Tooltip("Télécharger la nouvelle version du fichier des compétences à partir du site d'aide , et puis charger la d'ici");
        tipInformation.setWrapText(true);
        tipInformation.setMaxWidth(250);
        tipInformation.setShowDelay(Duration.ZERO);
        TelechargementButton.setTooltip(tipInformation);
        TelechargementButton.setOnMouseEntered(e->{
            ImageView view =new ImageView(Img1);
            view.setFitWidth(30);
            view.setFitHeight(30);
            TelechargementButton.setGraphic(view);
        });
        TelechargementButton.setOnMouseExited(e->{
            ImageView view =new ImageView(Img);
            view.setFitWidth(30);
            view.setFitHeight(30);
            TelechargementButton.setGraphic(view);
        });

        TelechargementButton.setOnMouseClicked(e->{
                    FileChooser chooser = new FileChooser();
                    chooser.setTitle("Choisir le nouveau fichier des compétences");
                    chooser.getExtensionFilters().addAll(
                            new FileChooser.ExtensionFilter("Json Files", "*.json")
                            //  , new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg")
                            //  , new FileChooser.ExtensionFilter("GIF Files", "*.gif")
                            //  , new FileChooser.ExtensionFilter("BMP Files", "*.bmp")
                    );
                    File file1 = chooser.showOpenDialog(null);
                    File file2  = new File("References/competencesJson.json");
                    BufferedOutputStream output = null;
                    /********************************************/
                    if(file1!=null){
                        int i = 0;
                        TelechargementButton.setCursor(Cursor.WAIT);
                        FileReader reader = null;
                        FileWriter writer =null;
                        try {
                             reader =new FileReader(file1);
                        } catch (FileNotFoundException ex) {
                           // ex.printStackTrace();
                        }
                        try {
                            writer =new FileWriter(file2);
                        } catch (IOException ex) {
                            //ex.printStackTrace();
                        }
                        String str = "";
                        while (true) {
                            try {
                                if (!((i = reader.read()) != -1)) break;
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            str += (char)i;
                        }
                        /*******************
                        int nb=str.length();
                        str =str.concat("\"}]}");
                        System.out.println("\"}]}");
                        System.out.println("la fin des compétences est :"+str.substring(nb));
                        /*********************/
                        try {
                            writer.write(str);
                            TelechargementConfirmation.setTextFill(Paint.valueOf("#19C62A"));
                            TelechargementConfirmation.setText("chargement fait avec succés !");
                            AccueilMediateur.commutateur.TraiterAlert(TelechargementConfirmation);
                        } catch (IOException ex) {
                            TelechargementConfirmation.setTextFill(Paint.valueOf("red"));
                            TelechargementConfirmation.setText("Probléme se génere lors de chargement !");
                            AccueilMediateur.commutateur.TraiterAlert(TelechargementConfirmation);
                           /// ex.printStackTrace();
                        }
                        try {
                            writer.close();
                            reader.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
        });
        /*****************suppression de la photo personnel***************************************/
        SupprimePhoto.setOnMouseClicked(event->{
            OutputStream output = null;
            file =new File("DonnesUtilisateurs/Etudiant/ImagePersonnel.png");
            try {
                output = new BufferedOutputStream(new FileOutputStream(AccueilMediateur.StudentDirectory+"/DonnesUtilisateurs/" + AccueilMediateur.studentFolder + "/ImagePersonnel.png"));
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
            Parametre_Controller.imagePersonnel.setFill(new ImagePattern(image));
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