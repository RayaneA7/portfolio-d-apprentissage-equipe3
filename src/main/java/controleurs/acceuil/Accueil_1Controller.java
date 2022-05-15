package controleurs.acceuil;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.LoginUtilisateurs;
import models.Utilisateur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Accueil_1Controller implements Initializable {
    @FXML
    Button SwitchButton;
    @FXML
    Button AccueilButton;
    @FXML
    Button ProjetButton;
    @FXML
    Button PortfolioButton;
    @FXML
    Button ParametresButton;
    @FXML
    Button AideButton;
    @FXML
    Label WelcomeLabel;

    /****************** images Views ************************/
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
    Circle imagePersonnnel;
    /************************lines************************/
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
    Utilisateur user ;
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
    /*******************************************************/
     Stage stage ;
    /******************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*********************Image personnel********************/
            if(AccueilMediateur.image!=null) {
                imagePersonnnel.setFill(new ImagePattern(AccueilMediateur.image));
            }
            imagePersonnnel.setOnMouseClicked(e->{
              AccueilMediateur.commutateur.AllerProfile(e);
            });
            /**************************************************/
        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });

        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #b7b5b5");
        });
        /***********************************************************************************/
        ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");
        });
        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetsImage.setImage(ProjetImg);
            line2.setStyle("-fx-stroke: #b7b5b5");
        });
        ProjetButton.setOnMouseClicked(event->{
            AccueilMediateur.commutateur.AllerProjet(event);
        });
       /*******************************************************************************************/
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: #f1c53c");
            PortfolioImage.setImage(PortfolioImg1);
            line3.setStyle("-fx-stroke: #f1c53c");
        });
        PortfolioButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            PortfolioButton.setStyle("-fx-background-color: F5F5F5");
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #b7b5b5");
        });
        PortfolioButton.setOnMouseClicked(event->{
            AccueilMediateur.commutateur.AllerPortfolio(event);
        });
        /******************************************************************************************/
        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });
        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #b7b5b5");
        });
        ParametresButton.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerParametres(event);
        });
        /*****************************************************************************************/
        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });
        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: F5F5F5");
            AideImage.setImage(AideImg);
            line5.setStyle("-fx-stroke: #b7b5b5");
        });
        AideButton.setOnMouseClicked(event -> {
            try {
                AccueilMediateur.commutateur.AllerAide(event);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        /*******************************************************************************/
        WelcomeLabel.setText("Bonjour ,"+AccueilMediateur.utilisateur.donnes.getNom()+" "+
                AccueilMediateur.utilisateur.donnes.getPrenom());
        SwitchButton.setOnAction(e->{
               AccueilMediateur.monPagination.setCurrentPageIndex(0);
        });
        /*******************************************************************************/
        logOut.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.Déconnecter(event);
        });
        /*************************Aller au profile personnel**********************************/

        /****************************************************************************************/

    }
    public void SwtichScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/AccueilView.fxml"));
        stage = (Stage)SwitchButton.getScene().getWindow();
        stage.setScene(new Scene(root, 850,600));
        stage.setTitle("Ecareer");
    }
}
