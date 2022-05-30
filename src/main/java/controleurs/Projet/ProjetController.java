package controleurs.Projet;

import controleurs.acceuil.AccueilMediateur;
import controleurs.parametre.CustomDialog;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models.Project;
import models.Utilisateur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
    private Button addProjectBtn;
    @FXML
    private ScrollPane monScrollPane ;


    public static VBox cardLayout;

    @FXML
    private Button searchProjetBtn;
    @FXML
    private TextField searchProjectTextField;




    public static Project projectToEdit ;
    public static Project projectToDelete;


    private List<Project> projectList;




    @FXML
    private ListView<String> foundProjet;
    private ArrayList<Project> foundProjetList = new ArrayList<Project>();
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

    /********************************************************/

    public static Label label;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*********************Image personnel********************/
        imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));
        /****************************************************/
        cardLayout = new VBox();
        cardLayout.setPrefSize(466,303);
        cardLayout.setSpacing(20);
        cardLayout.setAlignment(Pos.CENTER);
        cardLayout.setStyle("-fx-background-color: transparent;");
        cardLayout.setPadding(new Insets(15));
        monScrollPane.setStyle("-fx-background: transparent;");
        monScrollPane.setContent(cardLayout);

        label = new Label("La liste de projets est vide , cliquer sur (+) pour ajouter un projet ");
        label.setPrefSize(600,100);
        label.setWrapText(true);
        label.setFont(new Font(25));
        label.setTextFill(Color.RED);
        label.setTextAlignment(TextAlignment.CENTER);

        /*********/
        if(AccueilMediateur.utilisateur.listProjets.size() == 0){
         cardLayout.setAlignment(Pos.CENTER);
         cardLayout.getChildren().add(label);
        }else {
            cardLayout.getChildren().clear();
            //label.setVisible(false);
        }

        /********/
        if (AccueilMediateur.utilisateur.listProjets.size() > 0) {
           // System.out.println("List des Projet n'est pas vide " );
            try {
                AccueilMediateur.utilisateur = Utilisateur.deserialization(AccueilMediateur.studentFolder);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("un probleme se génere lors de la désirialisation des données de l'utilisateur");
            }
            for (int i = 0; i < AccueilMediateur.utilisateur.listProjets.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/ProjectCard.fxml"));
                AnchorPane anchorPane = null;
                try {
                    anchorPane = fxmlLoader.load();

                    anchorPane.setStyle("-fx-background-image: url('icons/Project/Card2022.png');" +
                            "-fx-background-size: 100% 100%;-fx-padding:0;");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ProjectCardController projectCardController = fxmlLoader.getController();
//                System.out.println("### : "+ AccueilMediateur.utilisateur.listProjets.get(i).getTitle());
//                System.out.println("@@@ : "+ AccueilMediateur.utilisateur.listProjets.get(i).getCompetences());

                try {
                    projectCardController.setData(AccueilMediateur.utilisateur.listProjets.get(i));
                    projectCardController.setProject(AccueilMediateur.utilisateur.listProjets.get(i));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                cardLayout.getChildren().add(anchorPane);
            }
        }
        /****************************************************/
        AccueilButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color: #f1c53c");
            AccueilLabel.setTextFill(Color.WHITE);
            AccueilImage.setImage(AccueilImg1);
            line1.setStyle("-fx-stroke: #f1c53c");
        });

        AccueilButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AccueilButton.setStyle("-fx-background-color:  F5F5F5");
            AccueilLabel.setTextFill(Color.web("#666666"));
            AccueilImage.setImage(AccueilImg);
            line1.setStyle("-fx-stroke: #b7b5b5");
        });
        AccueilButton.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerAcceuil(event);
        });

      ProjetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: #f1c53c");
            ProjetLabel.setTextFill(Color.WHITE);
            ProjetsImage.setImage(ProjetImg1);
            line2.setStyle("-fx-stroke: #f1c53c");

        });
        ProjetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ProjetButton.setStyle("-fx-background-color: F5F5F5");
            ProjetLabel.setTextFill(Color.web("#666666"));
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
            PortfolioLabel.setTextFill(Color.web("#666666"));
            PortfolioImage.setImage(PortfolioImg);
            line3.setStyle("-fx-stroke: #b7b5b5");
        });
        PortfolioButton.setOnMouseClicked(event->{
         AccueilMediateur.commutateur.AllerPortfolio();
        });


        ParametresButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: #f1c53c");
            ParametresLabel.setTextFill(Color.WHITE);
            ParametresIamge.setImage(ParametresImg1);
            line4.setStyle("-fx-stroke: #f1c53c");
        });
        ParametresButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            ParametresButton.setStyle("-fx-background-color: F5F5F5");
            ParametresLabel.setTextFill(Color.web("#666666"));
            ParametresIamge.setImage(ParametresImg);
            line4.setStyle("-fx-stroke: #b7b5b5");
        });
        ParametresButton.setOnMouseClicked(event->{
            AccueilMediateur.commutateur.AllerParametres(event);
        });

        AideButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: #f1c53c");
            AideLabel.setTextFill(Color.WHITE);
            AideImage.setImage(AideImg1);
            line5.setStyle("-fx-stroke: #f1c53c");
        });
        AideButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)->{
            AideButton.setStyle("-fx-background-color: F5F5F5");
            AideLabel.setTextFill(Color.web("#666666"));
            AideImage.setImage(AideImg);
            line5.setStyle("-fx-stroke: #b7b5b5");
        });
        AideButton.setOnMouseClicked(event->{
            try {
                AccueilMediateur.commutateur.AllerAide(event);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        addProjectBtn.setOnMouseClicked(event -> {
            AccueilMediateur.monPagination.setCurrentPageIndex(10);
        });






        searchProjetBtn.setOnMouseClicked(event -> {
            if(!searchProjectTextField.getText().equals("")){
                foundProjet.getItems().clear();
                foundProjetList.clear();
                for(int i=0 ; i<AccueilMediateur.utilisateur.listProjets.size() ; i++){
                    if(AccueilMediateur.utilisateur.listProjets.get(i).getTitle().contains(searchProjectTextField.getText())){
                        foundProjet.getItems().add(AccueilMediateur.utilisateur.listProjets.get(i).getTitle());
                        foundProjetList.add(AccueilMediateur.utilisateur.listProjets.get(i));
                    }
                }
                if(foundProjet.getItems().size() != 0){
                    foundProjet.setVisible(true);
                    foundProjet.setPrefHeight(foundProjet.getItems().size() * 25);
                }
            }else {
                foundProjet.setVisible(false);
            }
        });

        foundProjet.setOnMouseClicked(event -> {
            for(int i = 0 ; i<foundProjetList.size()  ; i++){
                if(foundProjet.getSelectionModel().getSelectedItem().equals(foundProjetList.get(i).getTitle())){
                    editProjectController.project = foundProjetList.get(i);
                }
            }
            AccueilMediateur.commutateur.AllerModificationProjet(event);
        });


    }
}
