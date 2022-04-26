package controleurs.authentification;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

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
            OutputStream output =null ;
            FileInputStream input = null;
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
        });
    }

    /***************Logique de fonctionnement**********************/
    public void PreviousPage(ActionEvent actionEvent) {
        ConnectController.pagination.setCurrentPageIndex(ConnectController.pagination.getCurrentPageIndex() - 1);
    }
    public void NextPage(ActionEvent event) throws IOException {
        ConnectController.user.contacts.setCountFacebook(monFacebook.getText());
        ConnectController.user.contacts.setCountGithub(monGithub.getText());
        ConnectController.user.contacts.setCountLinkedln(monLinkedln.getText());
        String numerotelephone =monNumeroTelephone.getText();
        int i=0;
        int validate =0;
        while(i<numerotelephone.length()&&validate!=1)
        {
            char ch = numerotelephone.charAt(i);
            if(Character.isDigit(ch)==false)
            {
               validate=1;
            }
            i++;
        }
        if(monNumeroTelephone.getText()!=""&& validate!=1) {
            ConnectController.user.contacts.setNbTelephone(Long.parseLong(monNumeroTelephone.getText()));
        }
        //System.out.println(monFacebook.getText());
        //System.out.println(monGithub.getText());
        //System.out.println(monLinkedln.getText());
        //System.out.println(monNumeroTelephone.getText());
        Utilisateur.serialize(ConnectController.user);
        /**********************************************************************/
        /*************************Passage à la page d'acceuil ********************************************/

        FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/AccueilView.fxml"));
        Scene scene = new Scene(loader.load(),850,600);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setWidth(850);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.show();
        /******Serialisation******/
    }
}
