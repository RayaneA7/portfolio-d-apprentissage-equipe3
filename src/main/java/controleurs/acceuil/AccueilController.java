package controleurs.acceuil;

import javafx.event.ActionEvent;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {
    @FXML
    Button SwitchButton;
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
    @FXML
    Label WelcomeLabel;
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
    Utilisateur user = new Utilisateur();
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

    static File file =new File("DonnesUtilisateur/ImagePersonnel.png");
    /********************************************************/
    Stage stage ;
    /*******************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*********************Image personnel********************/
        Image image = null;
        try {
            image = new Image(String.valueOf(file.toURI().toURL()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        imagePersonnel.setFill(new ImagePattern(image));
        /****************************************************/

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
        user = Utilisateur.deserialization();
        WelcomeLabel.setText("Bonjour "+ user.donnes.nom  + user.donnes.prenom);
        SwitchButton.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/views/Accueil_1View.fxml"));
                stage = (Stage) SwitchButton.getScene().getWindow();
                stage.setScene(new Scene(root, 850,600));
                stage.setTitle("Ecareer");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        logOut.setOnMouseClicked(event -> {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/ConnectView.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load(),800,568);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });
    }
    public void SwtichScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/views/Accueil_1View.fxml"));
        stage = (Stage) SwitchButton.getScene().getWindow();
        stage.setScene(new Scene(root, 850,600));
        stage.setTitle("Ecareer");
    }


}
