package controleurs.portfolio;

import controleurs.acceuil.AccueilMediateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Portfolio1Controller implements Initializable {
    @FXML
    Pagination pagination;
    @FXML
    private AnchorPane PanePort;
    /************************ Buttons *******************************/
    @FXML
    private Button SwitchButton;
    @FXML
    private Button AccueilButton;
    @FXML
    private Button ProjetButton;
    @FXML
    private Button PortfolioButton;
    @FXML
    private Button AideButton;
    @FXML
    private Button ParametresButton;
    @FXML
    private Button DeconnexionBut;
    /************************ Labels *******************************/
    @FXML
    private Label AccueilLabel;
    @FXML
    private Label ProjetLabel;
    @FXML
    private Label AideLabel;
    @FXML
    private Label PortfolioLabel;
    @FXML
    private Label ParametresLabel;
    /************************ Image Views *******************************/
    @FXML
    private ImageView AccueilImage;
    @FXML
    private ImageView ProjetsImage;
    @FXML
    private ImageView PortfolioImage;
    @FXML
    private ImageView ParametresIamge;
    @FXML
    private ImageView AideImage;
    @FXML
    private ImageView PortModel1;
    @FXML
    private ImageView PortModel2;
    @FXML
    private ImageView Next;
    @FXML
    private ImageView Previous;
    @FXML
    private ImageView logOut ;
    @FXML
    private Circle imagePersonnel ;

    /************************ Lines *******************************/
    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Line line5;

    private Image AccueilImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/AccueilBut.png"));
    private Image AccueilImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/AccueilBut1.png"));
    private Image PortfolioImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/PortfolioBut.png"));
    private Image PortfolioImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/PortfolioBut1.png"));
    private Image ProjetImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/ProjetsBut.png"));
    private Image ProjetImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/ProjetsBut1.png"));
    private Image ParametresImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/ParametresBut.png"));
    private Image ParametresImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/ParametresBut1.png"));
    private Image AideImg = new Image(getClass().getResourceAsStream("/icons/Portfolio/AideBut.png"));
    private Image AideImg1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/AideBut1.png"));
    private Image IconImg = new Image(getClass().getResourceAsStream("/icons/Inscription/ProjectName.png"));
    private Image ModelProf1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/Mod1.png"));
    private Image ModelAnim1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/Mod2.png"));
    private Image PortMod1 = new Image(getClass().getResourceAsStream("/icons/Portfolio/PortfolioModel.png"));
    private Image PortMo2 = new Image(getClass().getResourceAsStream("/icons/Portfolio/PortfolioModel2.png"));
    /*****************************************/
    Image image1 =new Image(getClass().getResourceAsStream("/icons/Portfolio/Model1.png"));
    Image image2 =new Image(getClass().getResourceAsStream("/icons/Portfolio/Model2.png"));
    Image image3 =new Image(getClass().getResourceAsStream("/icons/Portfolio/Model3.png"));

    private int nbrPag = 2;
    static int Currentpag = 0;
    public static int modele;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CreatePag();
        /*****************************************************************************/
        /*********************Image personnel********************/
        if(AccueilMediateur.image!=null){
            imagePersonnel.setFill(new ImagePattern(AccueilMediateur.image));
        }
        imagePersonnel.setOnMouseClicked(e-> {
            AccueilMediateur.commutateur.AllerProfile(e);
        });
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
            line1.setStyle("-fx-stroke: #d7d6d6");
        });
        AccueilButton.setOnMouseClicked(e->{
            AccueilMediateur.commutateur.AllerAcceuil(e);
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
            line2.setStyle("-fx-stroke: #d7d6d6");
        });
        ProjetButton.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.AllerProjet(event);
        });
        /****************************************************************************/
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
            line3.setStyle("-fx-stroke: #d7d6d6");
        });
        PortfolioButton.setOnMouseClicked(e->{
            //AccueilMediateur.monPagination.setCurrentPageIndex(6);
            AccueilMediateur.commutateur.AllerPortfolio();
        });
        /***********************************************************************************/
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
            line4.setStyle("-fx-stroke: #d7d6d6");
        });
        ParametresButton.setOnMouseClicked(event -> {
            // AccueilMediateur.monPagination.setCurrentPageIndex(2);
            AccueilMediateur.commutateur.AllerParametres(event);
        });
        /***********************************************************************************/
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
            line5.setStyle("-fx-stroke: #d7d6d6");
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
        logOut.setOnMouseClicked(event -> {
            AccueilMediateur.commutateur.Déconnecter(event);
        });
        /*********************************************************************************
         SwitchButton.setOnAction(e->{
         try {
         SwtichScene(e);
         } catch (IOException ex) {
         ex.printStackTrace();
         }
         });
         /***********************************************************************************
         AccueilButton.setOnAction(e->{
         try{
         GoToAccueil(e);
         } catch(Exception ex){
         ex.printStackTrace();
         }
         });
         /***************************************************************************************
         PortfolioButton.setOnAction(e->{
         try{
         GoToPortfolio(e);
         }
         catch (IOException ex){
         ex.printStackTrace();
         }
         });
         /***************************************************************************************/
        Next.setOnMouseClicked(e -> {
            NextPag();
        });

        Previous.setOnMouseClicked(e -> {
            PreviousPag();
        });

        PortModel1.setOnMouseClicked(e -> {
            try {
                if(pagination.getCurrentPageIndex() == 0) modele = 1;
                if(pagination.getCurrentPageIndex() == 1) modele = 3;
                System.out.println("le modele choisi en portfolio1 est :"+modele);
                Preview(e, pagination.getCurrentPageIndex());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        PortModel2.setOnMouseClicked(e -> {
            try {
                if(pagination.getCurrentPageIndex() == 0) modele = 2;
                Preview(e, pagination.getCurrentPageIndex());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        DeconnexionBut.setOnMouseClicked(e -> {
            try {
               AccueilMediateur.commutateur.Déconnecter(e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Currentpag = pagination.getCurrentPageIndex();

    }

    public AnchorPane CreatePage(int pageIndex) {
        AnchorPane pane = new AnchorPane();
        if (pageIndex == 0) {
            PortModel1.setLayoutX(0);
            PortModel1.setLayoutY(20);
            PortModel2.setLayoutX(238);
            PortModel2.setLayoutY(20);
            PortModel1.setImage(image1);
            PortModel2.setImage(image2);
            pane.getChildren().addAll(PortModel1, PortModel2);
            return pane;
        }
        if (pageIndex == 1) {
            PortModel1.setLayoutX(0);
            PortModel1.setLayoutY(20);
            PortModel1.setImage(image3);
            pane.getChildren().addAll(PortModel1);
            return pane;
        }
        return null;
    }

    public void CreatePag() {
        pagination.setPageCount(nbrPag);
        //pagination.setCurrentPageIndex(Currentpag);
        pagination.setPageFactory((Integer pageIndex) -> CreatePage(pageIndex));
        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        pagination.getStylesheets().add("/css/PortfolioPag.css");
    }

    public void NextPag() {
        pagination.setCurrentPageIndex((pagination.getCurrentPageIndex() + 1) % nbrPag);
    }

    public void PreviousPag() {
        pagination.setCurrentPageIndex((pagination.getCurrentPageIndex() + 1) % nbrPag);
    }

    public void Preview(MouseEvent event, int numPag) throws IOException {
        //faire une mise à jour pour la liste
        AccueilMediateur.utilisateur= Utilisateur.deserialization(AccueilMediateur.studentFolder);
        FXMLLoader loader = null;
            loader = new FXMLLoader(getClass().getResource("/views/PortfolioModel1View.fxml"));
            try {
                if(AccueilMediateur.memory.get(4)!=null) {
                    AccueilMediateur.memory.remove(4);
                }
                AccueilMediateur.memory.add(4,loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            AccueilMediateur.monPagination.setCurrentPageIndex(4);
    }
}
/*195 80 gridPane ScrPane*/