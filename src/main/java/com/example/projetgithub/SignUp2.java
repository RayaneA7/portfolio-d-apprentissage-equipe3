package com.example.projetgithub;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class SignUp2 implements Initializable {
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
        monPhoto.setOnMouseClicked(event6->{
            monLigneFacebook.setStyle(typeA);
            monLigneNumeroTelephone.setStyle(typeA);
            monLigneLinkedln.setStyle(typeA);
            monLigneGithub.setStyle(typeA);
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choisir une photo de profile");
            chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter( "PNG Files", "*.png")
                    ,new FileChooser.ExtensionFilter("JPEG Files", "*.jpeg")
                    ,new FileChooser.ExtensionFilter("GIF Files", "*.gif")
                    ,new FileChooser.ExtensionFilter("BMP Files", "*.bmp")
            );
            //chooser.setInitialDirectory(new File("C:\\Users\\PCS\\Downloads\\Video"));
            file = chooser.showOpenDialog(null);
            FileInputStream input = null;
            if (file != null) {
                String fileName = file.getName();
                try {
                        input =new FileInputStream(file);
                       // FileInputStream input2 = new FileInputStream("resources.com.example.projetgithub.file.png");
                      //  Files.(input,input2);
                        //Paths dest = Paths.get();
                       // System.out.println(getClass());
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
                Image image =new Image(input);
                monPhoto.setImage(image);
            }
        });
    }
    public void PreviousPage(ActionEvent actionEvent) {
        Connect.pagination.setCurrentPageIndex(Connect.pagination.getCurrentPageIndex() - 1);
    }
    public void NextPage(ActionEvent event) throws IOException {
        Connect.user.contacts.setCountFacebook(monFacebook.getText());
        Connect.user.contacts.setCountGithub(monGithub.getText());
        Connect.user.contacts.setCountLinkedln(monLinkedln.getText());
        if(monNumeroTelephone.getText()!="") {
            Connect.user.contacts.setNbTelephone(Long.parseLong(monNumeroTelephone.getText()));
        }
        //System.out.println(monFacebook.getText());
        //System.out.println(monGithub.getText());
        //System.out.println(monLinkedln.getText());
        //System.out.println(monNumeroTelephone.getText());
        /**********************************************************************/
        /*************************Passage à la page d'acceuil ********************************************/

        FXMLLoader loader =new FXMLLoader(getClass().getResource("Accueil.fxml"));
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
