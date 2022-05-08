package controleurs.Projet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import modele.Project;
import modele.ProjectBag;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProjetController implements Initializable {


    @FXML
    Button SwitchButton;
    @FXML
    ImageView BarreImage;
    @FXML
    Button ProjetButton;
    @FXML
    ImageView ProjetsImage;
    @FXML
    Label ProjetLabel;
    @FXML
    Button PortfolioButton;
    @FXML
    ImageView PortfolioImage;
    @FXML
    Label PortfolioLabel;
    @FXML
    Button AideButton;
    @FXML
    ImageView AideImage;
    @FXML
    Label AideLabel;
    @FXML
    Button ParametresButton;
    @FXML
    ImageView ParametresIamge;
    @FXML
    Label ParametresLabel;
    @FXML
    Label WelcomeLabel;
    @FXML
    Button AccueilButton;
    @FXML
    ImageView AccueilImage;
    @FXML
    Label AccueilLabel;
    @FXML
    ImageView logOut;
    @FXML
    Line line1;
    @FXML
    Line line2;
    @FXML
    Line line3;
    @FXML
    Line line5;
    @FXML
    Line line4;
    @FXML
    Circle imagePersonnel;

    @FXML
    private ImageView addProjectBtn;

    @FXML
    private HBox cardLayout;


    private List<Project> projectList;

    /****************************************************************/
    String user = null;
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

        addProjectBtn.setOnMouseClicked(event -> {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/views/AddProjectView.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) SwitchButton.getScene().getWindow();
                stage.setScene(new Scene(root, 850,600));
                stage.setTitle("Ecareer");


        });
        //projectList = new ArrayList<>(myProjectList());

        try {
        if(ProjectBag.isEmptyBag() == false){
            for(int i = 0; i< ProjectBag.getProjets().size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/ProjectCard.fxml"));

                VBox vBox = fxmlLoader.load();
                ProjectCardController projectCardController = fxmlLoader.getController();
                projectCardController.setData(ProjectBag.getProjets().get(i));
                cardLayout.getChildren().add(vBox);
            }

        }
        }catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

}
