package controleurs.authentification;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.*;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.stream.Stream;

public class SignUp2Controller implements Initializable {
    @FXML
    private TextField monNumeroTelephone;
    @FXML
    private TextField monFacebook;
    @FXML
    private TextField monGithub;
    @FXML
    private TextField monLinkedln;
    @FXML
    private ImageView myHelp ;
    /***************les lignes**********************/
    @FXML
    private Line monLigneFacebook ;
    @FXML
    private Line monLigneGithub ;
    @FXML
    private Line monLigneLinkedln ;
    @FXML
    private Line monLigneNumeroTelephone ;
    /************************************************/
    @FXML
    private AnchorPane monAnchorpane ;
    @FXML
    private ImageView monPhoto ;
    @FXML
    private TextArea monBio ;
    private File file ;
    private Stage stage ;
    String studentFolder;
    /****************Logique d'affichage ****************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        myHelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        String typeB="-fx-stroke:#F1C53C ;-fx-stroke-width:3 ";
        String typeA="-fx-stroke:#666666 ;-fx-stroke-width:3 ";
        monAnchorpane.setOnMouseEntered(event2 -> {
            monGithub.setOnMouseClicked( event3 -> {
                monLigneFacebook.setStyle(typeA);
                monLigneNumeroTelephone.setStyle(typeA);
                monLigneLinkedln.setStyle(typeA);
                monLigneGithub.setStyle(typeB);
            });
            monFacebook.setOnMouseClicked( event3 -> {
                monLigneFacebook.setStyle(typeB);
                monLigneNumeroTelephone.setStyle(typeA);
                monLigneLinkedln.setStyle(typeA);
                monLigneGithub.setStyle(typeA);
            });
            monLinkedln.setOnMouseClicked(event3 -> {
                monLigneFacebook.setStyle(typeA);
                monLigneNumeroTelephone.setStyle(typeA);
                monLigneLinkedln.setStyle(typeB);
                monLigneGithub.setStyle(typeA);
            });
            monNumeroTelephone.setOnMouseClicked(event3 -> {
                monLigneFacebook.setStyle(typeA);
                monLigneNumeroTelephone.setStyle(typeB);
                monLigneLinkedln.setStyle(typeA);
                monLigneGithub.setStyle(typeA);
            });
        });
        EventHandler<MouseEvent> event5 =new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            monLigneFacebook.setStyle(typeA);
            monLigneNumeroTelephone.setStyle(typeA);
            monLigneLinkedln.setStyle(typeA);
            monLigneGithub.setStyle(typeA);
        }};
        monAnchorpane.setOnMouseExited(event5);
        monBio.setOnMouseClicked(event5);
        /********************************************************************/
        /******************Choix d'image de profile**************************/
        /*******************************************************************/
        monPhoto.setOnMouseClicked(event6-> {
            monLigneFacebook.setStyle(typeA);
            monLigneNumeroTelephone.setStyle(typeA);
            monLigneLinkedln.setStyle(typeA);
            monLigneGithub.setStyle(typeA);
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
            try {
                input = new FileInputStream(file);
                Image image = new Image(input);
                monPhoto.setImage(image);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            /********************************
            if (file != null) {
                try {
                    input = new FileInputStream(file);
                    output = new BufferedOutputStream(new FileOutputStream("DonnesUtilisateur/ImagePersonnel.png"));
                    Files.copy(Path.of(file.getPath()), output);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    Image image = new Image(input);
                    monPhoto.setImage(image);
                    try {
                        output.close();
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            /*************************************/
        });
    }
    //Copy methods
    public static void copyFolder(Path src, Path dest) throws IOException {
        try (Stream<Path> stream = Files.walk(src)) {
            stream.forEach(source -> copy(source, dest.resolve(src.relativize(source))));
        }
    }

    private static void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /***************Logique de fonctionnement**********************/
    public void PreviousPage(ActionEvent actionEvent) {
        ConnectController.pagination.setCurrentPageIndex(ConnectController.pagination.getCurrentPageIndex() - 1);
    }
    public void NextPage(ActionEvent event) throws IOException {
        ConnectController.user.contacts.setCountFacebook(monFacebook.getText());
        ConnectController.user.contacts.setCountGithub(monGithub.getText());
        ConnectController.user.contacts.setCountLinkedln(monLinkedln.getText());
        ConnectController.user.donnes.setBioPersonnel(monBio.getText());
        String numerotelephone = monNumeroTelephone.getText();
        if (verifiNumeroTelephone(monNumeroTelephone.getText()) == true) {
            ConnectController.user.contacts.setNbTelephone(Long.parseLong(monNumeroTelephone.getText()));
        }
        /********************************************************************/
        try {
            studentFolder =ConnectController.user.donnes.getMatricule();
            System.out.println("le folder d'étudiant est : " + studentFolder);
            File srcDir = new File("DonnesUtilisateurs/Etudiant");
            File destDir = new File("DonnesUtilisateurs/" + studentFolder);
            copyFolder(srcDir.toPath(), destDir.toPath());
            System.out.println("faite2");
            Projet projet = new Projet();
            projet.setId(UUID.randomUUID());
            projet.setTitre("fsfds");
            ConnectController.user.ajouterProjet(projet);
           ConnectController.create(ConnectController.user);
            /***************/
            LoginUser loginUser = new LoginUser(ConnectController.user.donnes.getMotdePasse(),
                    ConnectController.user.donnes.getEmail(), ConnectController.user.donnes.getMatricule());
            LoginUtilisateurs utilisateurs = new LoginUtilisateurs();
            utilisateurs.ajouteUtilisateurToList(loginUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file != null){
            OutputStream output;
            output = new BufferedOutputStream(new FileOutputStream("DonnesUtilisateurs/" + studentFolder + "/ImagePersonnel.png"));
            Files.copy(Path.of(file.getPath()), output);
            output.close();
        }
        /************Passage à la page d'acceuil *************/
        ConnectController.studentFolder=ConnectController.user.donnes.getMatricule();
        ConnectController.accedreAcceuil(event);
    }
    public boolean verifiNumeroTelephone(String numerotelephone){
        int i=0;
        boolean validate =true;
            if(numerotelephone!="") {
                while (i < numerotelephone.length() && validate != false) {
                    char ch = numerotelephone.charAt(i);
                    if (Character.isDigit(ch) == false) {
                        validate = false;
                    }
                    i++;
                }
            }
            else{validate=false ;}
        return validate;
    }
}
